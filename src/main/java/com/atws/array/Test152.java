package com.atws.array;

/**
 * 网易一面
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数
 */
public class Test152 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
//        int[] nums = new int[]{2,3,-2,4};
        int i = new Test152().maxProduct(nums);
        System.out.println(i);
    }

    /**
     *      1 2 10  -1    20    15      -10                 2            -2                0   1  -2  3  -5    -6  7
     * max [1 2 20  -1   20   20*15    -10-->400*15*10      60000*2       -2               0   1  -2  3  -5    30   ]
     * min [1 2 20 -20  -400 -400*15    400*15*10           60000*2      -60000*4          0   1  -2 -6   30  -180  ]
     *
     *
     *
     *
     * 2 3 -2 4
     * 2 6 -2 4
     * 2 6 -12 -48
     *
     * -2 3 -4
     * -2 3 -4-->24
     * -2 -6 24
     *
     * 2,-5,-2,-4,3
     * 2,-5,10-->20,-4,3
     * 2,-10,-2,-80,-240
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int max = 0;
        int[] maxdp = new int[length];
        int[] mindp = new int[length];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int temp;
        int preMax;
        int preMin;
        for (int i = 1; i <length; i++) {
            temp = nums[i];
            preMax=maxdp[i-1];
            preMin=mindp[i-1];
            if (temp==0){
                maxdp[i] = 0;
                mindp[i] = 0;
            }else {
               maxdp[i] = Math.max(temp,temp*preMax);
               temp = temp*preMin;
               if (temp>0){
                   maxdp[i] = Math.max(maxdp[i],temp);
                   mindp[i] = temp;
               }else if (temp<0){
                   mindp[i] = Math.min(temp,preMin);
               }else {
                   mindp[i] = nums[i];
               }
            }
            max = Math.max(max,mindp[i]);
            max = Math.max(max,maxdp[i]);
        }

        return max;
    }
}
