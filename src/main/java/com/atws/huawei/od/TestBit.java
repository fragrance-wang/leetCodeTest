package com.atws.huawei.od;

import java.util.Scanner;

/**
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

    public static void main(String[] args) {

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
