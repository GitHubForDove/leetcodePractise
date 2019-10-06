package com.example.leetcode.demo.DesignModel;

import java.util.concurrent.*;

public class CompletionServiceDemo {


    public static void main(String[] args) {
        ExecutorService excecutorService = Executors.newFixedThreadPool(11);

        //阻塞队列
        final BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<Future<Integer>>(10);

        // 实例化CompletionService
        final CompletionService<Integer> service = new ExecutorCompletionService<Integer>(excecutorService, queue);

        /**
         * 模拟十个进程，每个任务执行时间不一致
         */
        for (int i=0; i<10; i++) {

        }


    }
}
