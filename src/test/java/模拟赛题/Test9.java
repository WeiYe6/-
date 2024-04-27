package 模拟赛题;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个序列 a[1], a[2], …, a[n] 和一个整数 k，请找出一个长度正好为 k 的区间，使得区间中所有数的和最大。
 * 　　即要找到一个整数 p ，使得 1 <= p 且 p+k-1 <= n ，使得 a[p]+a[p+1]+...+a[p+k-1] 最大。
 * 输入格式
 * 　　输入的第一行包含两个整数 n , k。
 * 　　第二行包含 n 个整数，相邻的整数之间使用一个空格分隔，表示给定的序列。
 * 输出格式
 * 　　输出一行包含一个整数，表示最大的区间和，你只需要输出和就行，不需要输出方案。
 * 样例输入
 * 6 3  //6: 为第二行的个数   3:为区间
 * 2 3 9 1 9 5
 * 样例输出
 * 19
 * 评测用例规模与约定
 * 　　对于 30% 的评测用例，1 <= k <= n <= 30，1 <= a[i] <= 100。
 * 　　对于 60% 的评测用例，1 <= k <= n <= 1000，1 <= a[i] <= 10000。
 * 　　对于所有评测用例，1 <= k <= n <= 100000，1 <= a[i] <= 1000000。
 */

/**
 * 这是一个经典的滑动窗口问题。我们可以使用滑动窗口来解决这个问题。
 *
 * 算法步骤如下：
 * 1.初始化一个变量sum为0，表示当前窗口中所有数的和。
 * 2.计算初始窗口的和，即前k个数的和，并将其赋值给sum。
 * 3.初始化一个变量maxSum为sum，表示最大区间和。
 * 4.遍历序列的剩余元素，从第k+1个元素开始：
 * 5.将上一个窗口的第一个数去掉，即将sum减去窗口中最左边的数。
 * 6.将下一个数添加到窗口中，即将sum加上下一个数。
 * 7.更新maxSum，如果sum大于maxSum则更新。
 * 8.输出maxSum，即为最大的区间和。
 */
public class Test9 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(); //n：序列的个数
            int k = scanner.nextInt(); //k：区间的大小

            int[] arr = new int[n];   //1 <= k <= n
            for (int i = 0; i < n; i++) { //读取1-n个输入的数
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < k; i++) {//第一个区间和
                sum += arr[i];
            }

            int maxSum = sum; //区间最大和
            for (int i = k; i < n; i++) {//移动窗口，继续判断下一个窗口的区间和
                sum -= arr[i - k];
                sum += arr[i];
                maxSum = Math.max(maxSum, sum);
            }

            System.out.println(maxSum);
        }

}
