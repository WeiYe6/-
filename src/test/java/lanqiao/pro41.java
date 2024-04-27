package lanqiao;

import java.util.Scanner;

public class pro41 {

	public static void main(String[] args) {
		// 数组分割 -- 数学逻辑
		// 有一个数组 A = [A0 , A1, A2, A3]
		// 获取一个R1 子集 和 s1 ， 剩下的R2补集 和 s2，要求 s1 和 s2 均为偶数，问有多少中分法
		// eg ：输入格式
		// 1 数组的个数
		// 2 数组的长度
		// 6,6
		// 答案: 4种 0 12、6 6、 6 6 、12 0 2的2次方
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] result = new int[n]; //存储结果的
		for (int i = 0; i < n; i++) {
			int len = scanner.nextInt();
			int odd = 0; // 奇数个数
			int even = 0; // 偶数个数
			for (int j = 0; j < len; j++) {
				// 分别记录奇偶数的个数
				if (scanner.nextInt() % 2 == 0) {
					even++;
				} else {
					odd++;
				}
			}
			//数学逻辑:
			//如果奇数个数为奇数：则结果为0
			//否则结果为: 2^偶数个数 * 2^奇数个数减一，为什么减一（因为奇数是需要成对出现的），
			//2的次幂: 就是每个数有两种选择
			if (odd % 2 == 0) {//奇数个数不为奇数 , 考虑奇数个数为0的情况
				result[i] = (int)((Math.pow(2, even) * Math.pow(2, odd == 0 ? 0 : odd-1)) % 1000000007);
			}else {
				result[i] = 0;
			}
		}
		//输出结果集
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}

}
