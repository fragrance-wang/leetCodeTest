package com.atws.simple;

/**
 * 剑指offer 10 斐波那契额数列（和爬楼梯很相似，只不过n的取值不同）
 * 定义：
 * f(n) = 0,n=0
 * f(n) = 1,n=1
 * f(n) = f(n-2)+f(n-1),n>1
 * <p>
 * 写一个函数，输入n，求斐波那契数列的第n项
 */
public class Offer10 {
    public static void main(String[] args) {
        int sub = sub(4);
        System.out.println(sub);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int sub(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public static int sub1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 0;
        int prePre = 0;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public static int sub2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return sub(n - 2) + sub(n - 1);
    }
}
