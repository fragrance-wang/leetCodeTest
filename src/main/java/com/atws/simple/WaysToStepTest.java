package com.atws.simple;

/**
 *
 * https://leetcode.cn/problems/three-steps-problem-lcci/description/
 * @author wangshan
 * @date 2023-07-25 下午3:41
 */
public class WaysToStepTest {


    public static void main(String[] args) {
        WaysToStepTest waysToStepTest = new WaysToStepTest();
        int result = waysToStepTest.waysToStep(10);
        System.out.println(result);

    }

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n-1];
    }
}
