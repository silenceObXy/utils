package com.example.utilsdemo.service.impl;

import com.example.utilsdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xy
 * @Date: 2025-04-23 16:01
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getOrderNo(String userId, String tenantId, HttpServletRequest request) {
        System.out.println("进来了");
        return "O111111111111";
    }
}
