package com.example.leetcode.demo;

import java.util.Scanner;

public class Test_xinlang_question1 {

    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        if (list.length == 0) {
            return null;
        }

        String minVersion = list[0];
        boolean flag = true;

        for (int i = 1; i < list.length; i++) {

            // 判断每个字符串的版本号大小
            String[] minTempList = minVersion.split("\\.");
            String[] tempList = list[i].split("\\.");

            for (int j = 0; j < minTempList.length; j++) {
                int minVersionInt = Integer.valueOf(minTempList[j]);
                if (tempList.length <= j) {
                    break;
                }
                int tempVersionInt = Integer.valueOf(tempList[j]);

                if (minVersionInt < tempVersionInt) {
                    break;
                } else if (minVersionInt == tempVersionInt) {
                    continue;
                } else {
                    minVersion = list[i];
                    flag = false;
                }

            }

            if ((minTempList.length > tempList.length) && flag) {
                minVersion = list[i];
                flag = true;
            }

        }

        return minVersion;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            str = str.replaceAll(" ","");
            String[] versions = str.split("\\,");
            System.out.println(getMinVersion(versions));
        }
    }
}