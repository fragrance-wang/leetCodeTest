package com.atws.middle;

import com.atws.simple.InorderTraversalTest;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * 双端队列实现，牛逼
 * <p>
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/solutions/2361613/103-er-cha-shu-de-ju-chi-xing-ceng-xu-bi-qz2q/
 * 直接用方法三，简单粗暴
 *
 * @author wangshan
 * @date 2023-08-06 12:50
 */
public class Test103 {


    public static void main(String[] args) {
        Test103 test103 = new Test103();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        List<List<Integer>> lists = test103.zigzagLevelOrder(root);

        System.out.println(lists);
    }


    /**
     * 层序遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if (root != null) queue.add(root);
        boolean reverseAble = false;
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode take = queue.poll();
                int val = take.val;
                TreeNode left = take.left;
                TreeNode right = take.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                list.add(val);
            }
            /**
             * 添加的时候，判断是否需要反转
             */
            if (reverseAble) Collections.reverse(list);
            result.add(list);
            reverseAble = !reverseAble;
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
