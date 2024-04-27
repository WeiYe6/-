package com.dataStructures.tree;

/**
 * 线索二叉树：线索的目的，利用闲置的左右结点。提高资源利用率
 */
class ThreadedDemoTree {
    public static void main(String[] args) {
        HeroNode2 root = new HeroNode2(1, "11");
        HeroNode2 node1 = new HeroNode2(3, "33");
        HeroNode2 node2 = new HeroNode2(8, "88");
        HeroNode2 node3 = new HeroNode2(10, "1010");
        HeroNode2 node4 = new HeroNode2(6, "1414");
        HeroNode2 node5 = new HeroNode2(14, "66");
        //手动设置节点
        root.setLeft(node1);
        root.setRight(node4);
        node1.setLeft(node2);
        node1.setRight(node3);
        node4.setLeft(node5);



       //测试中序线索化
        ThreadedTree threadedTree = new ThreadedTree();
        threadedTree.setRoot(root);

        //threadedTree.midOrder(); //{8, 3, 10, 1, 14, 6}

        //中序线索化
        threadedTree.midThreadTree();
        //测试，10，前驱应该为3，后继应该为1
        //HeroNode2 left = node3.getLeft();
        //System.out.println(left);
        //HeroNode2 right = node3.getRight();
        //System.out.println(right);

        //中序遍历线索二叉树
        threadedTree.midOrderByThreadTree();//{8, 3, 10, 1, 14, 6}


    }
}

class ThreadedTree {
    private HeroNode2 root;//根节点
    private HeroNode2 pre = null;//指针结点：指向当前结点的前驱结点

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }



    //中序遍历线索二叉树
    public void midOrderByThreadTree(){
        //给当前结点赋为 root结点
        HeroNode2 heroNode2 = root;
        while (heroNode2 != null) { //对该结点进行有效性的判断
            //中序遍历是先遍历最左边的
            //但是，此时不能用heroNode2.getLeft == null,来进行判断，因为该树已经线索化了。
            //还记得我们是如何记录该结点的左右子树是线索化后的结点？还是子树吗？ 是不是定义了一个 leftType、rightType，如果记录的是线索化那该标记就为1，否则为0
            //所以这里我们只需要判断该结点的leftType == 1? 即可知道是不是到这颗树的最左边了。
            while (heroNode2.getLeftType() == 0) {
                heroNode2 = heroNode2.getLeft(); //还没到最左边时，一直移动，直至getLeftType==1
            }
            //跳出该循环，说明已经到最左边了
            //此时直接打印该结点即可
            System.out.println(heroNode2);

            //这时还需要判断该结点的右边：是右子树还是线索化指向该结点的后继结点
            //如果是线索化，即后继结点，就一直打印下去即可
            while (heroNode2.getRightType() == 1) {
                heroNode2 = heroNode2.getRight();//移动至该结点的后继结点
                System.out.println(heroNode2);//打印
            }
            //移动结点到下一个非空的结点
            heroNode2 = heroNode2.getRight();
        }
    }

    //重载中序线索化二叉树
    public void midThreadTree() {
        this.midThreadTree(root);
    }


    /**
     * 中序线索化二叉树
     *
     * @param node 需要线索化的结点
     */
    public void midThreadTree(HeroNode2 node) {
        //判断当前结点,是否为空，空的不需要线索化
        if (node == null) {
            return;
        }
        //1.先线索化左子树
        midThreadTree(node.getLeft());

        //2.再线索化 当前结点(重点)
        //思路:{8, 3, 10, 1, 14, 6},这里以8结点举例，
        //   8结点的前驱为空，所以pre =  null,
        //   8结点的后继结点为3，所以需要移动到下一个结点即3结点，且移动pre结点即到8结点，然后 pre.right(node)
        //2.1对当前结点进行前驱线索化
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);//做标记，当前结点记录的是前驱结点。非子树
        }
        //2.2对当前结点进行后继线索化
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);//做标记，当前结点记录的是后继结点。非子树
        }
        //移动pre指针
        pre = node;

        //3.最后线索化，右子树
        midThreadTree(node.getRight());
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
    public HeroNode2 preSearch(int no) {
        if (this.root != null) {
            return this.root.preSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode2 midSearch(int no) {
        if (this.root != null) {
            return this.root.midSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode2 sufSearch(int no) {
        if (this.root != null) {
            return this.root.sufSearch(no);
        } else {
            return null;
        }
    }

}

//定义一个英雄结点
class HeroNode2 {
    private int id;
    private String name;
    private HeroNode2 left;//左节点 默认null
    private HeroNode2 right;//右节点 默认null

    private int leftType; //规定：0-左子树，1-前驱结点
    private int rightType; //规定：0-右子树，1-后继结点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode2(int id, String name) {
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

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
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
    public HeroNode2 preSearch(int no) {
        System.out.println("前序查找----------");
        //和当前结点进行比较
        if (this.id == no) {
            return this;
        }
        //如果没有找到，判断，递归左子树
        HeroNode2 temp = null;
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
    public HeroNode2 midSearch(int no) {
        //如果没有找到，判断，递归左子树
        HeroNode2 temp = null;
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
    public HeroNode2 sufSearch(int no) {
        //如果没有找到，判断，递归左子树
        HeroNode2 temp = null;
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
