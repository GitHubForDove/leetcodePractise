package com.example.leetcode.demo.DiDi;

import java.util.Scanner;
public class Question1 {


    public static int  solution(int [] num,int m,int n){
        if(num.length<=0){
            return 0;
        }
        for(int i=1;i<n;i++){
            num[i] = num[i-1] + num[i];
        }

        int re = num[m-1];
        for(int i=m;i<n;i++){
            re= re < num[i] ? re : num[i];
            for(int j=i-m;j>=0;j--){
                re= re < num[i]-num[j] ? re : num[i]-num[j];
            }

        }

        return re;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        System.out.println(solution(num,m,n));

    }
}
