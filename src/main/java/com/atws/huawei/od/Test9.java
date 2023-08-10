package com.atws.huawei.od;

import java.util.Scanner;

/**
 * 出租车计费
 * 题目
 * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
 * 比如：
 * <p>
 * 23再多一块钱就变为25；
 * 39再多一块钱变为50；
 * 399再多一块钱变为500；
 * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 * 给出计费表的表面读数，返回实际产生的费用。
 * <p>
 * 输入
 * 只有一行，数字 N，表示里程表的读数。
 * (1 <= N <= 888888888)。
 * <p>
 * 输出
 * 一个数字，表示实际产生的费用。以回车结束。
 * <p>
 * 示例一
 * 输入
 * 5
 * 输出
 * 4
 * 说明
 * 5表示计费表的表面读数。
 * 表示实际产生的费用其实只有4块钱。
 * <p>
 * 示例二
 * 输入
 * 17
 * 输出
 * 15
 * 说明
 * 17表示计费表的表面读数。
 * 15表示实际产生的费用其实只有15块钱。
 * <p>
 * 示例三
 * 输入
 * 100
 * 输出
 * 81
 * 说明
 * 100表示计费表的表面读数，81表示实际产生的费用其实只有81块钱
 * <p>
 * 解题思路
 * 从控制台读取输入，计算出从 1 到输入数字之间，不包含 4 的数字的个数，最后输出满足条件的结果。代码使用了数学计算和编程技巧来实现代码逻辑，考察了数学运算、算法和编程技巧等知识点。
 *
 * @author wangshan
 * @date 2023-08-04 11:33
 */
public class Test9 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            pay(n);
        } catch (Exception e) {
            System.out.println("input error");
            e.printStackTrace();
        }
    }

    public static void pay(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!String.valueOf(i).contains("4")) {
                result++;
            }
        }
        System.out.println(result);
    }
}
