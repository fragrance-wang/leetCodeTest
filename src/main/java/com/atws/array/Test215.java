package com.atws.array;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 * 1 <= k <= nums.length
 * 堆排序是最好的解决方案
 */
public class Test215 {
    public static void main(String[] args) {
        int[] array =new int[]{3,2,1,5,6,4};
        Test215 test215 = new Test215();
        // test215.quickSort(array,0, array.length-1);

        System.out.println(test215.findKthLargest(array, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums[k-1];
    }

    private void quickSort(int[] array,int left,int right) {
        if (left>right) return;
        int i = left;
        int j =right;
        int x = array[i];
        while (i < j) {
            //找到大于等于array[i]的元素
            while (i<j && array[j]<x ){
                j--;
            }
            if (i<j){
                array[i]=array[j];
                i++;
            }
            //定位小于等于x的数组下标
            while (i<j&& array[i]>x){
                i++;
            }
            if(i<j){
                array[j]=array[i];
                j--;
            }
        }
        array[i] = x;
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
    }
}
