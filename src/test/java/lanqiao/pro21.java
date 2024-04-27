package lanqiao;

import java.util.Scanner;

public class pro21 {

	public static void main(String[] args) {
		// 模拟法 -- 打基础
		// 题目: 一个正整数n 和 一个小于n的正整数v，满足： （v * v） % n，之后，结果可能小于n的一半，
		// 也可能大于等于n的一半
		// eg：当n = 5时，1，4平方 对5取模，的余数都是1，小于5的一半
		// 问: 在1--(n-1)中，有多少个数平方之后除以n的余数小于n的一半。
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		for (int i = 1; i < n; i++) {
			long res = i * i;
			res = res % n;
			if (res < n / 2) {
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
