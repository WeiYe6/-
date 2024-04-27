package 动态规划;

public class pro71 {

	public static void main(String[] args) {
		// 买卖股票IV
//		题目:
//			给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
//			设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
//			注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
//		示例 2：
//		输入：k = 2, prices = [3,2,6,5,0,3]
//		输出：7
//		解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//		 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
		int[] prices = { 3,2,6,5,0,3 };
		int k = 2;
		int maxProfit = maxProfit5(k, prices);
		System.out.println(maxProfit);

	}

	// 三维DP数组
	public static int maxProfit(int k, int[] prices) {
		// 动规五部曲
		// 1.dp数组含义:
		// dp[i][k][0]: 第i天第k次持有股票的最大利润
		// dp[i][k][1]: 第i天第k次不持有股票的最大利润
		int[][][] dp = new int[prices.length][k + 1][2];// k从1开始，便于理解
		// 2.递推公式
		// 之前(i-1)就持有了股票，或者当天买入的股票，但是是第K次持有股票，所以肯定是由第i-1天k次不持有股票，在当天又买入的。
		// 第1次持有 和 第一次不持有 ----- 第一次持有 = 第一次不持有 + prices[0]，
		// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + (-prices[i]));
		// 之前(i-1)就不持有股票，或者当天卖出的股票，但是是第k次不持有股票，所以肯定是由第i-1天第k-1次持有股票，在当天又卖出的。
		// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] + prices[i]); 单单买入不算完成一次交易
		// 3.初始化
		for (int j = 0; j <= k; j++) {
			dp[0][j][0] = -prices[0];// 第1天第一次持有股票
			dp[0][j][1] = 0; // 第1天第一次不持有股票 (当天买当天卖) 利润为0
		}
		for (int i = 1; i < prices.length; i++) {
			dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + (-prices[i])); // 第i天第1次持有股票,
																						// 之前就持有的，或者当天持有(第1天不持有)
			dp[i][0][1] = 0;// 第i天第1次不持有股票，因为是第一次不持有股票就是还没进行过买卖
		}
		// 4.遍历顺序： 依靠前面的状态，正序遍历
		for (int i = 1; i < prices.length; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + (-prices[i]));
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] + prices[i]);// 单单买入不算完成一次交易,所以为j-1
			}
		}
		// 返回最后一天不持有股票的最大利润，就是我们的最大利润了
		return dp[prices.length - 1][k][1];
	}

	// 三维DP数组，代码优化
	public int maxProfit2(int k, int[] prices) {
		if (prices.length == 0)
			return 0;

		// [天数][交易次数][是否持有股票]
		int len = prices.length;
		int[][][] dp = new int[len][k + 1][2];

		// dp数组初始化
		// 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
		for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= k; j++) {
				// dp方程, 0表示不持有/卖出, 1表示持有/买入
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
			}
		}
		return dp[len - 1][k][0];
	}

	// 二维DP数组
	public int maxProfit3(int k, int[] prices) {
		if (prices.length == 0)
			return 0;

		// [天数][股票状态]
		// 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
		int len = prices.length;
		int[][] dp = new int[len][k * 2 + 1];

		// dp数组的初始化, 与版本一同理
		for (int i = 1; i < k * 2; i += 2) {
			dp[0][i] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < k * 2 - 1; j += 2) {
				dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
				dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
			}
		}
		return dp[len - 1][k * 2];
	}

	// 三维DP数组，代码优化
	public static int maxProfit4(int k, int[] prices) {
		int len = prices.length;
		if (len < 2)
			return 0; // 没有股票或者只有一支股票时，不买卖

		// [天数][交易次数][是否持有股票] 0-持有、1-不持有
		int[][][] dp = new int[len][k + 1][2];
		// 初始化： 这里要理解交易次数：完成一次买卖股票的完整操作
		for (int j = 0; j <= k; j++) {
			dp[0][j][0] = -prices[0]; // 第一天第j次买入时
		}
		// 遍历
		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= k; j++) {
				// 0 持有股票: - 第i天,第j次交易时持有(买入，没有完成一次完整的交易)股票的最大收益
				// dp[i-1][j-1][1]： 第i-1天 第j-1次卖出的状态 + 本次买入（第4次不持有股票，我第五次买入）
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
				// 1-不持有股票： 卖出（一次完整的交易）（第5次持有股票，我卖出去就成为第五次不持有股票了）
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
			}
		}
		return dp[len - 1][k][1];
	}

	// 二维DP数组，代码优化
	public static int maxProfit5(int k, int[] prices) {
		int len = prices.length;
		// 1.dp数组含义:
		// dp[i][0]： 没有操作
		// dp[i][1]： 第一次持有股票
		// dp[i][2]： 第一次不持有股票
		// dp[i][3]： 第二次持有股票
		// dp[i][4]： 第二次不持有股票 -----等等 我们发现0除以 奇数表示买入股票 ，偶数表示卖出股票
		// 我们要求的就是 dp[len - 1][2*k]最后一次卖出股票的金钱
		int[][] dp = new int[len][2 * k + 1];
		// 2.递推公式
		// dp[i][0] = dp[i-1][0] = 0; 没有进行过买卖操作，可以直接等于0
		// dp[i][1]: 第i天第一次持有股票 = (之前就持有的、当天持有)
		// dp[i][1] = Math.max(dp[i-1][1], -prices[i])
		// dp[i][2]: 第i天第一次不持有股票 = (之前就不持有，当天不持有)
		// dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[2]) 可以类推出3、4.....到k次
		// 3.初始化: 我们发现，奇数就是持有股票，偶数就是不持有股票
		for (int j = 1; j <= 2 * k - 1; j += 2) {
			dp[0][j] = -prices[0]; // 奇数时
		}
		// 遍历顺序: 正序
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= 2 * k -2; j+=2) {
				dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] - prices[i]);//持有股票
				dp[i][j+2] = Math.max(dp[i-1][j+2], dp[i-1][j+1] + prices[i]);//不持有股票
			}
		}
		return dp[len - 1][2*k];

	}

}
