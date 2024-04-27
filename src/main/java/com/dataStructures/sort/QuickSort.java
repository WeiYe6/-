package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 思路：
 * 先定一个基准点（左边|右边），这里我选择左边，在左右两边分别放置一个哨兵l 和 哨兵r
 * 1.先让r 从右往左移动，找到比基准点小的数的索引，
 * 2.再让l 从左往右移动，找到比基准点大的数的缩影，
 * 3.然后交换r 和 l索引下的值，
 * 4.直到l = r,交换基准点和r下的索引位置，，即实现了，base左边的比它小，base右边的比它大。
 * 5.递归base左边的，递归base右边的，重复上面的步骤，即可实现从小到大排序。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8,18,-1};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int left, int right) {
        //定义出口
        if (left > right) {
            return;
        }
        // 先定一个基准点,这里我选择左边，在左右两边分别放置一个哨兵l 和 哨兵r
        int base = arr[left];
        int l = left;
        int r = right;
        while (l != r) { //左右两边判断完了，即l==r（r 一定 小于等于基准点）
            // 1.先让r 从右往左移动，找到比基准点小的数的索引，(注意这里，一定要先让r移动)
            while (arr[r] >= base && r > l) { //r > l: 保证当r == l 时结束循环
                r--;  //当出来该循环时，应该是arr[r] < base
            }
            //2.再让l 从左往右移动，找到比基准点大的数的缩影，
            while (arr[l] <= base && r > l) {
                l++;  //当出来该循环时，应该是arr[r] > base
            }
            //3.然后交换r 和 l索引下的值，
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        //4.直到l = r,交换基准点和r下的索引位置，，即实现了，base左边的比它小，base右边的比它大。
        arr[left] = arr[r];
        arr[r] = base;
        //5.递归base左边的，递归base右边的，重复上面的步骤，即可实现从小到大排序。
        //递归排左边的位置
        quick(arr, left, r - 1);
        //递归排右边的位置
        quick(arr, l + 1, right);

    }
}
