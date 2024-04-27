package 真题;

import java.util.Scanner;

public class pro3 {

	public static void main(String[] args) {
		// 题目1-快速幂
		// 学会了 BigInteger的用法
		Scanner scanner = new Scanner(System.in);
//		BigInteger b = scanner.nextBigInteger();
//		BigInteger p = scanner.nextBigInteger();
//		BigInteger k = scanner.nextBigInteger();
//		//b.modPow(p, k) 表示计算 b 的 p 次幂对 k 取模的结果
//		System.out.println( b.modPow(p, k));

		// 题目2-阶乘的和
//		数组中的每个数都表示它自身的阶乘，而不是简单的数字。
//		例如，如果数组中有一个数是3，那么它表示的是3的阶乘，即6。

		// 写这道题需要认识的数学逻辑：3!+ 3!+ 3!+ 3! = 1* 4! ===> 4 个 3! 合成一个 4!
		// 合并判断 count % (min + 1) % == 0 且 min != 0, 一定是可以整除才能合并为下一个新的(min+1)!
		// 如果不能整除 --- 2 2 2 2 ==> 合并出来就是 2 + 3! 不符合我们的题意：最大因数，因此这题最大因数 m! = 2
		// count = 4、min = 3 、新的个数 count = 4 / 3 = 1 min = 1 * (3+1)
		int n = scanner.nextInt();
		long[] arr = new long[n];
		long min = Integer.MAX_VALUE; // 记录数组的最小值
		long countMin = 0; // 记录该数组中最小值的个数
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextLong();
			min = Math.min(min, arr[i]);
		}
		// 不断寻找不断合并 eg 3！3! 3！ 3! ===> 可以合并成 4！
		while (true) {
			// 这里就是我下面所说的，如果有 8 个4那么是不是可以合并成 2 * 4!
			// 这里是不是要记录countMin = 4
			countMin = countMin / min;// 记录下一个min值的个数
			// 寻找当前 min值的个数
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == min)
					countMin++;
			}
			// 合并：最重点来了
			// 需要掌握的知识 min = 3、countMin = 4 -- 3 3 3 3
			// 如何判断是否可以合并为4？
			// if countMin % (min + 1) == 0 && min != 0,可以整除，说明有 4 个或者
			// 8 个 3 ，4的倍速都是可以合并
			if (countMin % (min + 1) == 0 && min != 0) {
				min++;// 合并成功
			} else {
				break;// 合并失败，查找终止了，最大的m！就是 min了
			}
		}
		scanner.close();
		System.out.println(min);
	}

}
