package lanqiao;

import java.util.Scanner;

public class pro32 {

	public static void main(String[] args) {
		// 求 1 - 20230408 中每个数的和
		// 暴力
//		long sum = 0;
//		for(int i = 1; i<= 20230408; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		int i = 1;
		int count = 0;
		while (true) {
			if (is(i, 2) && is(i, 8) && is(i, 10) && is(i, 16)) {
				count++;
			}
			if(count == 2023) {
				break;
			}
			i++;
		}
		System.out.println(i);

	}

	// 进制的转换,且获取出该进制下的每个位数的累加和
	public static boolean is(int n, int x) {
		int i = n;
		int sum = 0;
		while (i != 0) {
			sum += i % x;
			i = i / x;
		}
		return n % sum == 0;
	}

}
