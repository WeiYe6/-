package com.dataStructures.二分查找;

public class ThreadedBinaryTree {
    // 定义节点类
    private static class Node {
        int data;
        Node left;
        Node right;
        boolean lTag;
        boolean rTag;

        public Node(int data) {
            this.data = data;
            this.lTag = false;
            this.rTag = false;
        }
    }

    private Node root;   // 根节点
    private Node head;   // 头结点
    private Node pre;    // 前驱节点

    public ThreadedBinaryTree() {
        root = null;
        head = null;
        pre = null;
    }

    // 创建线索二叉树
    public void createThreadedBinaryTree(int[] arr) {
        root = createThreadedBinaryTree(arr, 0);
        head = new Node(Integer.MIN_VALUE);  // 创建头结点
        head.lTag = true;
        head.rTag = true;
        if (root == null) {
            head.left = head;
            head.right = head;
        } else {
            head.left = root;
            head.right = head;
            pre = head;
            inOrderThread(root); // 中序线索化二叉树
            pre.right = head;
            pre.rTag = true;
            head.right = pre;
        }
    }

    // 递归创建二叉树
    private Node createThreadedBinaryTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        Node node = new Node(arr[index]);
        node.left = createThreadedBinaryTree(arr, 2 * index + 1); // 左子树递归创建
        node.right = createThreadedBinaryTree(arr, 2 * index + 2); // 右子树递归创建
        return node;
    }

    // 中序线索化二叉树
    private void inOrderThread(Node p) {
        if (p != null) {
            inOrderThread(p.left); // 左子树线索化

            // 处理当前节点的前驱线索和后继线索
            if (p.left == null) {
                p.lTag = true;
                p.left = pre;  // 当前节点的左指针指向前驱节点
            }
            if (pre.right == null) {
                pre.rTag = true;
                pre.right = p;  // 前驱节点的右指针指向当前节点
            }
            pre = p;

            inOrderThread(p.right); // 右子树线索化
        }
    }

    // 中序遍历线索二叉树
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("线索二叉树为空");
            return;
        }

        Node p = root;
        while (p != head) {
            // 找到最左下的节点
            while (!p.lTag) {
                p = p.left;
            }

            System.out.print(p.data + " "); // 输出节点的值

            // 遍历线索
            while (p.rTag && p.right != head) {
                p = p.right;
                System.out.print(p.data + " "); // 输出节点的值
            }

            p = p.right;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3};
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.createThreadedBinaryTree(arr);
        tree.inOrderTraversal();
    }
}