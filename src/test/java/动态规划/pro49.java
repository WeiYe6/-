package 动态规划;

public class pro49 {

	public static void main(String[] args) {
		// 爬楼梯 - 动态规划
		//5.举例推导dp[]
		int n = 5; //答案: 1 2 3 5 8
		int fn1 = fn1(n);
		System.out.println(fn1);

	}
	
	public static int fn1(int n) {
		//动规五部曲
		//1.确定dp[i]数组，以及下标的含义
		//dp[i]: 在阶梯为i阶的楼层中，有dp[i]种上楼的方法
		int[] dp = new int[n+1];//索引从1开始
		
		//2.递推公式
		//dp[n] = dp[n-1] + dp[n-2] //如: n = 3 则 可以由 n=1 和 n=2的方法数相加而来
		//3.dp[]初始化 //不需要考虑0，默认没有0阶梯的
		dp[1] = 1;
		dp[2] = 2;
		//4.遍历顺序，后面的需要前面的状态，用正序
		//从3开始遍历
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

}
