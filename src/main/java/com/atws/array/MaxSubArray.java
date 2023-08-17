package com.atws.array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/solutions/9058/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
 *
 * @author wangshan
 * @date 2023-07-04 下午2:09
 */
public class MaxSubArray {
    public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-1, 0, -2};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 动态规划，挺好
     * 本题接的重点在「关键 1：理解题意」和「关键 2：如何定义子问题（如何定义状态）」和「最后再谈谈「无后效性」。
     * <p>
     * 关键 1：理解题意
     * <p>
     * 题目要我们找出和最大的连续子数组的值是多少，「连续」是关键字，连续很重要，不是子序列。
     * <p>
     * 题目只要求返回结果，不要求得到最大的连续子数组是哪一个。这样的问题通常可以使用「动态规划」解决。
     * <p>
     * 关键 2：如何定义子问题（如何定义状态）
     * <p>
     * 设计状态思路：把不确定的因素确定下来，进而把子问题定义清楚，把子问题定义得简单。动态规划的思想通过解决了一个一个简单的问题，进而把简单的问题的解组成了复杂的问题的解。
     * <p>
     * 友情提示：上面这句话大家姑且这么一看，脑子里有个印象，没有那么绝对。可能不同的人看会有不同的理解。如果我以后讲解的动态规划的设计思想与这里讲解的「设计状态思路」不一样的，我会再和大家说明。如果讲解有误导的地方，还请大家指出。，
     * <p>
     * 我们不确定的是：−3-3−3 是连续子数组的第几个元素。那么我们就把 −3-3−3 定义成连续子数组的最后一个元素。在新的定义下，我们列出子问题如下：
     * <p>
     * 子问题 1：以 −2 结尾的连续子数组的最大和是多少；
     * 子问题 2：以 1 结尾的连续子数组的最大和是多少；
     * 子问题 3：以 −3 结尾的连续子数组的最大和是多少；
     * 子问题 4：以 4 结尾的连续子数组的最大和是多少；
     * 子问题 5：以 −1 结尾的连续子数组的最大和是多少；
     * 子问题 6：以 2 结尾的连续子数组的最大和是多少；
     * 子问题 7：以 1 结尾的连续子数组的最大和是多少；
     * 子问题 8：以 −5 结尾的连续子数组的最大和是多少；
     * 子问题 9：以 4 结尾的连续子数组的最大和是多少。
     * 我们加上了「结尾的」，这些子问题之间就有了联系。
     * 如果编号为 i 的子问题的结果是负数或者 0 ，那么编号为 i + 1 的子问题就可以把编号为 i 的子问题的结果舍弃掉
     * dp[i]=max{nums[i],dp[i−1]+nums[i]}
     */
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sumMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            sumMax = Math.max(sumMax, temp);
            int j = i + 1;
            while (j < nums.length) {
                temp += nums[j];
                if (temp > sumMax) {
                    sumMax = temp;
                }
                j++;
            }
            sumMax = Math.max(sumMax, temp);
        }
        return sumMax;
    }
}
