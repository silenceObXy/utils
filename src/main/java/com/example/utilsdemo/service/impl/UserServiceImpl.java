package com.example.utilsdemo.service.impl;

import com.example.utilsdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author: xy
 * @Date: 2025-04-23 16:01
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService, Iterator {
    @Override
    public String getOrderNo(String userId, String tenantId, HttpServletRequest request) {
        System.out.println("进来了");
        return "O111111111111";
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
