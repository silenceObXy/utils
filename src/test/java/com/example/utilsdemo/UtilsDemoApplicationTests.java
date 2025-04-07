package com.example.utilsdemo;

import com.alibaba.fastjson.JSONObject;
import com.example.utilsdemo.es.config.Book;
import com.example.utilsdemo.es.config.ElasticsearchIndex;
import com.example.utilsdemo.es.config.ElasticsearchUtil;
import com.example.utilsdemo.thread.YesThreadPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

@SpringBootTest
class UtilsDemoApplicationTests {
    @Autowired
    private ElasticsearchUtil elasticsearchUtil;

    @Test
    void createIndex() {
        Book book = Book.builder().name("肖生克的救赎").desc("绝地求生").build();
        String content = JSONObject.toJSONString(book);
        ElasticsearchIndex index = ElasticsearchIndex.builder()
                .index("test_index").type("product").content(content).build();
        try {
            elasticsearchUtil.createIndex(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectIndex() {
        try {
            elasticsearchUtil.existsIndex("book");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void threadPool() {
        LinkedBlockingDeque<Object> blockingDeque = new LinkedBlockingDeque<>();
        YesThreadPool yesThreadPool = new YesThreadPool(3, blockingDeque);
        IntStream.rangeClosed(1,10).forEach(i -> {
            yesThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "执行任务" + i);
            });
        });
    }

    @Test
    void deleteIndex() {
        elasticsearchUtil.deleteIndex("test_index");
    }

    @Test
    void insertDoc() {
        elasticsearchUtil.insertDoc("book", "0001");
    }

    @Test
    void selectDoc() {
        elasticsearchUtil.selectDoc("book", "003");
    }

    @Test
    void updateDoc() {
        elasticsearchUtil.updateDoc("book", "001");
    }

    @Test
    void deleteDoc() {
        elasticsearchUtil.deleteDoc("book", "0001");
    }

    @Test
    void bulkInsertDoc() {
        elasticsearchUtil.bulkInsert("book");
    }

    @Test
    void bulkDeleteDoc() {
        elasticsearchUtil.bulkDelete();
    }

    @Test
    void search() {
        elasticsearchUtil.searchDoc("user");
    }

    @Test
    void maxSearch() {
        elasticsearchUtil.maxSearch();
    }
}