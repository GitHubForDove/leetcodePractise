package com.example.leetcode.demo.VMWARE;

import java.util.Scanner;

public class Question1 {


    /**
     * 西西是个十足的拖延症患者，因为拖延症太严重，所以根本就没有复习期末考试。
     * 面对着期末试卷抓耳挠腮的他，啥都不会，有些手足无措。
     * 这张试卷有 n 道单项选择题，第 i 道单项选择题有Ai个选项，答对了得1分，答错不得分。
     * 如果西西全靠瞎蒙，他的期望得分是多少分。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<arr.length;i++) {
                arr[i] = sc.nextInt();
            }

            double sum = 0;
            for (int j=0; j<arr.length; j++) {
                sum += (double) 1 / (double) arr[j];
            }

            System.out.println(String.format("%.2f", sum));
        }
    }
}
