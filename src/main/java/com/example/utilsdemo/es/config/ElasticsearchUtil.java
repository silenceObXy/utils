package com.example.utilsdemo.es.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.AliasMetadata;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: xy
 * @Date: 2023-12-04 14:37
 * @Description:
 */
@Slf4j
@Component
public class ElasticsearchUtil {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        //设置授权
        //builder.addHeader("Authorization", "Bearer " + TOKEN);
        //自定义消费响应
        //builder.setHttpAsyncResponseConsumerFactory(
        //new HttpAsyncResponseConsumerFactory
        //.HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

    /**
     * 创建索引
     *
     * @param elasticsearchIndex
     * @throws IOException
     */
    public void createIndex(ElasticsearchIndex elasticsearchIndex) throws IOException {
        if (elasticsearchIndex == null) {
            return;
        }
        IndexRequest indexRequest = new IndexRequest(elasticsearchIndex.getIndex());
        indexRequest.id(elasticsearchIndex.getId());
        //注意：json方式存入
        indexRequest.source(elasticsearchIndex, XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, COMMON_OPTIONS);
        log.info("create es index success, response：{}", indexResponse);
    }

    /**
     * 判断索引是否存在
     *
     * @param index
     * @return
     * @throws IOException
     */
    public void existsIndex(String index) throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(index);
        GetIndexResponse response = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        Map<String, List<AliasMetadata>> aliases = response.getAliases();
        Map<String, MappingMetadata> mappings = response.getMappings();
        Map<String, Settings> settings = response.getSettings();
        log.info("aliases:{},mappings:{},settings:{}", aliases, mappings, settings);
    }

    /**
     * 删除索引
     *
     * @param index
     */
    public void deleteIndex(String index) {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        try {
            AcknowledgedResponse response = restHighLevelClient.indices().delete(request, COMMON_OPTIONS);
            boolean acknowledged = response.isAcknowledged();
            log.info("删除结果为：{},索引为：{}", acknowledged, index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入
     *
     * @param index
     * @param id
     */
    public void insertDoc(String index, String id) {
        IndexRequest request = new IndexRequest();

        //设置索引和id
        request.index(index).id(id);

        //创建对象
        Book book = Book.builder().name("绿皮书").desc("文化差异").build();

        request.source(JSONObject.toJSONString(book), XContentType.JSON);

        try {
            IndexResponse response = restHighLevelClient.index(request, COMMON_OPTIONS);
            String targetIndex = response.getIndex();
            String targetId = response.getId();
            DocWriteResponse.Result result = response.getResult();
            log.info("{}{}{}", targetIndex, targetId, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     */
    public void updateDoc(String index, String id) {
        UpdateRequest request = new UpdateRequest();
        request.index(index).id(id);

        //创建对象
        Book book = Book.builder().name("绿").desc("文").build();

        request.doc(JSONObject.toJSONString(book), XContentType.JSON);

        try {
            UpdateResponse response = restHighLevelClient.update(request, COMMON_OPTIONS);
            String targetIndex = response.getIndex();
            String targetId = response.getId();
            DocWriteResponse.Result result = response.getResult();
            log.info("{},{},{}", targetIndex, targetId, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查doc
     */
    public void selectDoc(String index, String id) {
        GetRequest request = new GetRequest().index(index).id(id);

        try {
            GetResponse response = restHighLevelClient.get(request, COMMON_OPTIONS);
            String targetIndex = response.getIndex();
            String targetId = response.getId();
            String type = response.getType();
            String source = response.getSourceAsString();
            log.info("{}{}{}{}", targetIndex, targetId, type, source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除doc
     */
    public void deleteDoc(String index, String id) {
        DeleteRequest request = new DeleteRequest();
        request.index(index).id(id);

        try {
            DeleteResponse response = restHighLevelClient.delete(request, COMMON_OPTIONS);
            DocWriteResponse.Result result = response.getResult();
            log.warn("{}", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量新增
     */
    public void bulkInsert(String index) {
        BulkRequest request = new BulkRequest();
        //创建对象
//        Book book = Book.builder().name("绿皮书").desc("文化差异").build();
//        request.add(new IndexRequest().index(index).id("001")
//                .source(JSONObject.toJSONString(book), XContentType.JSON));
//
//        Book book1 = Book.builder().name("肖生克的救赎").desc("自我拯救").build();
//        request.add(new IndexRequest().index(index).id("002")
//                .source(JSONObject.toJSONString(book1), XContentType.JSON));
//
//        Book book2 = Book.builder().name("当幸福来敲门").desc("坚持奋斗").build();
//        request.add(new IndexRequest().index(index).id("003")
//                .source(JSONObject.toJSONString(book2), XContentType.JSON));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan", "age", "10", "sex", "女"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi", "age", "30", "sex", "女"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu1", "age", "40", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu2", "age", "20", "sex", "女"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu3", "age", "50", "sex", "男"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "wangwu4", "age", "20", "sex", "男"));

        try {
            BulkResponse responses = restHighLevelClient.bulk(request, COMMON_OPTIONS);
            TimeValue took = responses.getTook();
            BulkItemResponse[] items = responses.getItems();
            log.info("took:{},items:{}", took, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除
     */
    public void bulkDelete() {
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("book").id("001"));
        request.add(new DeleteRequest().index("book").id("002"));
        request.add(new DeleteRequest().index("book").id("003"));


        try {
            BulkResponse responses = restHighLevelClient.bulk(request, COMMON_OPTIONS);
            TimeValue took = responses.getTook();
            BulkItemResponse[] items = responses.getItems();
            log.info("took:{},items:{}", took, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     */
    public void searchDoc(String index) {
        SearchRequest request = new SearchRequest();
        request.indices(index);

        // 构建查询的请求体
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //全量查询
        allSearch(builder);

        //条件查询
        conditionSearch(builder);

        //分页查询/查询排序
        pageAndSortSearch(builder);

        //组合查询
        combinationSearch(builder);

        //范围查询
        rangSearch(builder);

        //模糊查询
        fuzzSearch(builder);

        //高亮
        highlightSearch(builder);

        request.source(builder);

        try {
            SearchResponse response = restHighLevelClient.search(request, COMMON_OPTIONS);
            // 查询匹配
            SearchHits hits = response.getHits();
            System.out.println("took:" + response.getTook());
            System.out.println("timeout:" + response.isTimedOut());
            System.out.println("total:" + hits.getTotalHits());
            System.out.println("MaxScore:" + hits.getMaxScore());
            System.out.println("hits========>>");
            for (SearchHit hit : hits) {
                //输出每条查询的结果信息
                String sourceAsString = hit.getSourceAsString();
                System.out.println(sourceAsString);

                //打印高亮结果
//                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
//                System.out.println(highlightFields);
            }
            System.out.println("<<========");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maxSearch() {
        SearchRequest request = new SearchRequest().indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.aggregation(AggregationBuilders.max("maxAge").field("age"));

        //分组
        builder.aggregation(AggregationBuilders.terms("age_group").field("age"));
        request.source(builder);
        try {
            SearchResponse response = restHighLevelClient.search(request, COMMON_OPTIONS);
            System.out.println(response);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                //输出每条查询的结果信息
//                String sourceAsString = hit.getSourceAsString();
//                System.out.println(sourceAsString);
//
//                //打印高亮结果
//                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
//                System.out.println(highlightFields);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void highlightSearch(SearchSourceBuilder builder) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");//设置标签前缀
        highlightBuilder.postTags("</font>");//设置标签后缀
        highlightBuilder.field("name");//设置高亮字段
        builder.highlighter(highlightBuilder);
    }

    private void fuzzSearch(SearchSourceBuilder builder) {
        FuzzyQueryBuilder query = QueryBuilders.fuzzyQuery("name", "wangwu");
        builder.query(query);
    }

    private void rangSearch(SearchSourceBuilder builder) {
        RangeQueryBuilder query = QueryBuilders.rangeQuery("age");
        query.lt("40");
        builder.query(query);
    }

    private void combinationSearch(SearchSourceBuilder builder) {
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        //一定包含
        query.must(QueryBuilders.matchQuery("age", "30"));
        // 一定不含
        query.mustNot(QueryBuilders.matchQuery("name", "zhangsan"));
        // 可能包含
        query.should(QueryBuilders.matchQuery("sex", "男"));

        builder.query(query);
//        builder.query(QueryBuilders.matchAllQuery());
    }

    private void pageAndSortSearch(SearchSourceBuilder builder) {
        builder.from(0);
        builder.size(2);

        //查询排序
        builder.sort("name", SortOrder.ASC);
    }


    private void conditionSearch(SearchSourceBuilder builder) {
        builder.query(QueryBuilders.termQuery("name", "肖生克的救赎"));
//        builder.query(QueryBuilders.termQuery("desc", "文"));
//        builder.query(QueryBuilders.termQuery("sex", "女"));
    }

    private void allSearch(SearchSourceBuilder builder) {
        builder.query(QueryBuilders.matchAllQuery());
    }

}
