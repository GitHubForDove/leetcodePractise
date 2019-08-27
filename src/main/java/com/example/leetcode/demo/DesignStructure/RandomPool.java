package com.example.leetcode.demo.DesignStructure;

import java.util.HashMap;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-06
 * @descript 设计RandomPool结构
 *
 */
public class RandomPool<k> {


    /**
     *  【题目】 设计一种结构，在该结构中有如下的三个功能：
     *          insert(key)：将某个key加到该结构，做到不重复加入。
     *          delete(key)：将原本在结构中的某个key移除。
     *          getRandom(): 等概率随机返回结构中的任何一个key。
     *  【要求】Insert、delete和getRandom方法的事件复杂度都是O(1)
     */

    /**
     * 思路： 使用双Map结构
     *       一个Map<String, Integer>
     *       一个Map<Integer, String>
     */

    public HashMap<k,Integer> keyIndexMap;
    public HashMap<Integer,k> indexKeyMap;
    public int size;

    public RandomPool() {
        this.keyIndexMap = new HashMap<k, Integer>();
        this.indexKeyMap = new HashMap<Integer, k>();
        this.size = 0;
    }

    public void  insert(k key) {
        if (!this.keyIndexMap.containsKey(key)) {
            keyIndexMap.put(key, size);
            indexKeyMap.put(size, key);
            size++;
        }

    }

    /**
     * 把最后一个值 挪到删除原来所在的地方 覆盖掉 然后将最后一个数 删除
     * @param key
     */
    public void delete(k key) {

        if (this.keyIndexMap.containsKey(key)) {
            int deleteIndex = this.keyIndexMap.get(key);
            int lastIndex = --this.size;
            k lastKey = this.indexKeyMap.get(lastIndex);
            this.keyIndexMap.put(lastKey, deleteIndex);
            this.indexKeyMap.put(deleteIndex, lastKey);
            this.keyIndexMap.remove(key);
            this.indexKeyMap.remove(lastIndex);
        }


    }


    public k getRomdom() {
        if (size == 0) {
            return null;
        }

        int randomIndex = (int)(Math.random() * this.size); // 0 ~ size-1

        return this.indexKeyMap.get(randomIndex);
    }







}
