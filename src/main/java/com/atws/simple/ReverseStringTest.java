package com.atws.simple;

/**
 * @author wangshan
 * @date 2023-07-12 下午2:58
 */
public class ReverseStringTest {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int length = s.length;
        int a = 0;
        int b = length - 1;
        char temp;
        while (a < b) {
            temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
