package com.atws.bit;

import java.util.Scanner;

/**
 *  华为od，十进制和二进制之间的相互转换
 *
 *  0 1 2 3 4 5 6 7
 *  ! (exp) (mant)
 *  mant 是低四位
 *  exp  是高5~7位
 *
 *  位运算和进制转换
 *
 * @author wangshan
 * @date 2023-08-10 9:18
 */
public class TestBit {

    /**
     * 十进制转二进制
     */
    public static void toBinay() {
        /**
         * 第二种：利用“移位”操作实现
         *
         * 我们可以直接利用移位操作对一个十进制数进行移位操作，
         * 即：将最高位的数移至最低位（移31位），除过最低位其余位置清零，使用& 操作，可以使用和1相与（&），
         * 由于1在内存中除过最低位是1，其余31位都是零，然后把这个数按十进制输出；
         * 再移次高位，做相同的操作，直到最后一位 ，代码如下。可以说，这是我到目前为止见到的最简单的实现方式了。
         */
        int n = 17;
        for(int i = 31;i >= 0; i--)
                      System.out.print(n >>> i & 1);
    }

    /**
     * 当问到二进制数转为十进制数，大多数人脑里第一反应的应该是这样一个逻辑过程：
     * 二进制数：1010
     * 十进制数：1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 =  8 + 0 + 2 +0 = 10
     * 简单粗暴，就这么实现即可
     * 按这个思路，java代码可以这样实现：
     */
    public static void toTen(){
        String binaryStr = "10001";
        String[] split = binaryStr.split("");
        int res = 0;
        for (int i=split.length-1;i>=0;i--){
            res+= Integer.parseInt(split[i]) * Math.pow(2,i);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        toTen();
        toBinay();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        long min =-1;
        for(int i=0;i<count;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int formatB = b;
            if (b>=128){
                String string = Integer.toBinaryString(b);
                String expStr = string.substring(1,4);
                String mantStr = string.substring(4,string.length());
                int exp = Integer.parseInt(expStr, 2);
                int mant = Integer.parseInt(mantStr, 2);
                formatB = (mant | 0x10)<< (exp+3);
            }
            if (min==-1){
                min = a+formatB;
            }else {
                min = Math.min(min,a+formatB);
            }

        }
        System.out.println(min);
    }



}
