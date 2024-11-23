package com.good.day.content.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadFactory {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                20,                  // 核心线程数
                60,                  // 最大线程数
                60L,                 // 空闲线程存活时间
                TimeUnit.SECONDS,    // 时间单位
                new LinkedBlockingQueue<>(100), // 工作队列
                new java.util.concurrent.ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("custom-thread-pool-" + t.getId());
                        return t;
                    }
                },
                new RejectedExecutionHandler() { // 拒绝策略
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        // 处理拒绝任务的逻辑
                        System.out.println("Task " + r.toString() + " rejected from " + executor.toString());
                    }
                }
        );
    }
}
