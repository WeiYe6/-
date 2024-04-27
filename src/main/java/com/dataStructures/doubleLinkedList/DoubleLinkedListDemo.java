package com.dataStructures.doubleLinkedList;

import com.dataStructures.singleLinkedList.SingleLinkedListDemo;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //双向链表
        //创建几个结点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //添加结点
        doubleLinkedList.addHero(hero1);
        doubleLinkedList.addHero(hero2);
        doubleLinkedList.addHero(hero3);
        doubleLinkedList.addHero(hero4);
        //遍历
        doubleLinkedList.showLinkedList();
        //根据 no 修改结点
        HeroNode2 hero5 = new HeroNode2(2, "俊义", "玉-麒麟");
        doubleLinkedList.update(hero5);

        System.out.println("修改完毕的链表：");
        doubleLinkedList.showLinkedList();

      /*  //根据 no 删除结点
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(2);
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(4);
        doubleLinkedList.delete(4);
        System.out.println("删除成功的链表:");
        doubleLinkedList.showLinkedList();*/

        System.out.println("--------------");
        //有序插入新结点
        HeroNode2 heroNode5 = new HeroNode2(8, "曾伟业", "枫业");
        HeroNode2 heroNode6 = new HeroNode2(6, "曾伟业2", "枫业2");
        HeroNode2 heroNode7 = new HeroNode2(7, "曾伟业3", "枫业3");
        HeroNode2 heroNode8 = new HeroNode2(7, "曾伟业4", "枫业4");
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.addByOrder(heroNode6);
        doubleLinkedList.addByOrder(heroNode7);
        doubleLinkedList.addByOrder(heroNode8);

        doubleLinkedList.showLinkedList();

    }

}

class DoubleLinkedList {
    //创建一个头结点 ：表示链表的开始
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历
    public void showLinkedList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，没有数据可以显示");
            return;
        }
        HeroNode2 temp = head; //指针
        while (temp.next != null) {
            temp = temp.next; //移动指针
            System.out.println(temp);
        }
    }

    //添加---添加节点到双向链表当中
    //1.不考虑编号添加的时候全部添加到节点的末尾（尾插法）
    //2.通过循环找到链表的末尾
    public void addHero(HeroNode2 heroNode) {
        HeroNode2 temp = head;//指针
        //通过循环找到链表的末尾
        while (temp.next != null) {
            temp = temp.next; //移动指针
        }
        //与新结点建立连接
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改---修改节点信息，双向链表几乎和单链表的一样
    //根据no来修改人物信息，no不能改
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) { //判断链表是否为空
            System.out.println("链表为空，没有数据可以修改");
            return;
        }
        boolean flag = false; //添加标志
        HeroNode2 temp = head.next; //添加一个指针: 指向头结点的下一个结点
        while (true) {
            if (temp == null) {//到末尾了还是找不到，说明该链表不存在no所对应的结点
                //注意:这里容易写错成temp.next--造成的后果-->当循环到最后一个结点时,该条件始终成立,那么，就缺少了和最后一个结点的校验
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next; //移动指针
        }
        if (flag) {//找到
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("要修改的" + newHeroNode.no + "不存在。");
        }
    }

    //删除--根据 no 删除结点
    // 双向链表删除节点，可以不用找到前一个节点而是可以直接找到要删除的节点
    public void delete(int no) {
        if (head.next == null) { //判断链表是否为空
            System.out.println("链表为空，没有数据可以删除");
            return;
        }
        boolean flag = false; //添加一个标志
        HeroNode2 temp = head.next;//添加一个指针,且指向有效链表的第一个
        while (true) {
            if (temp == null) { //链表为空 或者 已经到链表的末尾了
                break;
            } else if (temp.no == no) {
                flag = true; //找到
                break;
            }
            temp = temp.next;
        }

        if (flag) {//找到
            //如果是链表的最后一个，则直接删除尾部的那个结点
            temp.pre.next = temp.next; //如果是链表尾部结点--等效与 = null
            if (temp.next != null) { //非链表尾部结点
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("你要删除的节点" + no + "不存在");
        }
    }

    //排序插入（按照英雄的排名）
        /*
        首先要找到当前添加结点的位置，需要辅助变量（指针） temp：插入位置的前一个结点
         */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;//指针
        //找到要插入位置的前一个结点
        while (true) {
            if (temp.next == null) {
                break; //空链表 或者 遍历到末尾了--可以直接在末尾添加
            }
            if (temp.next.no >= heroNode.no) {
                break;
            }
            temp = temp.next;//移动指针
        }
        //找到待插入点了： 为temp的后一个位置时
        if (temp.next == null) { //temp为末尾结点
            temp.next = heroNode;
            heroNode.pre = temp;
            return;
        }
        heroNode.next = temp.next;
        temp.next.pre = heroNode;
        temp.next = heroNode;
        heroNode.pre = temp;
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre; //前结点域
    public HeroNode2 next; //后结点域

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
