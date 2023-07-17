package com.atws.simple;


/**
 * @author wangshan
 * @date 2023-07-12 上午9:57
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(ints);
        for (int temp:ints
             ) {
            System.out.println(temp);
        }
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                //1.将i位置的值赋值给j位置
                nums[j] = nums[i];
                //2.j索引自增
                j++;
            }
        }

        for (int i=j;i<length;i++){
            nums[i]=0;
        }
    }
}
