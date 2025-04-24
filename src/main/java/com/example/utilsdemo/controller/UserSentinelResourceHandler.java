package com.example.utilsdemo.controller;

import org.springframework.stereotype.Component;

/**
 * @Author: xy
 * @Date: 2025-04-24 10:37
 * @Description:
 */
@Component
public class UserSentinelResourceHandler {

    public static String sentinelAResource(Throwable throwable){
        System.out.println("触发熔断，服务不可用");
        return "触发熔断，服务不可用";
    }
}

