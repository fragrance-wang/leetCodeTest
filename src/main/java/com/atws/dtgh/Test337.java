package com.atws.dtgh;

import com.atws.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * @author wangshan
 * @date 2023-08-28 14:47
 */
public class Test337 {
    public static void main(String[] args) {
        /**
         *               1
         *             /   \
         *            2     3
         *           / \    /
         *          4   5  6
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(rob(root));
    }


    public static int rob(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        // 层序遍历
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        // List<List<Integer>> result = new ArrayList<>();
        List<Integer> dpList = new ArrayList<>();
        int c = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // List<Integer> list = new ArrayList<>(size);
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // list.add(poll.val);
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (c == 0) {
                dpList.add(sum);
            } else if (c == 1) {
                dpList.add(Math.max(sum, dpList.get(0)));
            } else if (c > 1) {
                dpList.add(Math.max(dpList.get(c - 1), sum + dpList.get(c - 2)));
            }
            // result.add(list);
            c++;
        }
        // System.out.println(result);
        return dpList.get(c-1);
    }

}
