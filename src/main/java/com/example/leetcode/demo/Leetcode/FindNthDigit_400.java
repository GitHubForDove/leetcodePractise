package com.example.leetcode.demo.Leetcode;

/**
 * leetcode 400. 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 示例 1
 * 输入:
 * 3
 * 输出:
 * 3
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class FindNthDigit_400 {


    /**
     * 解题思路：找出位数关系(数字个数 数字位数 当前位总位数 总位数)
     * 1 个位:9 1 1*9=9 9
     * 2 十位:90 2 2*90=180 189
     * 3 百位:900 3 3*900=2700 2889
     * 4 千位:9000 4 4*9000=36000 38889
     *
     *  ...
     *  n n位:t=910^(n-1) n nt
     *
     * 第一步：按照以上规则确定n的低一位的最大值k_min(代码中的k),以及n对应的数的位数i
     *    如：n=15( 9<n<189) k_min=9 i=1+1=2
     *    如：n=500(189<n<2889) k_min=90 i=2+1=3
     * 第二步：计算 (n-k_min)获得剩余多少位数字 (n-k_min)/i还应该加上几位数 即：temp=k_min+(n-k_min)/i
     * 第三部：当(n-k_min)%i==0 时,说明第nth数字刚好为temp的最后一位 即：temp%10
     *    否则,为temp + 1的第index=(n-k_min)%i位数字 即：String.ValueOf(temp+1).charAt(index-1)-'0'
     * 注意：防止文中的int 的溢出,当中间值为2147483647很有可能溢出
     *
     */
    public int findNthDigit(int n) {

        //总位数
        int sum_th = 0;
        //数字位数 一位 两位 三位
        int i = 1;
        //当前数值
        int k = 0;
        while(sum_th < n){
            //防止溢出
            if(sum_th + i*9*Math.pow(10,i-1) >= n){
                break;
            }
            k += 9*Math.pow(10,i-1);
            sum_th += i*9*Math.pow(10,i-1);
            i++;
        }

        //剩余数字个数
        int temp = (n - sum_th) / i;
        int mod = (n - sum_th) % i;
        k += temp;
        if(mod == 0){
            return k % 10;
        }else{
            k++;
            return String.valueOf(k).charAt(mod-1)-'0';
        }
    }

    public static void main(String[] args) {
        int n = 1000000000;
        FindNthDigit_400 fd = new FindNthDigit_400();
        int res = fd.findNthDigit(n);
        System.out.println(res);
    }
}
