package com.dataStructures.singleLinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建几个节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //添加结点
/*        singleLinkedList.addHero(hero1);
        singleLinkedList.addHero(hero3);
        singleLinkedList.addHero(hero2);
        singleLinkedList.addHero(hero4);*/

        //按照英雄排名来添加 （升序）
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        //singleLinkedList.addByOrder(hero3);
        //遍历，修改前的信息
        singleLinkedList.list();

        /*//修改信息
        HeroNode newHeroNode = new HeroNode(2, "俊义", "-玉麒麟-");
        singleLinkedList.update(newHeroNode);

        //遍历
        System.out.println("-----------链表已修改成功-----------");
        singleLinkedList.list();

        //删除结点
        System.out.println("-----------链表已删除成功-----------");
        singleLinkedList.delete(5);
        singleLinkedList.delete(4);
        singleLinkedList.list();

        //测试有效个数
        System.out.println("链表的有效个数为：" + getLength(singleLinkedList.getHead()));

        //查找倒数第K个结点
        int i = 1;
        System.out.println("倒数第"+ i +"个结点为:" + findLastIndexNode(singleLinkedList.getHead(), i));*/
        System.out.println("反转的链表：");
        //reverseList(singleLinkedList.getHead());

        //使用递归方法实现 链表的反转
       /* HeroNode recur = recur(singleLinkedList.getHead().next, null);
        while (recur != null) {
            System.out.println(recur);
            recur = recur.next;
        }*/

        //遍历
        //singleLinkedList.list();

        //从尾到头打印链表（不改变原链表的结构）
        reversePrint(singleLinkedList.getHead());
    }

    //单链表从尾到头打印链表（百度的面试题）
    //采用方法二：利用栈的先进后出特点，实现逆序打印的效果
    // 优点，不破坏原来的链表结构
    public static void reversePrint(HeroNode heroNode){
        //判断链表是否为空
        if (heroNode.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        //定义指针
        HeroNode temp = heroNode.next;
        //将结点压入栈中
        while (temp != null){
            stack.push(temp);
            temp = temp.next;//后移
        }
        //出栈
        while (stack.size() > 0){
            HeroNode hero = stack.pop();
            System.out.println(hero);
        }
    }

    //单链表反转（腾讯面试题，有点难度）
    public static void reverseList(HeroNode heroNode) {
        //如果当前链表为空，或者只有一个结点，无需反转，直接返回
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }
        //定义辅助变量（指针）,便于遍历链表
        HeroNode cur = heroNode.next; //跳过头结点
        HeroNode next = null; //指向当前结点（cur）的下一个结点
        HeroNode reverseHead = new HeroNode(0, "", ""); //定义新链表的头结点
        //遍历原来的链表，每遍历一个结点，就将其取出，并放到新的链表的最前端
        while (cur != null) {
            next = cur.next;//让next指向下一个结点，作为变量保存下一个结点
            cur.next = reverseHead.next; //第一次：让当前结点的next域指向空，断开与后面的连接，之后则让后面进来的结点的next域，指向前一个结点，达到反转的效果
            reverseHead.next = cur;  //把新的头结点 指向当前遍历的那个结点（说明后遍历的结点往往在新结点的前头）
            cur = next;
        }
        heroNode.next = reverseHead.next;
    }

    //方法二： 使用递归实现 反转链表
    public static HeroNode recur(HeroNode cur, HeroNode pre) {
        if (cur == null) {
            //结束条件
            return pre;
        }
        //递归后继结点
        HeroNode res = recur(cur.next, cur);
        //在回溯阶段 修改结点的引用指向
        cur.next = pre;
        //返回反转的链表的头结点
        return res;
    }

    //查找单链表的倒数第k个【新浪面试题】
    /*
     1.参数一：head头结点：链表是开始
     2.参数二：index：倒数第index个结点
     3.得到总长度 size 遍历（size-index）个就为我们需要的那个结点
     4.找到就返回该结点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode heroNode, int index) {
        int size = getLength(heroNode); //有效总长度
        //判断是否为空链表
        if (heroNode.next == null) {
            return null;
        } else if (index <= 0 || index > size) {//校验index 的有效性
            return null;
        }
        HeroNode cru = heroNode.next; //指针 从第一个有效结点开始
        for (int i = 0; i < (size - index); i++) { //eg:size=10 index=2-->10-2=8 移动8次 到第九结点那里，就是倒数第二的那个结点
            cru = cru.next; //移动指针
        }
        return cru;
    }

    //求链表中有效结点的个数 size:要求-有头结点则不计入size中
    public static int getLength(HeroNode heroNode) {
        if (heroNode.next == null) {
            return 0; //为空
        }
        int size = 0; //计数
        HeroNode cur = heroNode.next; //指针  且把头结点去掉了
        while (cur != null) {
            size++;
            cur = cur.next; //移动
        }
        return size;
    }

    //创建单链表 (管理英雄类)
    static class SingleLinkedList {
        //创建一个头节点：注意头节点是不能移动的，用来指向下一个节点，且该节点不存储数据(按具体需求定)
        private HeroNode head = new HeroNode(0, "0", "");

        public HeroNode getHead() {
            return head;
        }

        //添加节点到链表当中 （尾插法）
        //1.不考虑编号添加的时候全部添加到节点的末尾
        //2.通过循环找到 链表的末尾
        public void addHero(HeroNode heroNode) {
            //创建一个辅助变量来管理头节点(指针)
            HeroNode temp = head;
            //通过循环找到链表的末尾
            while (temp.next != null) { //移动到最后一个节点了
                temp = temp.next; //（节点）指针后移
            }
            temp.next = heroNode;
        }

        //排序插入（按照英雄的排名）
        /*
        1.首先要找到当前添加结点的位置，需要辅助变量（指针） temp
        2.找到位置后  新结点.next  = temp.next
        3.temp.next = 新结点
         */
        public void addByOrder(HeroNode heroNode) {
            //添加一个标志，标识能否插入（如果当前排名存在，则插入失败）
            boolean flag = false;
            HeroNode temp = head;//指针
            //找到要插入位置的前一个结点
            while (true) {
                if (temp.next == null) {
                    break; //遍历到末尾了--可以直接在末尾添加
                } else if (temp.next.no > heroNode.no) {
                    //当前结点的后一结点大于我们要插入的结点 (找到待插入的位置)
                    break;
                } else if (temp.next.no == heroNode.no) {
                    //该排名已经存在，不能插入
                    flag = true;
                    break;
                }
                //移动指针
                temp = temp.next;
            }
            //判断能否插入
            if (flag) {
                //不能插入
                System.out.println("当前排名" + heroNode.no + "已经存在,添加失败");
            } else {
                //插入到链表中，temp的后面
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //根据排名 no 修改英雄的信息
        public void update(HeroNode newHeroNode) {
            //链表为空
            if (head.next == null) {
                System.out.println("链表为空，无信息可修改。");
                return;
            }
            //添加一个标志
            boolean flag = false;
            //添加一个指针:指向头节点的下一个结点，优点：提高效率，省去和头结点的无效判断
            HeroNode temp = head.next;
            //找与newHeroNode.no对应的结点
            while (true) {
                if (temp == null) {
                    //到末尾了还是找不到，说明该链表不存在no所对应的结点
                    //注意:这里容易写错成temp.next--造成的后果-->当循环到最后一个结点时，该条件始终成立，那么，就缺少了和最后一个结点的校验
                    flag = true;
                    break;
                }
                if (temp.no == newHeroNode.no) {
                    //找到了
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                //找不到
                System.out.println("要修改的" + newHeroNode.no + "不存在。");
            } else {
                //找到了，修改信息 *注意，不能修改排名 no--->否则，就等于添加新数据了
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            }
        }

        //根据 no 删除结点
        //思路：
        //1.head 不能动，因此我们需要一个temp辅助结点，找到待删除结点的前一个结点
        //2.说明我们在比较时，是temp.next.no 和 需要删除结点的no 进行比较
        public void delete(int no) {
            //定义指针   *注意：这里只能是 head--->写了head.next 出现的后果就是，第一个结点无法删除
            // 因为： temp.next = temp.next.next
            HeroNode temp = head;
            //定义标志
            boolean flag = false;
            //循环找与 no 相等的结点
            while (true) {
                if (temp.next == null) {
                    //*注意 ：如果这里写成 temp == null ,出现的后果就是 由于我们是要删除结点，所以temp指向的就是【待删除的】前一个结点，
                    //因此else if(temp.next.no)为固定的，不能改为temp.no,所以就会有空指针异常。
                    break; //到尾部的 后一个位置了，还是找不到
                } else if (temp.next.no == no) {
                    //找到待删除的前一个结点 temp
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                //找到
                temp.next = temp.next.next;
            } else {
                //找不到
                System.out.println("你要删除的节点" + no + "不存在");
            }
        }

        //遍历链表
        public void list() {
            //判断链表是否空
            if (head.next == null) {
                System.out.println("链表为空，没有数据可以显示");
                return;
            }
            HeroNode temp = head;
            while (temp.next != null) {
                temp = temp.next;  //移动指针，遍历下一个存在的节点
                System.out.println(temp);//后打印，因为不需要打印头节点（不存数据）
            }
        }
    }

    //创建一个头节点(举例 英雄头节点)
    static class HeroNode {
        public int no; //排名
        public String name;//姓名
        public String nickName;//别名
        public HeroNode next;//next域 用于指向下一个节点

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
