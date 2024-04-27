package lanqiao;

public class pro27 {

	public static void main(String[] args) {
		// 1 - 2021 最短路径： 动态规划
		//题目要求 1 和 2021之前的最短路径
		// 定义一个数组来存储最短路径
		int[] dp = new int[2022]; // 长度为2022的原因，我们是从1--2021的，为了方便计算，把0索引抛弃
		dp[1] = 0; // 第一个初始化为0，用与计算
		// 由于我们是要求最短路径，所以需要把数组初始化为最大值
		for (int i = 2; i <= 2021; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		// 动态规划
		// dp[j]: 可以是 当前 1-j的最短距离 或者 前一状态到该点的距离
		for(int i = 1; i <= 2020; i++) {// 前一个值
			for(int j = i+1; j<= 2021 && (j - i <= 21); j++) {// 后一个值
				//存储最短路径
				dp[j] = Math.min(dp[j], dp[i] + gcd(i, j));
			}
		}
		System.out.println(dp[2021]);

	}

	// 求两数的最小公倍数
	public static int gcd(int a, int b) {
		// 此题b 大于 a
		int x = a, y = b;
		int temp = 0;
		while (b % a != 0) {
			temp = b % a;
			b = a;
			a = temp;
		}
		return x * y / a;

	}

}
