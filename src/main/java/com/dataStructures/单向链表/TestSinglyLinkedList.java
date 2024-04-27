//package com.dataStructures.单向链表;
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//
//public class TestSinglyLinkedList {
//
//    @Test
//    public void teat1(){
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
//
//        list.loop2(value -> {
//                System.out.println(value);
//        });
//    }
//
//    @Test
//    public void teat2(){
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
//
//        for (Integer value : list) {
//            System.out.println(value);
//        }
//    }
//
//    @Test
//    public void teat3() throws IllegalAccessException {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//
//        list.insert(3,8);
//        //list.insert(6,9);
//        list.removeFirst();//删除第一个节点
//        for (Integer value : list) {
//            System.out.println(value);
//        }
//
//    }
//
//    @Test
//    public void teat4() throws IllegalAccessException {
//SinglyLinkedList list = new SinglyLinkedList();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//
//        list.remove(0);
//        for (Integer value : list) {
//            System.out.println(value);
//        }
//
// SinglyLinkedList list2 = new SinglyLinkedList();
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(4);
//
//        list2.remove(1);
//        for (Integer value : list2) {
//            System.out.println(value);
//        }
//
//
//        SinglyLinkedList list2 = new SinglyLinkedList();
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(4);
//
//        //list2.remove(5);
//        list2.remove(4);
//        for (Integer value : list2) {
//            System.out.println(value);
//        }
//
//    }
//
//    @Test
//    @DisplayName("测试 addFirst")
//    public void test5(){
//        SinglyLinkedList list =  new SinglyLinkedList();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        for (Integer value : list) {
//            System.out.println(value);
//        }
//    }
//}
