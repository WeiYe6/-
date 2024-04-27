package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 操作步骤：
 * 初始时，有一个大小为 10 的无序序列。
 * 1. 在第一趟排序中，我们不妨设 gap1 = N / 2 = 5，即相隔距离为 5 的元素组成一组，可以分为 5 组。
 * 2. 接下来，按照直接插入排序的方法对每个组进行排序。
 * 3. 在第二趟排序中，我们把上次的 gap 缩小一半，即 gap2 = gap1 / 2 = 2 (取整数)。这样每相隔距离为 2 的元素组成一组，可以分为 2 组。
 * 4. 按照直接插入排序的方法对每个组进行排序。
 * 5. 在第三趟排序中，再次把 gap 缩小一半，即gap3 = gap2 / 2 = 1。 这样相隔距离为 1 的元素组成一组，即只有一组。
 * 6. 按照直接插入排序的方法对每个组进行排序。此时，排序已经结束。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0,13,-5,63,34,-9};
        //ShellSort(arr);
        ShellSort2(arr);
    }



    //希尔移动式
    public static void ShellSort2(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap = gap / 2) {
            //从步长值往后的元素来进行判断
            for (int i = gap; i < arr.length; i++) {
               int temp = arr[i];
               int j = i;
              // if (arr[i] < arr[j - gap]){
                   // j-pag: 保证索引不越界 temp < arr[j-gap]:保证在同一组内
                    while (j-gap>=0 && temp < arr[j-gap]){
                        arr[j] = arr[j -gap]; //交换
                        j = j - gap;//这里减去了相隔的距离
                    }
                    arr[j] = temp;//交换
              // }
            }
            System.out.println("轮希尔排序：" + Arrays.toString(arr));
        }
    }

    //希尔交换式
    public static void ShellSort(int[] arr) {
        int temp = 0;
        for (int agp = arr.length / 2; agp > 0; agp = agp / 2) {
            for (int i = agp; i < arr.length; i++) {
                for (int j = i - agp; j >= 0; j = j - agp) {
                    //一个组内需要满足后面的元素 大于 前面的元素
                    if (arr[j] > arr[j + agp]) {//这里前面的大于后面的，交换位置
                        temp = arr[j];
                        arr[j] = arr[j + agp];
                        arr[j + agp] = temp;
                    }
                }
            }
            System.out.println("轮希尔排序：" + Arrays.toString(arr));
        }
    }

}


/*        //分步走  第一轮排序
        //步长为5的一组
        int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j = j - 5) {
                //一个组内需要满足前面的元素 大于 后面的元素
                if (arr[j] > arr[j + 5]) {//前面的大于后面的，交换位置
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮希尔排序：" + Arrays.toString(arr));

        //分步走  第二轮排序
        //步长为2的一组
        temp = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j = j - 2) {
                //一个组内需要满足前面的元素 大于 后面的元素
                if (arr[j] > arr[j + 2]) {//前面的大于后面的，交换位置
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮希尔排序：" + Arrays.toString(arr));

        //分步走  第三轮排序
        //步长为1的一组
        temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j = j - 1) {
                //一个组内需要满足前面的元素 大于 后面的元素
                if (arr[j] > arr[j + 1]) {//前面的大于后面的，交换位置
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮希尔排序：" + Arrays.toString(arr));*/


