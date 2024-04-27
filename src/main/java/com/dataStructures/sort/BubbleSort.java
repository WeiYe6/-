package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        //test1();
        //test2();
        //准备80000个随机数，测试一下冒泡排序需要多少时间
        int[] arr = new int[80000];
        int a = (int) (Math.random()*8000000);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
        }

        long start = System.currentTimeMillis();

        test3(arr);


        System.out.println("冒泡排序排 8万个数所花费的时间："+ (System.currentTimeMillis() - start));



    }


    private static void test3(int[] arr) {
        int temp = 0; //临时变量
        boolean flag = false; //标识变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag){
                //有元素移动了,继续下一次循环
                flag = false;
            }else {
                //没有任何元素移动,结束
                break;
            }

        }
    }
    private static void test2() {
        //优化版,添加一个标识符，如果有一次未交换，即可直接结束
        int[] arr = new int[]{3, 9, -1, 10, 20};
        int temp = 0; //临时变量
        boolean flag = false; //标识变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"次结果："+ Arrays.toString(arr));
            System.out.println();
            if (flag){
                //有元素移动了,继续下一次循环
               flag = false;
            }else {
                //没有任何元素移动,结束
                break;
            }

        }
    }


    private static void test1() {
        //非优化版
        int[] arr = new int[]{3, 9, -1, 10, -2};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"次结果："+ Arrays.toString(arr));
            System.out.println();
        }
    }
}
