package com.example.leetcode.demo.DataStructure;


/**
 * 前缀树
 */
public class Trie {


    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public  void insert(String word) {
        TrieNode node = root;

        for (int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }

            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /**
     * 查找前缀
     */
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char currentLetter = word.charAt(i);
            if (node.containsKey(currentLetter)) {
                node.get(currentLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        TrieNode node = new TrieNode();

        Trie trie = new Trie();

    }


}
