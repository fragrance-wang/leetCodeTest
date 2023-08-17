package com.atws.bit;

import java.util.Arrays;

/**
 * 比特位计数: 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * https://leetcode.cn/problems/counting-bits/
 */
public class Test338 {
    public static void main(String[] args) {
        System.out.println(1&1);
        System.err.println(2&1);
        System.out.println(3&1);
        Test338 test338 = new Test338();
        int[] ints = test338.countBits(5);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 方法二： 可以利用  X & (X-1) 来清除最低位的1
     *      比如：X=21,二进制位表示为：0001 0101
     *              21 & 20 =
     *              0001 0101
     *             &0001 0100
     *             -----------
     *              0001 0100 = 20
     *
     *     接下来    20 & 19 =
     *              0001 0100
     *             &0001 0011
     *             -----------
     *              0001 0000 = 16
     *
     *     接下来    16 & 15 =
     *              0001 0000
     *             &0000 1111
     *             -----------
     *              0000 0000 = 0
     *      结论：只要最后得到结果为零，那么循环的次数（即清除最低位1的个数） 即为 二进制中1的个数
     *      还可以得出 计算公式： f(x) = f(x & (x-1)) + 1
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i=1;i<=n;i++){
            result[i] = result[i & (i-1)]+1;
        }
        return result;
    }

    /**
     * 方法一：奇偶性
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
     */
    public int[] countBits1(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            //如何用位运算判断奇偶性呢？
            if ((i & 1) == 1) {//说明是奇数
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
