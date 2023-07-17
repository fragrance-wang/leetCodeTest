package com.atws.simple;


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3, 2);
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));

    }

    private Map<Integer, Node> cacheMap = new HashMap<>();

    private int size;

    private final int capacity;

    private Node head = null;

    private Node tail = null;

    public static class Node {

        private int key;

        private int value;

        private Node pre;

        private Node next;

        public Node() {
        }

        public Node(Node pre, int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }


    public void removeTail() {
        if (tail != null && tail == head) {
            cacheMap.remove(tail.getKey());
            tail = null;
            head = null;
            size--;
            return;
        }
        int key = tail.getKey();
        cacheMap.remove(key);
        Node l = tail;
        Node pre = l.pre;
        pre.next = null;
        tail.pre = null;
        tail = pre;
        size--;
    }

    public void moveNodeToHead(Node moveNode) {
        if (moveNode == head) {
            return;
        }
        if (moveNode == tail) {
            removeTail();
        } else {
            Node pre = moveNode.pre;
            Node next = moveNode.next;
            pre.next = next;
            if (next != null) {
                next.pre = pre;
            }
            size--;
        }

        addHead(moveNode.getKey(), moveNode.getValue());
    }

    public void addHead(int key, int value) {
        if (size > capacity) {
            return;
        }
        Node f = head;
        Node newNode = new Node(null, key, value, f);
        head = newNode;
        if (f == null) {
            tail = newNode;
        } else {
            f.pre = newNode;
        }
        cacheMap.put(key, newNode);
        size++;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            moveNodeToHead(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {//size不变
            Node node = cacheMap.get(key);
            node.setValue(value);
            moveNodeToHead(node);
        } else {
            if (size >= capacity) {
                removeTail();
            }
            addHead(key, value);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */