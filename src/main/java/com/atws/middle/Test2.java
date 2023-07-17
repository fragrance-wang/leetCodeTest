package com.atws.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串:
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 题解地址： https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/javati-jie-3wu-zhong-fu-zi-fu-de-zui-chang-zi-chua/
 *
 * @author wangshan
 * @date 2023-07-05 上午10:56
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String str = "pwwkew";
        int i = test2.lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        Set<Character> cache = new HashSet<>();
        int maxLength = 0;
        int length = s.length();
        int leftIndex = 0;
        int rightIndex = -1;
        for (int i = 0; i < length; i++) {
            leftIndex = i;//i相当于左下标
            if (i != 0) {
                cache.remove(s.charAt(i-1));
            }
            while (rightIndex+1 < length && !cache.contains(s.charAt(rightIndex+1))) {
                cache.add(s.charAt(rightIndex+1));
                rightIndex++;
            }
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }
        return maxLength;
    }
}
