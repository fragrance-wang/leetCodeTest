package com.atws.middle;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * @author wangshan
 * @date 2023-07-04 下午2:09
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {


        return -1;
    }
}
