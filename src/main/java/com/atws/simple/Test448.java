package com.atws.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/
 * 448. 找到所有数组中消失的数字
 */
public class Test448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        // [1,n]都-1，正好包含了数组的所有下标，让所有下标的位置都乘以负数，比如-1，如果下标值小于0，代表该()下标+1)在数组中出现过
        int temp;
        for (int i = 0; i < nums.length; i++) {
            // if(nums[i]<0){
            //     temp = (-1)*(nums[i])-1;
            // }else{
            //     temp = nums[i]-1;
            // }
            //改进，取绝对值
            temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                // nums[temp] = (-1)*nums[temp]; // 改进，简化
                nums[temp] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
