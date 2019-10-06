package com.example.leetcode.demo.Offer;


import java.util.*;

/**
 *
 */
public class Solution1_XM {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static int solution(int[] prices, int budget) {

        if (budget < 1) {
            return -1;
        }
        Arrays.sort(prices);

        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int j=prices.length-1; j >= 0; j--) {
            int temp = budget;
            count = 0;
            for (int i=j; i>=0; i--) {
                if (temp >= prices[i]) {
                    while (temp >= prices[i]) {

                        count = count +  temp / prices[i];
                        temp = temp % prices[i];
                    }
                }
            }
            if (count < min) {
                min = count;
            }
        }


        if (count == 0) {
            return -1;
        }

        return min;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
