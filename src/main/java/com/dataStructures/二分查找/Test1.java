package com.dataStructures.二分查找;

public class Test1 {
    public static void main(String[] args) {
        /*
        给你一个按照非递减顺序的整数数组，和一个目标值，找出开始位置和结束位置 如{1,2,2,2,3}-- 返回[1,3]  否则返回[-1,-1]
         */

        int[] arr = {1,2,3,3,3,4,5,6};
        int x = left(arr, 3);
        int y = right(arr, 3);
        if (x==-1){
            System.out.println("[-1,-1]");
        }else {
            System.out.println("["+x+","+y+"]");
        }

    }
    public static int left(int[] a ,int target){
        int i = 0,j=a.length - 1;
        int candidate = -1;
        while (i<=j){
            int m = (i+j)>>>1;
            if (target<a[m]){
                j = m - 1;
            }else if (a[m] < target){
                i = m+1;
            }else {
                candidate = m;
                j = m-1;
            }
        }
        return candidate;
    }

    public static int right(int[] a ,int target){
        int i = 0,j=a.length - 1;
        int candidate = -1;
        while (i<=j){
            int m = (i+j)>>>1;
            if (target<a[m]){
                j = m - 1;
            }else if (a[m] < target){
                i = m+1;
            }else {
                candidate = m;
                i = m+1;
            }
        }
        return candidate;
    }
}
