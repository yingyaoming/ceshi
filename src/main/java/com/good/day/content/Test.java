package com.good.day.content;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Test {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(HttpUtil.get("http://localhost:63051/api/course/improve/get"));
        }
        //System.out.println(HttpUtil.get("http://localhost:63051/api/course/improve/get"));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);


        // 读取输入
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数（int类型）: ");
        int number = scanner.nextInt();

        // 调用方法计算1的个数
        int count = Integer.bitCount(number);

        // 输出结果
        System.out.println("对应的2进制是: " + Integer.toBinaryString(number));
        System.out.println("总共有 " + count + " 个1");*/
        System.out.println("测试冲突1");
        System.out.println("测试冲突分支2");
        System.out.println("测试冲突分支2修改");
        System.out.println("测试冲突分支2修改1");
    }


    }
