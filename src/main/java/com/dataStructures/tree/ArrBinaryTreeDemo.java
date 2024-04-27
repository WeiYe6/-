package com.dataStructures.tree;

/**
 * 顺序存储二叉树
 * 特点:
 * 1. 顺序二叉树通常只考虑完全二叉树
 * 2. 第n个元素的左子节点为  2 * n + 1
 * 3. 第n个元素的右子节点为  2 * n + 2
 * 4. 第n个元素的父节点为  (n-1) / 2
 * 5. n : 表示二叉树中的第几个元素(按0开始编号如图所示
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历");
        arrBinaryTree.preOrder();
        System.out.println();
        System.out.println("----------------");
        System.out.println("中序遍历");
        arrBinaryTree.midOrder();
        System.out.println();
        System.out.println("----------------");
        System.out.println("后序遍历");
        arrBinaryTree.endOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //前序遍历，重载函数
    public void preOrder(){
        this.preOrder(0);
    }

    //中序遍历，重载函数
    public void midOrder(){
        this.midOrder(0);
    }

    //后序遍历，重载函数
    public void endOrder(){
        this.endOrder(0);
    }

    //前序遍历
    public void preOrder(int index) {
        //判断
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能遍历");
        }
        //先输出当前结点
        System.out.print(arr[index] + "   ");
        //判断结点的有效性 ,向左遍历
        if ((2 * index + 1) < arr.length) {
            preOrder((2 * index + 1));
        }
        //判断结点的有效性 ,向右遍历
        if ((2 * index + 2) < arr.length) {
            preOrder((2 * index + 2));
        }
    }

    //中序遍历
    public void midOrder(int index) {
        //判断
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能遍历");
        }
        //判断结点的有效性 ,向左遍历
        if ((2 * index + 1) < arr.length) {
            midOrder((2 * index + 1));
        }

        //先输出当前结点
        System.out.print(arr[index] + "   ");

        //判断结点的有效性 ,向右遍历
        if ((2 * index + 2) < arr.length) {
            midOrder((2 * index + 2));
        }
    }

    //中序遍历
    public void endOrder(int index) {
        //判断
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能遍历");
        }
        //判断结点的有效性 ,向左遍历
        if ((2 * index + 1) < arr.length) {
            endOrder((2 * index + 1));
        }

        //判断结点的有效性 ,向右遍历
        if ((2 * index + 2) < arr.length) {
            endOrder((2 * index + 2));
        }

        //先输出当前结点
        System.out.print(arr[index] + "   ");

    }
}
