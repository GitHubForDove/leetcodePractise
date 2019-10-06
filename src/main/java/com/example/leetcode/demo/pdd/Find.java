package com.example.leetcode.demo.pdd;


/**
 *

 产品经理小梅喜欢和他的男朋友小白一块玩扑克游戏。每一局，小梅抽取N张扑克牌，自左向右依次排列在桌面上；小白也抽取M（8>=N>=M>=1）张扑克牌，自左向右依次排列在桌面上。
 小梅需要进行N个回合，使用手中的扑克牌，组成一个新的扑克牌的序列每个回合，小梅有d、l、r三种策略
 选择d时，小梅将最左边的扑克牌丢弃
 选择l时，小梅将最左边的扑克牌取出，放到新的扑克牌序列的最左边
 选择r时，小梅将最左边的扑克牌取出，放到的扑克牌序列的最右边
 N个回合完成，新的扑克牌序列与小白的扑克牌完全样（只考虑数字，不考虑花色），则小梅胜出
 小梅向程序员小岛提了一个需求，希望了解获胜的全部方法。简化起见扑克牌仅包合1-9。
 */

import java.util.*;

/**
 * 作者：jahentao
 链接：https://www.nowcoder.com/discuss/242989?type=1
 来源：牛客网

 输入描述：

 首先，输入数字S，作为局数（1<=10）每一局，分别输入两行字符串，分别代表小梅的抽取的扑克牌（从左向右排列）和小白抽取到的扑克牌（从左向右排列）
 输出描述：

 对于每一局，在开始和结束，分别输出{和}输出获胜的方法，回合策略的结尾输出一个空格。若存在多个获胜方法，请按字典序的升序输出。
 示例1

 输入：

 3
 123
 3
 123
 321
 45
 67
 输出：

 {
 d d l
 d d r
 }
 {
 l l l
 r l l
 }
 {
 }
 */
public class Find {

    static List<String> res;
    static Stack<String> road;

    public static void find(String origin, String now, String target) {
        if (target.equals(now)) {
            String tempStr = "";

            if (origin.length() >= 0) {

                Iterator it = road.iterator();
                while (it.hasNext()) {
                    tempStr +=  it.next();
                    tempStr += " ";
                }
                tempStr = tempStr.substring(0, tempStr.lastIndexOf(" "));
            }
            res.add(tempStr);

            return;
        }

        if (origin == null || origin.length() == 0) {
            return;
        }

        String left = String.valueOf(origin.charAt(0));
        String norigin = origin.substring(1);

        // 暴力递归，DFS求解

        road.push("d");
        find(norigin, now, target);
        road.pop();

        road.push("l");
        find(norigin, left + now, target);
        road.pop();

        road.push("r");
        find(norigin, now + left, target);
        road.pop();
    }

    public static void printResult() {
        System.out.println("{");
        if (res.isEmpty()) {
            System.out.println("}");
            return;
        } else {
            res.sort((o1, o2) -> 01 - 02);
            for (int i=0; i < res.size(); i++) {
                String s = res.get(i);
                System.out.println(s);
            }
        }

        System.out.println("}");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i=0; i<n;i++) {
                String num1 = sc.next();
                String num2 = sc.next();
                res = new ArrayList<>();
                road = new Stack<>();
                find(num1, "", num2);
                printResult();
            }

        }
    }
}
