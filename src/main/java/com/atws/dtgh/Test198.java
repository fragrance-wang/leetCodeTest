package com.atws.dtgh;

import java.util.Arrays;

/**
 * 打家劫舍1
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约
 * 因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷间入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]    输出：4
 * 输入：[2,7,9,3,1〕 输出：12
 * 输入：[2,1,1,2]    输出：4
 *
 * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k(k>2) 间房屋，有两个选项：
 * 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
 * 不偷窃第 k 间房屋，偷窃总金额为前 k−1间房屋的最高总金额。
 * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 k 间房屋能偷窃到的最高总金额。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/house-robber/solutions/263856/da-jia-jie-she-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author wangshan
 * @date 2023-08-28 12:19
 */
public class Test198 {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,1};
        System.out.println(MaxMoney(array));
    }

    static int MaxMoney(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
