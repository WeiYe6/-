package com.dataStructures.hashTab;

import java.util.Scanner;

/**
 * 哈希表：
 * 散列表（Hash table，也叫哈希表），是根据**关键码值**(Key value)而直接进行访问的数据结构。
 * 也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做**散列函数**，存放记录的数组叫做**散列表**。
 * <p>
 * 需求：有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,名字),当输入该员工的id时,要求查找到该员工的 所有信息.
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del:删除雇员");
            System.out.println("exit: 退出系统");


            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    hashTab.findByNo(id);
                    break;
                case "del":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    hashTab.delById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}


//创建一个统一管理链表的类(实现类)
class HashTab {
    private final EmpLinkedList[] empLinkedArray;
    private final int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedArray = new EmpLinkedList[size];
        //数组里面的对象没有初始化全部都是为null，这个时候就要初始化,添加EmpLinkedList对象
        for (int i = 0; i < size; i++) {
            empLinkedArray[i] = new EmpLinkedList();
        }
    }


    public void add(Emp emp) {//添加员工
        empLinkedArray[HsFUN(emp.id)].add(emp);
    }

    public void list() {
        //展示每一个表的员工的信息
        for (int i = 0; i < empLinkedArray.length; i++) {
            empLinkedArray[i].list(i + 1);
        }
    }

    //写一个散列函数来计算每一个员工应该放到hash表中的数组链表的那条链表中，这里就用取模法
    public int HsFUN(int no) {
        return no % size;
    }

    public void findByNo(int no) {
        Emp emp = empLinkedArray[HsFUN(no)].findEmpById(no);
        if (emp == null) {
            System.out.printf("没有找到员工号为%d的员工", no);
            System.out.println();
        } else {
            System.out.println(emp.name);
        }
    }

    public void delById(int no) {
        empLinkedArray[HsFUN(no)].delById(no);
    }
}

//创建一个员工对象
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为null---后指针

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//链表，里面以链表的形式存放着每一个员工信息，并实现CRUD
class EmpLinkedList {
    //头指针，这里直接指向第一个员工
    private Emp head;

    //添加员工到列表
    public void add(Emp emp) {
        //链表为空时，第一次添加，头指针存放该员工
        if (head == null) {
            head = emp;//
            return;//退出循环
        }
        //非第一次添加
        //辅助指针
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;//移动指针
        }
        //到这里，满足了temp.next == null,即为最后一个结点
        //把要添加的员工emp，添加在末尾
        temp.next = emp;
    }

    //遍历全部员工信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        //不为空，输出信息
        System.out.print("第" + no + "条链表信息为:");
        Emp curEmp = head;
        while (curEmp != null) {
            System.out.printf("====>员工的id%d,姓名%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id，查找某个员工
    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }
        //创建一个辅助指针
        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;//如果下一个是空就直接结束
                break;
            }
            cur = cur.next;//向后移动,找到了就直接返回
        }
        return cur;
    }

    public void delById(int id) {
        boolean flag = false;
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        if (head.id == id) { //删除的员工在头结点
            head = head.next;
            System.out.println("删除成功!");
            return;
        }
        Emp temp = head;
        while (temp.next != null) {
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.printf("你要删除的员工号%d不存在", id);
            System.out.println();
        } else {
            temp.next = temp.next.next;
            System.out.println("删除成功!");
        }
    }
}
