package com.example.utilsdemo.satoken;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xy
 * @Date: 2025-05-13 11:22
 * @Description:
 */
@RestController
@RequestMapping("/acc/")
public class TokenController {
    // 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    // 登录校验：只有登录之后才能进入该方法
    @SaCheckLogin
    @RequestMapping("info")
    public String info() {
        return "查询用户信息";
    }

    // 角色校验：必须具有指定角色才能进入该方法
    @SaCheckRole("super-admin")
    @RequestMapping("addAd")
    public String addByAdmin() {
        return "用户增加";
    }

    // 权限校验：必须具有指定权限才能进入该方法
//    @SaCheckPermission("user-add")
//    @RequestMapping("add")
//    public String addByManege() {
//        return "用户增加";
//    }

    // 二级认证校验：必须二级认证之后才能进入该方法
    @SaCheckSafe()
    @RequestMapping("add")
    public String addX() {
        return "用户增加";
    }

    // Http Basic 校验：只有通过 Http Basic 认证后才能进入该方法
//    @SaCheckHttpBasic(account = "sa:123456")
//    @RequestMapping("add")
//    public String add() {
//        return "用户增加";
//    }

    // Http Digest 校验：只有通过 Http Digest 认证后才能进入该方法
//    @SaCheckHttpDigest(value = "sa:123456")
//    @RequestMapping("add")
//    public String add() {
//        return "用户增加";
//    }

    // 校验当前账号是否被封禁 comment 服务，如果已被封禁会抛出异常，无法进入方法
//    @SaCheckDisable("comment")
//    @RequestMapping("send")
//    public String send() {
//        return "查询用户信息";
//    }

    // 注解式鉴权：只要具有其中一个权限即可通过校验
    @RequestMapping("atJurOr")
    @SaCheckPermission(value = {"user-add", "user-all", "user-delete"}, mode = SaMode.OR)
    public SaResult atJurOr() {
        return SaResult.data("用户信息");
    }


}
