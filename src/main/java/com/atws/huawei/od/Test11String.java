package com.atws.huawei.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号
 * 从 0~N 的箱子，每个箱子上面贴有一个数字。
 * 阿里巴巴念出一个咒语数字 k(k<N)，找出连续 k 个宝箱数字和的最大值，并输出该最大值。
 * 输入描述：
 * 第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5
 * 字串中数字的个数>=1，<=100000；每个数字>=-10000，<=10000；
 * 第二行输入咒语数字，例如：4，咒语数字大小小于宝箱的个数
 * 输出描述：
 * 连续 k 个宝箱数字和的最大值，例如：39
 * 补充说明：
 * 示例 1
 * 输入：
 * 2,10,-3,-8,40,5
 * 4
 * 输出：
 * 39
 * 说明：
 * 示例 2
 * 输入：
 * 8
 * 1
 *
 * @author wangshan
 * @date 2023-08-04 10:04
 */
public class Test11String {
    public static void main(String[] args) {
        String str = "2,10,-3,-8,40,5";
        int k = 4;

        String[] split = str.split(",");
//        int[] arr = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            arr[i] = Integer.parseInt(split[i]);
//        }
        int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        int result = maxSum(arr, k);
        System.out.println(result);

    }

    public static int maxSum(int[] arr, int n) {
        int sum = 0;
        if (n <= 0 || n > arr.length) {
            return sum;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int[] sumArray = new int[arr.length];
        sumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i < n) {
                sumArray[i] = arr[i] + sumArray[i - 1];
            } else {
                sumArray[i] = arr[i] + sumArray[i - 1] - arr[i - n];
            }
        }

        for (int i = n - 1; i < sumArray.length; i++) {
            sum = Math.max(sum, sumArray[i]);
        }

        return sum;
    }


}
























