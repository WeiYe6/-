package 动态规划;

public class pro48 {

	public static void main(String[] args) {
		// 动态规划 - 五部曲
		//1.确定dp数组以及下标的含义
		//2.确定递推公式
		//3.dp数组如何初始化
		//4.确定遍历顺序
		//5.举例推导dp数组
		
		//举例推导
		int n = 5; //答案: 1 2 3 5 8
		int fn1 = fn1(n);
		System.out.println(fn1);
		
		int fn2 = fn2(n);
		System.out.println(fn2);
		

	}
	//给你一个数n， 求出该数的斐波那契数
	public static int fn1(int n) {
		if(n <= 1) {
			return n;
		}
		//1.确定dp数组以及下标的含义
		//dp[i]: 第i个数对应的斐波那契数就是dp[i]
		int[] dp = new int[n+1];//长度为 n+1,因为我们需要的是dp[n],索引+1
		//2.推导公式
		//dp[n] = dp[n-1] + dp[n-2]
		//3.dp[]如何初始化
		dp[0] = 1;
		dp[1] = 1;
		//4.确定遍历顺序 - 正序遍历 (需要前面的状态值)
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	//可以状压
	public static int fn2(int n) {
		int a = 1;
		int b = 2;
		int temp = 0;
		//4.确定遍历顺序 - 正序遍历 (需要前面的状态值)
		for(int i = 3; i<= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}

}
