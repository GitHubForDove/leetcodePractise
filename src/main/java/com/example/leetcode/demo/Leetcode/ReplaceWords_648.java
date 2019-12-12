package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 648. 单词替换
 *
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 * 注:
 *
 * 输入只包含小写字母。
 * 1 <= 字典单词数 <=1000
 * 1 <=  句中词语数 <= 1000
 * 1 <= 词根长度 <= 100
 * 1 <= 句中词语长度 <= 1000
 *
 */
public class ReplaceWords_648 {

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.equals("") || sentence.length() == 0) {
            return sentence;
        }

        String[] strs = sentence.split(" ");
        for (int i=0; i<strs.length; i++) {
            int index = isSuccessor(dict, strs[i]);
            if (index != -1) {
                strs[i] = dict.get(index);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<strs.length; i++) {
            res.append(strs[i]);
            if (i != strs.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public int isSuccessor(List<String> dict, String str) {
        if (str == null || str.equals("") || str.length() == 0) {
            return -1;
        }

        for (int i=0; i<dict.size(); i++) {
            String val = dict.get(i);
            int index = val.length();
            String prefix = str.length() > index ? str.substring(0, index) : "";
            if (prefix.equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords_648 r = new ReplaceWords_648();
        String res = r.replaceWords(dict, sentence);
        System.out.println(res);
    }

}
