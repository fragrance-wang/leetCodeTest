package com.atws.sort;

import java.util.Arrays;

/**
 * 快速排序: https://pdai.tech/md/algorithm/alg-sort-x-fast.html
 * 从数列中挑选一个基本值
 *
 * 力扣912
 */
public class QuickSortTest912 {
    public static void main(String[] args) {
        int arr[] = {-2, 3, -5};
        QuickSortTest912 quickSort = new QuickSortTest912();
        int[] ints = quickSort.sortArray(arr);
        System.out.println(Arrays.toString(ints));

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {//终止条件，分支数组中只有一个元素
            return;
        }
        int i = left;
        int j = right;
        int x = arr[i];

        while (i < j) {
            //定位小于等于x的数组下标
            while (i < j && arr[j] > x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //定位大于等于x的数组下标
            while (i < j && arr[i] < x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //最终，i==j
        arr[i] = x;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    //升序排列,自己实现的能跑通的案例
    public static void quickSortOwn(int[] arr, int left, int right) {
        if (left >= right) {//终止条件，分支数组中只有一个元素
            return;
        }
        //中轴值
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        int l = left;
        int r = right;
        int temp;
        while (left < right) {
            //找到大于等于pivot的数
            while (arr[left] < pivot) {
                left++;
            }
            //找到小于等于pivot的数
            while (arr[right] > pivot) {
                right--;
            }

            if (left == pivotIndex && right == pivotIndex) {
                break;
            }

            //交换
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            if (left == pivotIndex) {
                pivotIndex = right;
                left++;
                continue;
            }
            if (right == pivotIndex) {
                pivotIndex = left;
                right--;
                continue;
            }
            //交换完后
            left++;
            right--;
        }
        quickSort(arr, l, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, r);

    }

}
