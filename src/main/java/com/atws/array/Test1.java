package com.atws.array;

/**
 * https://leetcode.cn/problems/two-sum/
 * 两数之和问题
 * @author wangshan
 * @date 2023-07-06 下午4:44
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test3 = new Test1();
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        int target = 26;
        int[] ints = test3.twoSum(nums, target);
        System.out.println(ints[0] + " , " + ints[1]);
    }

    //暴力破解法，还有一种hashMap方式，复杂度降低
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
