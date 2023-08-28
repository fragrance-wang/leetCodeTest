package com.atws.job.od.print;

import java.util.Scanner;

/**
 * @author wangshan
 * @date 2023-08-09 15:38
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()){
//            System.out.println(scanner.nextInt());
//        }

        while (scanner.hasNextLine()){
            System.out.println(scanner.next());
        }
    }
}
