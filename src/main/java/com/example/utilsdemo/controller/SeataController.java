package com.example.utilsdemo.controller;

import com.example.utilsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xy
 * @Date: 2025-04-23 15:04
 * @Description:
 */
@RequestMapping(value = "user")
@RestController
public class SeataController {
    @Autowired
    private UserService userService;

    @GetMapping("getOrderNo")
    public String getOrderNo(String userId, String tenantId, HttpServletRequest request){
        return userService.getOrderNo(userId,tenantId,request);
    }
}
