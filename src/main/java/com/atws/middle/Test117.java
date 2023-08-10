package com.atws.middle;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author wangshan
 * @date 2023-08-06 22:58
 */
public class Test117 {
    public static void main(String[] args) {
        Test117 test117 = new Test117();

        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
        Node connect = test117.connect(root);
        System.out.println(connect);

    }

    public Node connect(Node root) {
        if (root == null) return root;

        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            //只需要保存前一个节点指针即可
            Node beforeNode = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (beforeNode != null) beforeNode.next = node;
                beforeNode = node;

                if (node==null){
                    continue;
                }

                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }

        }

        return root;
    }


    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
