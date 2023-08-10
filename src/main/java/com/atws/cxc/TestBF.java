package com.atws.cxc;

/**
 *
 * https://www.chengxuchu.com/2-algorithm_base/02-%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%8C%B9%E9%85%8D/BF.html#bf-%E5%B8%B8%E8%A7%84%E6%96%B9%E6%B3%95
 *
 *
 *
 * 题目描述
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll" 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * <p>
 * #题目解析
 * 其实这个题目很容易理解，但是我们需要注意的是一下几点，比如我们的模式串为 0 时，应该返回什么，我们的模式串长度大于主串长度时，应该返回什么，
 * 也是我们需要注意的地方。下面我们来看一下题目代码吧。
 *
 * @author wangshan
 * @date 2023-08-07 10:04
 */
public class TestBF {


    public static int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length1 < length2) {
            return -1;
        }
        if (length2 == 0) {
            return -1;
        }


        for (int i = 0; i < length1 - length2 + 1; i++) {

            int m = i;
            int n = 0;
            while (n < length2 && haystack.charAt(m) == needle.charAt(n)) {
                m++;
                n++;
            }

            if (n == length2) {
                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        int i = strStr(haystack, needle);
        System.out.println(i);

    }

}
