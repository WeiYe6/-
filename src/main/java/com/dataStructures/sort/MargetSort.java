package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分而治之的思想
 */
public class MargetSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        margetSort(arr,0, arr.length-1, temp);

        System.out.println(Arrays.toString(arr));
    }


    //分 + 合 的方法
    public static void margetSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归进行分解
            margetSort(arr, left, mid, temp);
            //向右递归进行分解
            margetSort(arr,(mid+1),right, temp);
            //合并
            marge(arr, left, mid, right, temp);
        }
    }


    /** 合并的方法
     * @param arr   排序的原始数组
     * @param left  数组的开始缩影
     * @param mid   中间位置的索引
     * @param right 右边的索引
     * @param temp  临时数组
     */
    public static void marge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //先初始化下标（第一部分）
        int j = mid + 1;//要合并的 第二部分的数组下标
        int t = 0; //临时数组的下标
        //1）先把左右两边要合并的有序数组，按照从小到大填充到temp数组中
        //直到有某一边全部填充进temp数组中
        while (i <= mid && j <= right) {  //有一边填充完即可停止
            //当第一部分（左边),的数比右边的数要 小 或者 相等 时，就把该数放进temp数组中
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                //把 i 向后移动
                t++; //为下一个要填充的数做准备
                i++;
            } else {
                temp[t] = arr[j];
                t++; //为下一个要填充的数做准备
                j++; //向后移动
            }

        }
        //2) 到这里就说明某一边的数据已经全部填充进temp数组中了
        //接下来，就是把剩余的那部分，按照原本的排序顺序，一一填充进temp数组中
        while (i <= mid) { //假设为左部分
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) { //假设为右部分
            temp[t] = arr[j];
            j++;
            t++;
        }
        //3）到这里，全部的数组均按从小到大的顺序，填充进temp数组中
        //接下来，就是把该temp数组的数据，全部拷贝回原来的arr数组中
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
}
