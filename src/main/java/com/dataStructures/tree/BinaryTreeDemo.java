package com.dataStructures.tree;

/**
 * 二叉树的前、中、后序遍历，代码实现。
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "关胜");
        //手动设置节点
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        binaryTree.setRoot(root);

//        //遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.midOrder();
//        System.out.println("后序遍历");
//        binaryTree.sufOrder();

        //查找
//        int searchNode = 5;
//        System.out.println("前序查找"); //次数4
//        HeroNode heroNode = binaryTree.preSearch(searchNode);
//        if (heroNode != null) {
//            System.out.println("找到了结点为" + searchNode + "的信息:" + heroNode);
//        } else {
//            System.out.println("结点为" + searchNode + "不存在");
//        }
//
//        System.out.println("中序查找"); //次数3
//        heroNode = binaryTree.midSearch(searchNode);
//        if (heroNode != null) {
//            System.out.println("找到了结点为" + searchNode + "的信息:" + heroNode);
//        } else {
//            System.out.println("结点为" + searchNode + "不存在");
//        }
//
//        System.out.println("后序查找"); //次数2
//        heroNode = binaryTree.sufSearch(searchNode);
//        if (heroNode != null) {
//            System.out.println("找到了结点为" + searchNode + "的信息:" + heroNode);
//        } else {
//            System.out.println("结点为" + searchNode + "不存在");
//        }

        System.out.println("前序遍历");
        binaryTree.preOrder();
        binaryTree.del(5);
        System.out.println("前序遍历");
        binaryTree.preOrder();
    }
}

//二叉树实现
class BinaryTree {
    private HeroNode root;//根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除结点
    public void del(int no) {
        if (root == null) {
            System.out.println("二叉树为空");
        }
        if (root.getId() == no) {
            root = null;
        } else {
            root.del(no);
        }
    }

    //实现前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void sufOrder() {
        if (this.root != null) {
            this.root.sufOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preSearch(int no) {
        if (this.root != null) {
            return this.root.preSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode midSearch(int no) {
        if (this.root != null) {
            return this.root.midSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode sufSearch(int no) {
        if (this.root != null) {
            return this.root.sufSearch(no);
        } else {
            return null;
        }
    }

}

//定义一个英雄结点
class HeroNode {
    private int id;
    private String name;
    private HeroNode left;//左节点 默认null
    private HeroNode right;//右节点 默认null

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        //先输出根节点(当前结点)
        System.out.println(this);
        //再递归输入左结点
        if (this.left != null) {
            this.left.preOrder();
        }
        //最后递归输出右结点
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        //递归输入左结点
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出根节点(当前结点)
        System.out.println(this);
        //最后递归输出右结点
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void sufOrder() {
        //递归输入左结点
        if (this.left != null) {
            this.left.sufOrder();
        }
        //最后递归输出右结点
        if (this.right != null) {
            this.right.sufOrder();
        }
        //输出根节点(当前结点)
        System.out.println(this);
    }

    /**
     * 前序查找
     * 思路分析:
     * 1.先和当前结点进行比较，如何相等，返回当前结点
     * 2.如果不等，先判断左子树是否为空，如果不为空继续递归左子树查找，如果找到了就返回。
     * 3，如果找不到，先判断右子树是否为空，如果不为空，继续递归右子树查找。
     * 4.最后，不管找没找到都直接返回（符合的结点 || null）。
     *
     * @param no 需要查找的结点
     * @return 返回结点
     */
    public HeroNode preSearch(int no) {
        System.out.println("前序查找----------");
        //和当前结点进行比较
        if (this.id == no) {
            return this;
        }
        //如果没有找到，判断，递归左子树
        HeroNode temp = null;
        if (this.left != null) {
            temp = this.left.preSearch(no);
        }
        if (temp != null) {//判断左子树是否找到
            return temp;
        }
        //如果没有找到，递归右子树
        //判断
        if (this.right != null) {
            temp = this.right.preSearch(no);
        }
        return temp; //直接返回
    }

    //中序查找
    public HeroNode midSearch(int no) {
        //如果没有找到，判断，递归左子树
        HeroNode temp = null;
        if (this.left != null) {
            temp = this.left.midSearch(no);
        }
        if (temp != null) {//判断左子树是否找到
            return temp;
        }
        System.out.println("中序查找----------");
        //和当前结点进行比较
        if (this.id == no) {
            return this;
        }
        //如果没有找到，递归右子树
        //判断
        if (this.right != null) {
            temp = this.right.midSearch(no);
        }
        return temp; //直接返回
    }

    //后序序查找
    public HeroNode sufSearch(int no) {
        //如果没有找到，判断，递归左子树
        HeroNode temp = null;
        if (this.left != null) {
            temp = this.left.sufSearch(no);
        }
        if (temp != null) {//判断左子树是否找到
            return temp;
        }
        //如果没有找到，递归右子树
        //判断
        if (this.right != null) {
            temp = this.right.sufSearch(no);
        }
        if (temp != null) {//判断右子树是否找到
            return temp;
        }
        //和当前结点进行比较
        System.out.println("后序查找----------");
        if (this.id == no) {
            return this;
        }
        return temp; //直接返回
    }

    /**
     * 删除结点(简单版)
     *
     * @param no 待删除的结点
     *           思路:
     *           先判断root是否为空，如果不为空，那就让root.id和no，进行比较，如果相等，就直接把root=null。
     *           1.判断root的左子树是否为空，且和no结点进行比较，如果相等，就this.left = null;
     *           2.不等，就判断root结点的右子节点是否为空，且和no结点进行比较，如果相等，就this.right = null.
     *           如果，1，2均不成立，那么就递归删除左子树，
     *           如果，还是还没删除，那就递归删除右子树。
     */
    public void del(int no) {
        //对左子树判空且比较
        if (this.left != null && this.left.id == no) {
            this.left = null;
            return;
        }
        //对右子树判空且比较
        if (this.right != null && this.right.id == no) {
            this.right = null;
            return;
        }
        //递归删除左子树，
        if (this.left != null) {
            this.left.del(no);
        }

        //递归删除右子树。
        //递归删除左子树，
        if (this.right != null) {
            this.right.del(no);
        }

    }
}
