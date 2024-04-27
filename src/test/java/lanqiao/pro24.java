package lanqiao;

import java.util.Scanner;

public class pro24 {

	public static void main(String[] args) {
		// 前缀和 -- 打基础
		// 题目: 给n个整数，请求它们两两相乘再相加的和
		// n = 3
		// 如 s = a1 * a2 + a1 * a3 + a2 *a3 的和
//		// 可以化简为 a1(s - a1) + a2(s - a1 - a2)
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int[] arr = new int[n];
//		long sum = 0;
//		long res = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i]; //累加和
//		}
//		
//		//计算相乘再相加
//		for (int i = 0; i < arr.length; i++) {
//			sum = sum - arr[i]; //不断改变sum，如当i==1时，sum = sum - a1 - a2 了
//			res = res + arr[i] * sum;
//		}

		// 前缀和 --- 打基础2
		// 计算：数组n, m[l, r]的区间和
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scanner.nextInt();
		}
		long[] sum = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + arr1[i - 1];
		}

		// 区间范围
		int m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			// 因为我们的数组索引是从0开始的
			int l = scanner.nextInt() - 1;
			int r = scanner.nextInt() - 1;
			System.out.println(sum[r + 1] - sum[l]);
		}
		scanner.close();

	}

}
