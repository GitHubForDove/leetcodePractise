package com.example.leetcode.demo.Leetcode;


/**
 *  leetcode 1047. 删除字符串中的所有相邻重复项
 *
 *  给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class RemoveDuplicates_1047 {

    /**
     * 使用栈的思想解决重复项的问题
     */
    public static String removeDuplicates(String S) {
        char[] stack = S.toCharArray();
        int top = -1;
        for (char c : stack) {
            if (top > -1 && stack[top] == c) {
                top--;
                continue;
            }
            stack[++top] = c;
        }
        return new String(stack, 0, top + 1);
    }

    public static void main(String[] args) {
        String str = "abbaca";
        String res = removeDuplicates(str);
        System.out.println(res);
    }
}
