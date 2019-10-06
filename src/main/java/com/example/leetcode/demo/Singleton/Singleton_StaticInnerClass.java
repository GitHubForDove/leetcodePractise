package com.example.leetcode.demo.Singleton;

/**
 * 静态内部类 单例模式
 */
public class Singleton_StaticInnerClass {


    private Singleton_StaticInnerClass() {}

    private static class SingletonHolder {
        private static final Singleton_StaticInnerClass INSTANCE = new Singleton_StaticInnerClass();
    }

    public static Singleton_StaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
