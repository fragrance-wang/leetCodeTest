package com.atws.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangshan
 * @date 2023-07-12 上午10:59
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int i = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int j=0;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
