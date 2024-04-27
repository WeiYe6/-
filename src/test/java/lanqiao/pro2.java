package lanqiao;

import java.util.Iterator;

public class pro2 {

	public static void main(String[] args) {
		// A-阶乘求和
        //* 【问题描述】
        //* 令 S = 1 ! + 2 ! + 3 ! + . . . + 202320232023 ! ，求 S 的末尾 9 位数字。
//		long mod = (long) 1e9;
//		long res = 1;
//		long sum = 0;
//		for(int i = 1; i<= 50; i++) {
//			res = res * i % mod; //阶乘
//			sum = (res + sum) % mod;
//			System.out.println(sum);
//		}
		
		
		//B-进制转换
		//哈沙德数： 126 是十进制下的一个哈沙德数，因为 ( 126 ) 10 mod ( 1 + 2 + 6 ) = 0
		//* 如果一个整数在二进制、八进制、十进制、十六进制下均为 哈沙德数，
		//* 那么这个数字就是幸运数字，第 1 至第 10 个幸运数字的十进制表示 为：1 , 2 , 4 , 6 , 8 , 40 , 48 , 72 , 120 , 126...
		//* 现在他想知道第 2023 个幸运数 字是多少？你只需要告诉小蓝这个整数的十进制表示即可。
		int n = 1; //幸运数字
		int count = 0;//统计
		while(count < 2023) {
			if (is(n, 2) && is(n, 8) && is(n, 10) && is(n, 16)) {
				count ++;
			}
			if (count == 2023) {
				System.out.println(n);
			}
			n++;
		}
	}
	/**
	 * 判断在该进制下是否是 哈沙德数
	 * @param n 判断的数值
	 * @param x 进制
	 * @return 是或否
	 */
	public static boolean is(int n, int x) {
		int res = n;
		int sum = 0;
		//进制转换
		while(res > 0) {
			//短除法
			//先取模
			sum = sum + res % x;
			//再除以
			res = res / x;
		}
		return n % sum == 0;
	}

}
