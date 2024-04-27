package com.dataStructures.二分查找;

/*
    二分查找基础版
    Params:a-待查找的升序数组
           target-待查找的目标值
    Returns:
            找到则返回索引
            找不到返回-1
*/
public class a1BinarySearch {
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;//设置指针和初值
        while (i <= j) {
            int m = (i + j) >>> 1; // (java中/有向下取整) 向右移
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    /*
    问题1： 为什么是 i<=j 意味着区间内有未比较的元素，而不是i<j?
            i==j 意味着i，j 他们指向的元素是同一个时，m也为这个元素，而填写i<j时则匹配不到这个元素 返回-1

    问题2：(i+j)/2 有没有问题？
            有：当数组中的元素长度超出int类型时，最高位会变为符号位 1：为-  0：为+   那这时返回的就为-XXXX
            解决方法：用向右>>>符号，，当最高位为1时，则会被移到第二位，最高位用0补齐，相当于➗2（在非java语言也适用）

    问题3：都写成小于号有啥好处？
            习惯问题，人的思维都是升序，把大的放在右边，便于后边检查
     */

    //二分查找改动版
    // 区别 j :只是查找的边界，永远不可能为查找值
    public static int binarySearchBasic2(int[] a, int target) {
        int i = 0, j = a.length; //第一处
        while (i < j) {           //第二处
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;        //第三处
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    //二分查找 平衡版
    /*
    1.左闭右开的区间，i指向的可能时目标，而j指向的不是目标
    2.不在循环内找出，等范围内只剩i时，退出循环，在循环外比较啊a[i]与target
    3.循环内的平均比较次数减少了
    4.时间复杂度 0(log(n))
     */
    public static int binarySearchBasic3(int[] a, int target) {
        int i = 0, j = a.length;//定义指针
        while (1 < j - i) {//待查找的个数只剩一位时，退出循环
            int m = (i + j) >>> 1;
            if (target < a[m]) {//在左边
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) {
            return i;
        }else {
            return -1;
        }
    }

}
