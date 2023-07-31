package com.atws.simple;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 买卖股票最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author wangshan
 * @date 2023-07-25 下午3:17
 */
public class MaxProfitTest {
    public static void main(String[] args) {
        MaxProfitTest maxProfitTest = new MaxProfitTest();
        int[] array = {7,6,4,3,1};
        int i = maxProfitTest.maxProfit(array);
        System.out.println(i);
    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        //第i天卖最大利润
        int[] dp = new int[length];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            dp[i] = prices[i] - minPrice;
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        int result = dp[0];
        for (int i = 1; i < length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
