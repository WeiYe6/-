package com.dataStructures.search;

/**
 * 插值查找 （二分查找的一个改进版本），注意区分【二分查找 和 插值查找 的关系】
 * 特点:
 * 1.查找的序列必须有序
 * 2.对于数据量大的以及关键字分布均与的有序序列来说，插值查找的速度较快。
 * 3.对于分布不均匀的有序序列来说，该算法不一定比二分查找好！！！
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 89, 1000, 1234};
        int index = InsertValue(arr, 0, arr.length - 1, 1234);
        System.out.println("index = " + index);
    }

    //插值插值
    private static int InsertValue(int[] arr, int left, int right, int findValue) {
        System.out.println("输出的次数为~~~");
        //改进一： 找出口
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return -1;
        }
        //改进二： 求mid值 :公式改变了
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue) {
            //右递归
            return InsertValue(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            //左递归
            return InsertValue(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
