package com.example.leetcode.demo.DesignModel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    private static final int CAPACITY = 5;

    public static class Producer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i=0;

        public Producer(String name, Queue<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }


        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out.println("Queue is full, Producer[" + name + "] thread waiting for"
                                    + "consumer to take something from queue.");
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    System.out.println("[" + name + "] Producer value:+" + i);
                    queue.offer(i++);
                    queue.notifyAll();

                    try {
                        // 睡眠一段时间
                        Thread.sleep(new Random().nextInt(1000));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            this.queue = queue;
            this.name = name;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                            queue.wait();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                int x = queue.poll();
                System.out.println("[" + name + "] Consuming value : " + x);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new Producer("P-1", queue, CAPACITY);
        Thread producer2 = new Producer("P-2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue, CAPACITY);
        Thread consumer2 = new Consumer("C2", queue, CAPACITY);
        Thread consumer3 = new Consumer("C3", queue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
