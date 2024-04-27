package com.dataStructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找 :条件，查找的数组必须是有序的，从小到大 或 从大到小
 * 思路分析
 * 1.首先获取mid = （left + right）/ 2,数组索引中间数的索引
 * 2.判断：让要查找的数findValue 和 arr[mid] 比较
 * 3. findValue < arr[mid] ,表示要查找的数，在mid的左边，那么就递归左边的数值，继续查找
 * 4.findValue > aa[mid], 表示表示要查找的数，在mid的右边，那么就递归右边的数值，继续查找
 * 5.否则：返回 return mid.【说明：1.findValue = mid,返回该索引】
 * 何时结束：
 * 1.找到该值就结束，return mid;
 * 2.如何要查找的数，不在该数值中也结束： left > right,已经找遍了。
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2, 2, 8, 10, 89, 1000, 1000, 1000, 1000, 1000};
/*        int result = binary(arr, 0, arr.length - 1, -10);
        System.out.println("result = " + result);*/
        List<Integer> result = binary(arr, 0, arr.length - 1, 1000);
        System.out.println(result);

    }


    //优化，当有相同值时，返回多个索引，用集合接收
    public static List<Integer> binary(int[] arr, int left, int right, int findValue) {
        //找出口，如果找不到就退出
        if (left > right) {
            return null;
        }
        //创建一个临时集合，用来记录返回的索引下标
        List<Integer> temp = new ArrayList<>();
        //获取mid
        int mid = (left + right) / 2;
        //判断
        if (findValue < arr[mid]) {//在左边
            //递归左边继续找
            return binary(arr, left, mid - 1, findValue);
        } else if (findValue > arr[mid]) {//在右边
            //递归右边继续找
            return binary(arr, mid + 1, right, findValue);
        } else { //findValue == arr[mid],返回结果
            //当要查找的值，有多个相同值时，用集合接收，一并返回所有的索引
            //向左边继续移动一个位置
            int indexMid = mid - 1;
            while (indexMid >= 0  &&  findValue == arr[indexMid]) {
                temp.add(indexMid);
                indexMid--; //向左移动
            }

            temp.add(mid); //把中间哪个值也放入，就是进入else时的值。

            //向右边继续移动一个位置
            indexMid = mid + 1;
            while (indexMid <= right && findValue == arr[indexMid] ) {
                temp.add(indexMid);
                indexMid++; //向右移动
            }
            return temp;
        }
    }

/*    public static int binary(int[] arr, int left, int right, int findValue) {
        //找出口，如何找不到就退出
        if (left > right) {
            return -1;
        }
        //获取mid
        int mid = (left + right) / 2;
        //判断
        if (findValue < arr[mid]) {//在左边
            //递归左边继续找
            return binary(arr, left, mid - 1, findValue);
        } else if (findValue > arr[mid]) {//在右边
            //递归右边继续找
            return binary(arr, mid + 1, right, findValue);
        } else { //findValue == arr[mid],返回结果
            return mid;
        }
    }*/
}
