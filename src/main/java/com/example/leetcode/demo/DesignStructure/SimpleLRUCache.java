package com.example.leetcode.demo.DesignStructure;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript LRU 实现
 */
    public class SimpleLRUCache<K, V> {

    private final int MAX_CACHE_SIZE;

    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    LinkedHashMap<K, V> map;

    public SimpleLRUCache(int cacheSize) {

        MAX_CACHE_SIZE = cacheSize;

        int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;

        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {

            private static final long serialVersionUID = 1L;

            @Override

            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

                return size() > MAX_CACHE_SIZE;

            }

        };

    }

    public synchronized void put(K key, V value) {

        map.put(key, value);

    }

    public synchronized V get(K key) {

        return map.get(key);

    }

    public synchronized void remove(K key) {

        map.remove(key);

    }

    public synchronized Set<Map.Entry<K, V>> getAll() {

        return map.entrySet();

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<K, V> entry : map.entrySet()) {

            stringBuilder.append(String.format("%s: %s ", entry.getKey(), entry.getValue()));

        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        SimpleLRUCache simpleLRUCache = new SimpleLRUCache(5);
        simpleLRUCache.put(1,"name");
        simpleLRUCache.put(2,"ID");
        simpleLRUCache.put(3,"Sex");
        System.out.println(simpleLRUCache);
        simpleLRUCache.put(4,"Phone");
        simpleLRUCache.put(5,"Email");
        simpleLRUCache.put(6,"Ip");
        System.out.println(simpleLRUCache);


    }

}
