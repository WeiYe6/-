package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 思想：先把数组中第一个元素看成是有序的，剩余的元素看成是无序的，把无序的元素往，有序的元素中插入(大->小 || 小-> 大)
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1};
        InsertSort(arr);
    }

    public static void InsertSort(int[] arr) {

        int indexValue = 0;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            indexValue = arr[i];
            index = i - 1;
            while (index >= 0 && indexValue < arr[index]) {
                arr[index + 1] = arr[index];
                //继续往前判断，寻找插入点
                index--;
            }
            //if (index + 1 != i) {
                arr[index + 1] = indexValue;
            //}
            System.out.println("第"+i+"轮插入排序:" + Arrays.toString(arr));
        }


/*
        //为了方便理解我们一轮一轮来
        //测试数组{101, 34, 119, 1}
        //将数组的第一个值看作一个有序数组，他后面的为无序数组，从这个无序的数组中抽出第一个来进行插入

        //第一轮           选择从小到大
        //1.先存储要插入的元素
        int indexValue = arr[1];
        //2.存储待插入的索引值
        int index = 1 - 1;
        //index >= 0:保证插入的索引不会越界
        // indexValue < arr[index] ,要插入的元素和它前一个元素进行比较(并不断寻找插入点)
        while (index >= 0 && indexValue < arr[index]) {
            //进入了说明，满足上面的条件
            //让和插入元素第一次进行比较的元素进行后移
            arr[index + 1] = arr[index];
            //继续往前判断，寻找插入点
            index--;
        }
        //当退出循环后，即为找到了待插入点的位置
        //把该元素，插入进去，这里的index + 1，就是在最后一次比较元素的后面插入，因为最后一次比较的元素，不满足 indexValue < arr[index]
        arr[index+1] = indexValue;
        System.out.println("第一轮插入排序:" + Arrays.toString(arr));
*/

    }
}
