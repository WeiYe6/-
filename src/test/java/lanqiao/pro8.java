package lanqiao;

import java.util.Scanner;

public class pro8 {

	public static void main(String[] args) {
		// 题目: 三角回文数
//      对于正整数 n ，如果存在正整数 k 使得 n = 1 + 2 + 3 + · · · + k = k(k+1)/ 2 ，
//		则 n 称为三角数。例如，66066 是一个三角数，因为 66066 = 1 + 2 + 3 + · · · + 363。
//				如果一个整数从左到右读出所有数位上的数字，与从右到左读出所有数位 上的数字是一样的，
//				则称这个数为回文数。例如，66066 是一个回文数，8778 也是一个回文数。 
//				如果一个整数 n 既是三角数又是回文数，我们称它为三角回文数。例如 66066 是三角回文数。 
//		请问，第一个大于 20220514 的三角回文数是多少？

		long k = 0;
		for (long i = 0; i <= 10000; i++) {
			if ((i * i + i) > 20220514 * 2) {
				k = i; // 找出第一个大于20220524，的三角数的k值
				break;
			}
		}
		// 从 k 往后依次遍历寻找下一个三角数
		for (long j = k; j <= 100000; j++) {
			long n = (j * j + j) / 2;
			// 判断该三角数是不是回文数
			if (is(n)) {
				System.out.println(n);
				break;
			}
		}
	}

	// 判断该数是不是回文数
	private static boolean is(long n) {
		StringBuilder stringBuilder = new StringBuilder(Long.toString(n));
		String s = n + ""; // 原始数据
		stringBuilder.reverse();// 反转之后的数据
		return stringBuilder.toString().equals(s);
	}

}
