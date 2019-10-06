package com.example.leetcode.demo.Offer;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转单词顺序列
 */
public class ReverseSentence {

    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */

    public static String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        String[] arr = str.split(" ");
        if (arr.length == 0) {
            return str;
        }
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size()-1) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(reverseSentence(str));
    }
}
