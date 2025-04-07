package com.example.utilsdemo.es.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xy
 * @Date: 2023-12-04 14:46
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElasticsearchIndex {
    /**
     * 索引名字
     */
    private String index;

    /**
     * 索引类型
     */
    private String type;

    /**
     * 文档记录id
     */
    private String id;

    /**
     * 内容
     */
    private String content;

}

