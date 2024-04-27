package com.dataStructures.doubleLinkedList;

public class Josephus {
    public static void main(String[] args) {
        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        circleSingleLinked.addBoy(5);
        circleSingleLinked.showBoy();
        System.out.println("-----小孩出圈------");
        circleSingleLinked.countBoy(1, 2, 5); // 2-4-1-5-3
    }
}

class CircleSingleLinked { //环形单链表
    //设置一个头指针
    private Boy first = null;

    //添加---添加小孩结点  参数：添加的结点个数
    public void addBoy(int nums) {
        //对数据的有效性进行校验
        if (nums < 1) {
            System.out.println("---nums的值不正确---");
            return;
        }
        Boy curBoy = null; //辅助指针
        //使用for循环来添加小孩
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {//只有一个结点时
                first = boy; //first始终标识第一个结点 不移动
                first.setNext(boy); //一个结点也要构成一个闭环，后面添加就不断加入闭环中即可
                curBoy = first;//让辅助指针指向第一个结点
            } else {
                curBoy.setNext(boy); //连接下一个结点
                boy.setNext(first); //尾结点 与 头结点相连:形成闭环
                curBoy = curBoy.getNext(); //移动指针
            }
        }
    }

    //遍历
    public void showBoy() {
        if (first == null) { //判断是否空链表
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy = first; //辅助指针：指向第一个结点
        while (true) {
            System.out.println("小孩编号---" + curBoy.getNo());
            if (curBoy.getNext() == first) {//回到头结点了
                break;
            }
            curBoy = curBoy.getNext();//移动指针
        }
    }

    /**
     * 小孩出圈
     *
     * @param startNum 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示圈中有几个小孩
     */
    public void countBoy(int startNum, int countNum, int nums) {
        //对数据进校验
        if (first == null || startNum < 1 || startNum > nums) { //空链表、第几个小孩开始数（1--nums）
            System.out.println("输入的参数有误-");
        }
        // 创建一个辅助指针：先让该指针指向环形链表的最后一个结点
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper 移动 startNum-1 次（让 first 去到开始数数的那个小孩）
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时，让first 和 helper指针同时移动（countNum - 1）次，（从自己开始数）,且让小孩出圈
        while (true) {
            if (helper == first) { //圈中只剩最后一个小孩了， 跳出循环
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //让 first 指向的小孩出圈
            System.out.println("--出圈的小孩------" + first.getNo());
            first = first.getNext();//移向出圈的下一个小孩
            helper.setNext(first); //补全圈的缺口，继续数数
        }
        System.out.println("最后一个出圈的小孩--" + first.getNo());
    }
}

class Boy { //小孩结点
    private int no; //编号
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
