package 动态规划;

public class pro61 {

	public static void main(String[] args) {
		// 57. 爬楼梯（第八期模拟笔试）
//		时间限制：1.000S  空间限制：128MB
//		题目描述
//		假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//		每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//		注意：给定 n 是一个正整数。
//		输入描述
//		输入共一行，包含两个正整数，分别表示n, m
//		输出描述
//		输出一个整数，表示爬到楼顶的方法数。
//		输入示例
//		3 2
//		输出示例
//		3
		
//		此时你有三种方法可以爬到楼顶。
//		1 阶 + 1 阶 + 1 阶段
//		1 阶 + 2 阶
//		2 阶 + 1 阶
		int n = 3;
		int m = 2;
		int fn = fn(n, m);
		System.out.println(fn);

	}
	//爬楼梯进阶版 - 完全背包 排列组合
	public static int fn(int n, int m) {
		//1.dp数组含义: 装满容量为j的背包，所具有的方法数为dp[j]
		int[] dp  = new int[n+1];
		//2.递推公式: 排列组合: dp[j] += dp[j-nums[i]]
		//这里 就是减去 1--m
		//3.初始化
		dp[0] = 1;
		//遍历顺序: 完全背包 - 排列问题
		//（正序）遍历背包，再遍历物品
		for(int j = 1; j <= n; j++) {//背包
			for(int i = 1; i <= m; i++) {//物品
				if(j >= i) {
					dp[j] += dp[j-i];
				}
			}
		}
		return dp[n];
	}

}
