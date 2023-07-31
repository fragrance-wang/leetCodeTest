package com.atws.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 * 核心：并不需要判断每个s1的排序情况，
 * 只需要判断每个字符串出现的次数即可
 *
 * @author wangshan
 * @date 2023-07-17 上午10:28
 */
public class CheckInclusionTest {

    public static void main(String[] args) {
        CheckInclusionTest checkInclusionTest = new CheckInclusionTest();
        boolean b = checkInclusionTest.checkInclusion("ab", "eidbaooo");
//        System.out.println(b);



        String str = "abcd";
        System.out.println(str.charAt(0)-'a');

        Arrays.equals(new int[3],new int[4]);
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = cache.getOrDefault(c, 0);
            cache.put(c, count + 1);
        }
        int size = s1.length() - 1;
        int j;

        Map<Character, Integer> cacheSize = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            j = i + size;
            if (j >= s2.length()) {
                break;
            }
            for (int k = i; k <= j; k++) {
                char c = s2.charAt(k);
                Integer count = cacheSize.getOrDefault(c, 0);
                cacheSize.put(c, count + 1);
            }
            boolean flag = true;
            if (cache.size() == cacheSize.size()) {
                Set<Map.Entry<Character, Integer>> entries =
                        cache.entrySet();
                for (Map.Entry<Character, Integer> entry : entries) {
                    Integer value = entry.getValue();
                    if (!value.equals(cacheSize.getOrDefault(entry.getKey(), -1))) {
                        flag = false;
                        cacheSize.clear();
                        break;
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                return true;
            }
            cacheSize.clear();
        }
        return false;
    }
}
