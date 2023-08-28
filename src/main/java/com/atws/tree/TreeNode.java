package com.atws.tree;

import com.atws.middle.Test107;

/**
 * @author wangshan
 * @date 2023-08-28 14:50
 */
public class TreeNode {

    public static void main(String[] args) {
        /**
         *               1
         *             /   \
         *            2     3
         *           / \    /
         *          4   5  6
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
