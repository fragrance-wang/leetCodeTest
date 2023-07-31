package com.atws.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历：https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * <p>
 * 前序遍历：打印 - 左 - 右
 * 中序遍历：左 - 打印 - 右
 * 后序遍历：左 - 右 - 打印
 * <p>
 * <p>
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/96765/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/
 * 这个题解用栈的结构实现很舒服
 *
 * @author wangshan
 * @date 2023-07-30 17:23
 */
public class InorderTraversalTest {
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


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middlePrint(root, list);
        return list;
    }

    public void middlePrint(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        middlePrint(root.left, list);
        list.add(root.val);
        middlePrint(root.right, list);
    }

    /**
     * 用栈-->看着简单，实现起来比较复杂
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        while (stack.size() > 0 || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                temp = pop.right;
            }
        }
        return list;
    }

    /**
     *      1
     *   2        3
     * 4   5    6
     *
     * @param args
     */
    public static void main(String[] args) {
        InorderTraversalTest inorderTraversalTest = new InorderTraversalTest();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        List<Integer> list = inorderTraversalTest.inorderTraversal(root);
        System.out.println(list);
    }
}
