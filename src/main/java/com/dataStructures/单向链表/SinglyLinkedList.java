package com.dataStructures.单向链表;

import java.util.Iterator;
import java.util.function.Consumer;

//单向链表
public class SinglyLinkedList implements Iterable<Integer>{//整体
    private Node head = new Node(666,null);//头指针(带哨兵)

    @Override
    //匿名内部类
    public Iterator<Integer> iterator() {
        //迭代器 遍历
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {//是否有下一个元素
                return p!=null;
            }

            @Override
            public Integer next() {//返回当前值，并移动指针
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }


    //节点类
    private static class Node {
        int value;//值
        Node next;//下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //---向链表头部添加     value：待添加值
    //往单链表 第一次添加数据时（且添加为一号位）
    public void addFirst(int value) {
        //1.链表为空
        //head = new Node(value, null);
        //2.链表非空
        head = new Node(value, head);
    }

    //指针 遍历链表
    public void loop1(Consumer<Integer> consumer){
        Node p = head.next;
        while (p!=null){
           consumer.accept(p.value);
            p = p.next;
        }
    }
    //for循环遍历
    public void loop2(Consumer<Integer> consumer){
       for ( Node p = head.next;p!=null;p = p.next){
           consumer.accept(p.value);
       }
    }

    //---向尾部添加

    //找链表最后那个节点
   private Node findLast(){
        Node p;
       for (p = head;p.next!=null ;p=p.next){

       }
       return p;
   }
   //向链表尾部添加（带哨兵）
   public void addLast(int value){
       Node last = findLast();
       last.next = new Node(value,null);
   }

   //获取索引值指向的节点
    private Node findNode(int index){
        int i=0;
        for (Node p=head.next;p!=null;p=p.next,i++){
            if (index == i){
                return p;
            }
        }
        return null;//没找到
    }
    //根据索引获取值
    /*
    Params:index-索引
    Returns 找到，返回该索引位置节点的值
    throw new IllegalAccessException:找不到，抛出index非法异常
     */
    public int get(int index) throws IllegalAccessException {
        Node node = findNode(index);
        if (node==null){
            throw illegalIndex(index);
        }
        return node.value;
    }

    //异常方法
    private IllegalAccessException illegalIndex(int index) {
        return new IllegalAccessException(//非法的参数异常
                String.format("index[%d] 不合法%n", index));
    }

    //像索引位置插入
    /*
    Params:index-索引
    value-待插入值
     */
    public void insert(int index, int value) throws IllegalAccessException {
        if (index==0){//往0索引插入时
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);//找插入点的上一个索引
        if (prev==null){
            throw illegalIndex(index);
        }
        prev.next=new Node(value,prev.next);
    }

    //---删除
    //1.删除第一个界节点
    public void removeFirst() throws IllegalAccessException {
        if (head==null){
            throw illegalIndex(0);//空时
        }
        head=head.next;
    }
    //2.根据索引删除节点
    public void remove(int index) throws IllegalAccessException {
        if (index==0){//为第一个节点
            removeFirst();
            return;
        }
        Node prev = findNode(index-1);//前节点
        if (prev==null){//前节点不存在时
            throw illegalIndex(index);
        }
        Node removed = prev.next;//被删除的节点
        if (removed==null){  //该节点不存在时
            throw illegalIndex(index);
        }
        prev.next=removed.next;

    }
}