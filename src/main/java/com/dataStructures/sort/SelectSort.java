package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 循环规则：
 * 1. 先假定当前这个数就是最小数
 * 2. 然后和后面的每一个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标。
 * 3. 当遍历到数组的最后时，就得到本轮最小数和下标
 * 4. 就开始进行交换
 */
public class SelectSort {
    public static void main(String[] args) {

        Select();
    }

    public static void Select() {
        int[] arr = {101, 34, 119, 1};
        //1.假定数组中的第一个数就是最小值
        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;
            int min = arr[minIndex];
            //第一轮比较，并找到最小值，放在数组第一位
            for (int i = 1 + j; i < arr.length; i++) {
                //将假设中最小的数，和剩下的其它数据进行比较，获取到最小值和该索引，并放置在数组第一位
                if (min > arr[i]) {
                    //获取到最小值和该索引 -- 记录
                    min = arr[i];
                    minIndex = i;
                }
            }
            //和最后一次获取到的最小值进行交换(确定了真正的最小值)
            if (minIndex != j) {//这里的判断就是，如果找到的最小值为自己，即索引没有任何变化，可以跳过交换
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
            System.out.println("第" + (j + 1) + "次选择排序的结果:" + Arrays.toString(arr));
        }


//
//        //1.假定数组中的第一个数就是最小值
//        minIndex = 1;
//        min = arr[minIndex];
//        //第一轮，比较，并找到最小值，放在数组第一位
//        for (int i = 1 + 1; i < arr.length; i++) {
//            //将假设中最小的数，和剩下的其它数据进行比较，获取到最小值和该索引，并放置在数组第一位
//            if (min > arr[i]) {
//                //获取到最小值和该索引 -- 记录
//                min = arr[i];
//                minIndex = i;
//            }
//        }
//        //和最后一次获取到的最小值进行交换
//        if (minIndex != 1) { //这里的判断就是，如果找到的最小值为自己，即索引没有任何变化，可以跳过交换
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//        System.out.println("第二次选择排序的结果:" + Arrays.toString(arr));
//
    }
}
