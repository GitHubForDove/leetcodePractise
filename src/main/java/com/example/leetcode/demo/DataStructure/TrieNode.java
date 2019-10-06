package com.example.leetcode.demo.DataStructure;


/**
 * 前缀树：实现前缀树
 */
public class TrieNode {


    // R links to node children
    private TrieNode[] links;

    // 26个字母
    private final int R = 26;

    // 标志 是否到达最后位置
    private boolean isEnd;

    // 初始化
    public TrieNode() {
        links = new TrieNode[R];
    }


    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }


    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }





}
