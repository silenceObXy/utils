package com.example.utilsdemo.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xy
 * @Date: 2025-04-23 16:00
 * @Description:
 */
public interface UserService {
    String getOrderNo(String userId, String tenantId, HttpServletRequest request);
}
