package com.atws.bit;

public class Test136 {
    public static void main(String[] args) {

        // System.out.println(0^2);
    }

    public int singleNumber(int[] nums) {
        // 0 异或 任何数都是它本身
        int result =0;
        for (int i=0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
