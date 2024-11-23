package com.good.day.content.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
@RequestMapping("/courseCategory")
public class CourseCategoryController {
    @GetMapping("/get")
    public String get (){
        return "hello world";
    }

}
