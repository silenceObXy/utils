package com.example.utilsdemo.es.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xy
 * @Date: 2023-12-04 14:54
 * @Description:
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private String name;

    private String desc;
}
