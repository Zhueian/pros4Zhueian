package com.imooc.pro4pro4Interview.miaosha.controller;

import com.imooc.pro4pro4Interview.miaosha.domain.User;
import com.imooc.pro4pro4Interview.miaosha.redis.RedisService;
import com.imooc.pro4pro4Interview.miaosha.servier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.alibaba.druid.sql.dialect.oracle.ast.expr.OracleSizeExpr.Unit.T;

/**
 * @Auther: qiucy
 * @Date: 2019-05-06 20:23
 * @Description:
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","qcy");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/db/get")
    public void dbGet(){
        System.out.println("dbGet start...");
        User user = userService.getById(1);
        System.out.println(user+"!!");
    }

    @ResponseBody
    @RequestMapping("/db/TX")
    public void dbTX(){
        System.out.println("tx start..");
        try {
            userService.insert();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("exception..");
        }
        System.out.println("tx end..");
    }

    @ResponseBody
    @RequestMapping("/redis/get")
    public void redisGet(){
        System.out.println("redis get start .. ");
//        redisService.get("",Class<T> clazz);
        System.out.println("redis get end .. ");
    }

}
