package 动态规划;

import java.util.HashMap;

public class pro44 {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		// 动态规划 - 练习理解

		// 递归 - 跳台阶
		System.out.println(fn2(100)); 
		//动态规划 
		System.out.println(dp(100));

	}

	// 递归
	// 时间复杂度 2^n 指数级别
	public static int fn1(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return fn1(n - 1) + fn1(n - 2);
	}

	// 优化递归 - 带备忘录的递归
	public static int fn2(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (map.containsKey(n)) { // 之前的值计算过
			return map.get(n);
		} else { // 没计算过，添加进备忘录中
			map.put(n, (fn2(n - 1) + fn2(n - 2))  % 1000000007 );
			return map.get(n);
		}
	}
	
	//动态规划解决 : 自底向上
	public static int dp(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int temp = 0;
		int a = 1;
		int b = 2;
		for(int i = 3; i<= n; i++) {
			temp = (a + b) % 1000000007;
			a = b;
			b = temp;
		}
		return temp;
	}

}
