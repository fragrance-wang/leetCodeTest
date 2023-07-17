package com.atws.middle;

import java.util.*;

/**
 * @author wangshan
 * @date 2023-07-11 下午3:40
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(test);
        System.out.println(lists);
    }

    class NoRepeat{
        Integer a;
        Integer b;
        Integer c;

        public NoRepeat(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NoRepeat)) return false;
            NoRepeat noRepeat = (NoRepeat) o;
            return Objects.equals(a, noRepeat.a) &&
                    Objects.equals(b, noRepeat.b) &&
                    Objects.equals(c, noRepeat.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Set<NoRepeat> repeatSet = new HashSet<>();
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int leftIndex;
        int rightIndex;
        int sumTemp;
        for (int i = 0; i < length; i++) {
            leftIndex = i + 1;
            rightIndex = length - 1;
            while (leftIndex < rightIndex) {
                sumTemp = nums[i] + nums[leftIndex] + nums[rightIndex];
                if (sumTemp > 0) {
                    rightIndex--;
                } else if (sumTemp < 0) {
                    leftIndex++;
                } else {
                    NoRepeat noRepeat = new NoRepeat(nums[i],nums[leftIndex],nums[rightIndex]);
                    if (!repeatSet.contains(noRepeat)){
                        repeatSet.add(noRepeat);
                        result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                    }
                    //找到答案时，双指针同时收缩
                    rightIndex--;
                    leftIndex++;
                }
            }
        }
        return result;
    }
}
