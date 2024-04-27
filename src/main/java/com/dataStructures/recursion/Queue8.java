package com.dataStructures.recursion;

// 八皇后问题
public class Queue8 {
    //先初始化数组---当8*8的盘---用来保存 8个皇后放置后的正确位置 arr = {0,4,7,5,2,6,1,3}
    private final int Max = 8;
    private final int[] arr = new int[Max];

    private static int count = 0;
    private static int judgeCount = 0;

    public static void main(String[] args) {
        new Queue8().check(0);
        System.out.println("一共有" + count + "种解法");
        System.out.println("一共回溯了" + judgeCount + "次");
    }

    //开始摆放皇后
    private void check(int n) {
        //当 n==8 时，因为从0-7，就已经摆放完8个皇后了，所以结束了
        if (n == Max) {
            print();//找到正确的一组答案，并打印
            return;
        }
        for (int i = 0; i < Max; i++) {
            //第一次先放第一行第一列 0 0
            arr[n] = i;
            if (judge(n)) {//判断有无冲突，如果有冲突，即 i++，移动到同一行的后一个位置，直到满足条件。即可摆放一下皇后
                check(n + 1);//当前皇后 与 前面的皇后均无冲突，即可摆放下一个皇后。
            }
        }
    }

    /**
     * 判断当前皇后 摆放的位置是否符合要求
     *
     * @param n 表示第n个皇后
     * @return 是否符合
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {//分别用 当前的皇后（n） 与前面的（n-1）个皇后来比较条件
            //arr[i] == arr[n]: 判断是否在同一列
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i]):判断是否在对角线上
            //解析：行数的差值 与 列数的差值如果相等就是在同一斜线上：比如 11 22 33 44 或者 32  43等，加绝对值防止出现负数
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    // 用来打印每一种解法 (八个皇后)
    private void print() {
        count++;
        for (int i = 0; i < Max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
