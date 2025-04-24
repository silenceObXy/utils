package com.example.utilsdemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
@RequestMapping(value = "/user")
@RestController
public class SeataController {
    @Autowired
    private UserService userService;

    @GetMapping("/getOrderNo")
    @SentinelResource(value = "getOrderNoResource",blockHandler = "getOrderNoBlockHandler",blockHandlerClass = SeataController.class)
    public String getOrderNo(String userId, String tenantId, HttpServletRequest request){
        return userService.getOrderNo(userId,tenantId,request);
    }

    @GetMapping("/getOrderNoB")
    public String getOrderNoB(String userId, String tenantId, HttpServletRequest request){
        return userService.getOrderNo(userId,tenantId,request);
    }

    @GetMapping("/sentinelA")
    @SentinelResource(value = "sentinelAResource" , fallback = "sentinelAResource", fallbackClass = UserSentinelResourceHandler.class)
    public String sentinelA(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        double v = Math.random() * 10;
        if (v > 7) {
            System.out.println("异常");
            throw new RuntimeException("sentinelA");
        }
        System.out.println("我是sentinelA");
        return "我是sentinelA";
    }



    /**
     * 限流后续操作方法
     * @param e
     * @return
     */
    public static String getOrderNoBlockHandler(String userId, String tenantId, HttpServletRequest request, BlockException e){
        String msg = "不好意思，前方拥挤，请您稍后再试";
        return msg;
    }
}
