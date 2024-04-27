package 动态规划;

import java.util.Scanner;

public class pro43 {

	public static void main(String[] args) {
		//数组分割 -  动态规划 
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int mod = 1000000007;
		int[] arr = new int[1010];
		long[][] dp = new long[1010][2];
		//dp[i][0]: 从前i个数中选择和为偶数的方案数
		//dp[i][1]: 从前i个数中选择和为奇数的方案数
		for(int i = 1; i <= t; i++) {
			int n = scanner.nextInt();
			long sum = 0;
			for (int j = 1; j <= n; j++) {
				arr[j] = scanner.nextInt();
				sum += arr[j];
			}
			if (sum % 2 ==1) {
				System.out.println(0);
				continue;
			}
			//dp[][]: 可初始化也可不初始化
			for(int j = 1; j <= n; j++) {
				dp[j][0] = dp[j][1] = 0;
			}
			dp[0][0] = 1; //空集时，为一种方案；
			//状态转移
			//当选择第k个数的奇数偶数方案数时，第k-1个方案数已经确定了
			for(int k = 1; k <= n; k++) {
				if (arr[k] % 2 ==1) {//当前数为奇数时
					dp[k][0] = (dp[k-1][0] + dp[k-1][1]) % mod; //保存状态 k-1 个偶的方案数 ： （奇 + 奇 = 偶）选择奇数和为偶数的方案数 
					dp[k][1] = (dp[k-1][1] + dp[k-1][0]) % mod;//保存状态 k-1 个奇的方案数 ： （偶+ 奇 = 奇） 选择偶数和为奇数的方案数
				}else {//当前数为偶数时
					dp[k][0] = dp[k-1][0] + dp[k-1][0];
					dp[k][1] = dp[k-1][1] + dp[k-1][1];
				}
			}
			System.out.println(dp[n][0]);
		}
		
		scanner.close();
	}

}
