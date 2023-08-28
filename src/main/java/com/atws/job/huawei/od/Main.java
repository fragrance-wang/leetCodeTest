package com.atws.job.od;

import java.util.Scanner;

/**
 * 输入一行 数字字符串 用,隔开
 * 如果数量小于3，则输出能够组成的最小值
 *
 * 输出：
 *      字符串中三个数字组合成一个整数的最小值
 *
 *  eg: 1,10,300,3
 *      输出：1103
 *
 *
 * @author wangshan
 * @date 2023-08-10 11:44
 */
public class Main {

    String node;

    Main next;

    Main head;

    public Main(String node) {
        this.node = node;
        head = this;
    }

    public void addBefore(Main beforeNode, Main currentNode) {
        head = beforeNode;
        beforeNode.next = currentNode;
    }

    public void addAfter(Main afterNode, Main currentNode) {
        Main temp = currentNode.next;
        currentNode.next = afterNode;
        afterNode.next = temp;
    }


    public static boolean isMin(String str0, String str1) {
        if (str0.length() < str1.length()) {
            return true;
        } else if (str0.length() > str1.length()) {
            return false;
        } else {
            int m = Integer.parseInt(str0);
            int n = Integer.parseInt(str1);
            return m < n;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        String[] splits = line.split(",");
        if (splits.length == 1) {
            System.out.println(splits[0]);
        } else if (splits.length == 2) {
            System.out.println(Math.min(Integer.parseInt(splits[0] + splits[1]), Integer.parseInt(splits[1] + splits[0])));
        } else if (splits.length > 2) {
            //排序，排序规则，位数越小>位数相同，数值越小
            Main linkedNode = new Main(splits[0]);
            Main temp = null;
            for (int i = 1; i < splits.length; i++) {
                String str0 = splits[i];
                temp = linkedNode.head;
                while (temp != null) {
                    String str1 = temp.node;
                    Main next = temp.next;
                    if (isMin(str0, str1)) {
                        linkedNode.addBefore(new Main(str0), temp);
                        break;
                    } else {
                        if (next == null) {
                            linkedNode.addAfter(new Main(str0), temp);
                            break;
                        } else {
                            if (isMin(str0, next.node)) {
                                linkedNode.addAfter(new Main(str0), temp);
                                break;
                            }
                        }
                    }
                    temp = next;
                }
            }
            //然后取前三位，进行最小值计算
            String m, n, t;
            String[] strings = new String[3];
            temp = linkedNode.head;
            for (int i = 0; i < 3; i++) {
                strings[i] = temp.node;
                temp = temp.next;
            }
            m = strings[0];
            n = strings[1];
            t = strings[2];

            long t1 = Long.parseLong(m + n + t);
            long t2 =  Long.parseLong(m + t + n);
            long t3 =  Long.parseLong(n + m + t);
            long t4 = Long.parseLong(n + t + m);
            long t5 =  Long.parseLong(t + m + n);
            long t6 =  Long.parseLong(t + n + m);

            java.util.List<Long> list = java.util.Arrays.asList(t1, t2, t3, t4, t5, t6);
            long min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i));
            }
            System.out.println(min);
        }
    }
}
