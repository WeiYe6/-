package 动态规划;

import java.util.Scanner;

public class pro42 {

	public static void main(String[] args) {
		// 数组分割 -- 动态规划
		// 状态转移方程
		Scanner scanner = new Scanner(System.in);
		long mod = 1000000007;
		int[] arr = new int[1010];     //存储每个数组数据的
		long[][] dp = new long[1010][2]; 
		//dp[i][0] 从前i个数中选出和为偶数的方案数
		//dp[i][1] 从前i个数中选出和为奇数的方案数
		int t = scanner.nextInt();
		// 奇数+奇数=偶数 、 偶数+偶数=偶数 、 奇数+偶数=奇数
		for (int i = 1; i <= t; i++) {
			int n = scanner.nextInt();
			long sum = 0; //累加和
			for (int j = 1; j <= n; j++) {
				arr[j] = scanner.nextInt();
				sum += arr[j];
			}
			if (sum % 2 == 1) {//和为奇数时，不能再分了
				System.out.println(0);
				continue;
			}
			//动态规划
			//对于第i个数 有 选和不选
			//对于第i个状态，第i-1个状态一定是我们求出来已知的状态
			//dp初始化
			for(int j = 1; j <= n; j++) {
				dp[j][0] = dp[j][1] = 0;
			}
			dp[0][0] = 1; //为空集时有一种方案
			for(int k = 1; k <= n; k++) {
				if(arr[k] % 2 ==1) {//奇数时，如何满足方案 的选择
					dp[k][0] = (dp[k-1][0] + dp[k-1][1]) % mod; //为偶数的方案 不选 选
					dp[k][1] = (dp[k-1][1] + dp[k-1][0]) % mod; //为奇数的方案 不选 选
				}else {//偶数
					dp[k][0] = (dp[k-1][0] + dp[k-1][0]) % mod; //不选 选
					dp[k][1] = (dp[k-1][1] + dp[k-1][1]) % mod; //不选 选
				}
			}
			System.out.println(dp[n][0]);
		}
		scanner.close();
	}

}
