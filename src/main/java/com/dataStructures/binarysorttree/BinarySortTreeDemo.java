package com.dataStructures.binarysorttree;

/**
 * 二叉排序树特点:  一般 左结点 < 父节点 < 右结点
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加结点
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }

        //遍历
        binarySortTree.midOrder();
    }
}

//二叉排序树
class BinarySortTree {
    private Node root;


    /**
     * 删除结点
     *
     * @param value 需要删除的结点
     */
    public void del(int value) {

    }

    //查找该结点
    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return searchNode(value);
        }
    }

    //查找该结点的父节点
    public Node searchParentNode(int value) {
        if (root != null) {
            return null;
        } else {
            return searchParentNode(value);
        }
    }

    //查找该结点的父节点

    //添加方法
    public void add(Node node) {
        //判空,空树，当前结点为root结点
        if (root == null) {
            root = node;
        } else {
            this.root.add(node);//添加
        }
    }

    //中序遍历方法
    public void midOrder() {
        if (root == null) {
            System.out.println("该树为空，不能遍历");
        } else {
            this.root.midOrder();
        }
    }

}


//结点
class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除结点的父节点
     *
     * @param value 要查找的结点的值
     * @return 返回该父节点
     */
    public Node searchParentNode(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.left.value > value) {//向左子树继续递归查找
                return this.left.searchParentNode(value);
            } else if (this.right != null && this.right.value < value) {//向右子树继续递归查找
                return this.right.searchParentNode(value);
            } else {
                return null;//找不到
            }
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param value 要查找结点的值
     * @return 返回找到的结点
     */
    public Node searchNode(int value) {
        if (this.value == value) {//该值等于该结点的值
            return this;
        }
        if (this.value > value) {//该值小于该结点的值，往左边找
            if (this.left == null) {//如果左边为空，表明该结点不存在
                return null;
            } else {//否则递归向左边查找
                return this.left.searchNode(value);
            }
        } else {////该值大于等于该结点的值，往右边找
            if (this.right == null) {
                return null;
            } else {
                return this.right.searchNode(value);
            }
        }
    }

    /**
     * 添加结点
     *
     * @param node 要添加的结点
     */
    public void add(Node node) {
        //判空
        if (node == null) {
            return;
        }
        if (node.value < this.value) {//小于当前结点，放在左边
            if (this.left != null) {
                this.left.add(node); //不为空，递归添加
            } else {
                this.left = node;//为空，直接添加在当前结点左边
            }
        } else {// 大于(等于) 当前结点，放在右边
            if (this.right != null) {
                this.right.add(node);//递归添加
            } else {
                this.right = node;
            }
        }
    }

    //中序遍历
    public void midOrder() {
        //递归遍历左边
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出当前结点
        System.out.println(this);
        //递归遍历右边
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
