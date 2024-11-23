package com.good.day.content.controller;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description
 * @author Mr.M
 * @date 2022/10/7 16:22
 * @version 1.0
 */

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseBaseInfoController {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @GetMapping("/get")
    public String get (){
        long begin = System.currentTimeMillis();
        System.out.println(thread1());
        System.out.println(thread2());
        long end = System.currentTimeMillis();
        log.info("方法执行了{}毫秒",(end - begin));
        return "hello world";
    }

    @GetMapping("/improve/get")
    public List<String> improve (){
        long begin = System.currentTimeMillis();
//1
        Future<List<String>> submit = threadPoolExecutor.submit(() -> {
            ArrayList<String> list = new ArrayList<>();
            String result1 = thread1();
            String result2 = thread2();
            Collections.addAll(list, result1, result2);
            return list;
        });

//2
        ArrayList<String> list = new ArrayList<>();
        try {
            List<String> stringList = submit.get();
            list.addAll(stringList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        log.info("方法执行了{}毫秒",(end - begin));
        return list;
    }
    public String thread1(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello world";
    }
    public String thread2(){
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hahaha";
    }
}
