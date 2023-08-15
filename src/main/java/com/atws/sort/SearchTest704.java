package com.atws.sort;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class SearchTest704 {
    public static void main(String[] args) {
        int arr[] = {-1,0,3,5,9,12};
        int target = 10;
        System.out.println(new SearchTest704().search(arr,target));

    }

    /**
     * 二分查找,循环方式实现
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle;
        while (left <= right) {
            //另外声明一下，计算 mid 时需要防止溢出，代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，但是有效防止了 left 和 right 太大直接相加导致溢出。
//            middle = (left+right)/2;
            middle = left + (right-left)/2;
            if (target==nums[middle]){
                return middle;
            }else if (target>nums[middle]){
                left = middle+1;//注意：+1
            }else {
                right = middle-1;//注意：-1，不然会死循环
            }
        }
        return -1;
    }
}
