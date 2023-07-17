package com.atws.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangshan
 * @date 2023-07-12 上午10:43
 */
public class IntersectionTest {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++){
            if (set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] ints = new int[result.size()];
        AtomicInteger i=new AtomicInteger(0);
        result.forEach(e->{
            ints[i.getAndIncrement()]=e;
        });
        return ints;
    }
}
