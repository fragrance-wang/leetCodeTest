package com.atws.middle;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  二叉树的层序遍历 II
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 *
 *  给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 *      题解：和层序遍历一模一样，就是最后放入list的值由从前往后变为了从后往前放
 * @author wangshan
 * @date 2023-08-06 15:53
 */
public class Test107 {


    public static void main(String[] args) {
        Test107 test107 = new Test107();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        List<List<Integer>> lists = test107.levelOrderBottom(root);

        System.out.println(lists);
    }

    /**
     * 层序遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
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
            result.addFirst(list);
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
