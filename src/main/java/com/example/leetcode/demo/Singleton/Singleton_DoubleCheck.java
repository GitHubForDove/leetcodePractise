package com.example.leetcode.demo.Singleton;


/**
 * 双重检验锁 单例模式
 */
public class Singleton_DoubleCheck {

    private static volatile Singleton_DoubleCheck INSTANCE;

    Singleton_DoubleCheck() {

    }

    public static Singleton_DoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton_DoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton_DoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
