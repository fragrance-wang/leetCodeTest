package com.atws.bit;

/**
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *          示例 1：
 *
 *          输入：x = 1, y = 4
 *          输出：2
 *          解释：
 *          1   (0 0 0 1)
 *          4   (0 1 0 0)
 *                 ↑   ↑
 *          上面的箭头指出了对应二进制位不同的位置。
 */
public class Test461 {
    public static void main(String[] args) {
        int i = new Test461().hammingDistance(1577962638, 1727613287);
        System.out.println(i);
    }

    /**
     * 思路：先让 x异或y ，得出z，又转换成了求z的二进制中1的个数了
     */
    public int hammingDistance(int x, int y) {
        int z = x^y;
      /*  //如果z过大，那么就会造成开辟数组过大，占用内存过高，内存溢出
        int[] ints = new int[z+1];
        ints[0] = 0;
        if (z>0) {
            for (int i = 1; i <= z; i++) {
                ints[i] = ints[i & (i-1)]+1;
            }
        }
        return ints[z];*/

        //所以采用while循环方式
        int res =0;
        while ( z!=0){
            z &= z -1;
            res++;
        }
        return res;
    }
}
