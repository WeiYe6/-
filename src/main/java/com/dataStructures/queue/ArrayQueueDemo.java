package com.dataStructures.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s show(显示所有数据信息)");
            System.out.println("a add(添加数据)");
            System.out.println("g get(获取数据)");
            System.out.println("h showHead(显示头信息)");
            System.out.println("e exit(退出)");

            key = scanner.next();
            switch (key) {
                case "s":
                    arrayQueue.showQueue();
                    break;
                case "a":
                    System.out.println("请输入你要添加的数据");
                    int num = scanner.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case "g":
                    try {
                        System.out.println("取出的数据是" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        System.out.println("头节点的数据为:" + arrayQueue.showHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误，请再次输入！");
                    break;
            }

        }
        System.out.println("----------已退出程序----------");
    }

    //用数组来创建一个队列 : 先进先出
    static class ArrayQueue {
        private int MaxSize; //队列的最大容量
        private int front; //队列的头指针
        private int rear; //队列的尾指针
        private int[] arr; //创建一个数组，用来保存数据

        //创建队列数组的构造器
        public ArrayQueue(int maxSize) {
            this.MaxSize = maxSize;
            arr = new int[maxSize];
            front = -1; //指向队列头前一格
            rear = -1; //指向队列尾部的数据
        }

        //判断队列是否为满
        public boolean isFull() {
            return rear == MaxSize - 1;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }

        //添加数据到队列
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列已满，添加失败！");
                return;
            }
            rear++; //尾指针后移 -1 --> 0
            arr[rear] = n;
        }

        //让数据出队列 (获取数据)
        public int getQueue() {
            //判断是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列为空，无法获取数据。");
            }
            front++;
            return arr[front];
        }

        //展示所有数据
        public void showQueue() {
            //判断是否为空
            if (isEmpty()) {
                System.out.println("队列为空，无法获取数据。");
                return;
            }
            for (int i : arr) {
                System.out.println(i);
            }
        }

        //显示头部数据,不是取出数据
        public int showHead() {
            //判断是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列为空，无法获取数据。");
            }
            return arr[front + 1];
        }
    }
}
