package 动态规划;

public class pro72 {

	public static void main(String[] args) {
//		// 买卖股票含冷冻期
//		给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
//		设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//		卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//		注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//		示例 1:
//
//			输入: prices = [1,2,3,0,2]
//			输出: 3 
//			解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
		int[] prices = {4,2,7,1,11};
		//输出: 10
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}
	
	
	
	
	
    public static int maxProfit(int[] prices) {
    	int len = prices.length;
    	if (len < 2) {
			return 0;
		}
    	int[][] dp = new int[len][4];
    	//动规五部曲
    	//1.dp数组含义: 
    	//dp[i][0]：持有股票
    	//dp[i][1]：持续着未持有股票
    	//dp[i][2]：卖出股票
    	//dp[i][3]：冷冻期
    	
    	
    	//2.递推公式
    	//dp[i][0]: 持有股票 = max(等于之前就持有股票的状态，冷冻期之后买入股票， 持续着未持有股票时买入股票)
    	//dp[i][0] = Math.max(dp[i-1][0], max(dp[i-1][3] - prices[i], dp[i-1][1] - prices[i])
    	
    	//dp[i][1]: 持续着未持有股票 = max（之前就未持有股票的状态，卖出股票之后的状态）
    	//dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2])
    	
    	//dp[i][2]: 卖出股票 = 持有股票，再卖出
    	//dp[i][2] = dp[i-1][0] + prices[i]
    	
    	//dp[i][3]: 冷冻期：前一天为卖出股票
    	//dp[i][3] = dp[i-1][2]
    	
    	//3.初始化
    	//dp[0][0] = -prices[0], 第一天买入股票
    	//dp[0][1] = 0 由递推公式推出
    	//dp[0][2]  = 0 当天买卖
    	//dp[0][3] = 0 由公式推出
    	dp[0][0] = -prices[0];
    	
    	//4.遍历顺序，由递推公式知道需要前面的状态，正序遍历
    	for (int i = 1; i < len; i++) {
    		dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3] - prices[i], dp[i-1][1] - prices[i]));
    		dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]);
    		dp[i][2] = dp[i-1][0] + prices[i];
    		dp[i][3] = dp[i-1][2];
		}
    	//这里取最大利润，会在那里产生呢? 肯定是最后一天时 未持有股票 最大了
    	//未持有股票有三种状态，取最大值即可
		return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len-1][3]));
    }

}
