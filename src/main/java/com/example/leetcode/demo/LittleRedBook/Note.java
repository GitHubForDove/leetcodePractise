package com.example.leetcode.demo.LittleRedBook;


import java.util.Scanner;

public class Note {


    public static String note(String str) {

        if (str == null || str.length() ==0) {
            return "";
        }
        int index = str.lastIndexOf(")");
        if (index == str.length()-1) {
            str = str.substring(0, str.indexOf("("));
        } else if (index != -1){
            str = str.substring(0, str.indexOf("(")) + str.substring(str.lastIndexOf(")")+1, str.length());
        }

        String newStr = "";
        for (int i=0; i<str.length() ;i++) {
            if (str.charAt(i) == '<') {
                if (newStr.length() > 0) {
                    newStr = newStr.substring(0,newStr.length()-1);
                }
                continue;
            }
            newStr += str.charAt(i);
        }
        return newStr;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String res = note(str);
            System.out.println(res);
        }
    }
}
