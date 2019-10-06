package com.example.leetcode.demo.Offer;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 和为S的连续正数序列
 */
public class FindContinuousSequence {

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     */

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 1 ) {
            return null;
        }

        for (int i=0; i<sum;i++) {
            int temp = i;
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(i);
            for (int j=i+1;j<sum;j++) {

                temp += j;
                if (temp > sum) {
                    break;
                }
                tempList.add(j);
                if (temp == sum) {
                    res.add(tempList);
                }

            }

        }

        return res;
    }


    public static void main(String[] args) {
        int sum = 100;
        ArrayList<ArrayList<Integer>> res = findContinuousSequence(sum);
        for (ArrayList list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
