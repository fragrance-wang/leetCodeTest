package com.atws.job.od;

import java.util.Scanner;

/**
 * @author wangshan
 * @date 2023-08-04 15:39
 */
public class TestInputScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m, n, r;
        m = scanner.nextInt();
        n = scanner.nextInt();

        int[] numsA = new int[m];
        int[] numsB = new int[n];

        for (int i = 0; i < m; i++) {
            numsA[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            numsB[i] = scanner.nextInt();
        }

        System.out.println(numsA.length);
        System.out.println(numsB.length);

    }
}
