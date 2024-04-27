/*
package com.dataStructures.二分查找;

import org.junit.Test;

import java.util.Arrays;

public class a3BinarySearchJava {
    */
/*
    java的二分查找源码分析：得知 return 插入点-1;
     *//*

    @Test
    public void test1() {
        int[] a = {2, 5, 8};
        int target = 4;

        //二分查找
        int i = Arrays.binarySearch(a, target);
        System.out.println(i);//-2  用途：把该元素按升序插入数组中  -2 = 插入点-1

        if (i < 0) {
            int insertIndex = Math.abs(i + 1);//插入点索引
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);//把原数组后面的补上
            System.out.println(Arrays.toString(b));
        }

    }

    */
/*
     找二分查找重复元素的最左侧
    *//*

    @Test
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;//设置指针和初值
        int temp = -1;  //定义候选者
        while (i <= j) {
            int m = (i + j) >>> 1; // (java中/有向下取整) 向右移
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                temp = m;  //记录侯选位置,进行元素覆盖
                j = m-1;
            }
        }
        return temp;
    }
    */
/*
    找二分查找重复元素的最左侧 改进版
    i:意义为 返回大于等于target值最左侧的索引值
   *//*

    @Test
    public static int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else{
                i = m + 1;
            }
        }
        return i;
    }

}
*/
