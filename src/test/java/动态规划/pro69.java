package 动态规划;

public class pro69 {

	public static void main(String[] args) {
		// 买卖股票II
		//题目:
//		给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//		在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//		返回 你能获得的 最大 利润 。
//		示例 1：
//		输入：prices = [7,1,5,3,6,4]
//		输出：7
//		解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//		     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//		     总利润为 4 + 3 = 7 。
//		示例 2：
//		输入：prices = [1,2,3,4,5]
//		输出：4
//		解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//		     总利润为 4 。
//		示例 3：
//		输入：prices = [7,6,4,3,1]
//		输出：0
//		解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 
		
	}
	
    //动态规划解决
    public static int maxProfit2(int[] prices) {
    	//1.dp数组含义: dp[i][0]表示第i天持有股票的最大收益           - 状态0
    	//             dp[i][1]表示第i天不持有股票的最大收益       - 状态1
    	int[][] dp = new int[prices.length][2];
    	//2.递推公式： 现在可以进行多次买卖了
    	//dp[i][0]: 第i天持有股票的最大收益，可以是i-1天就持有了，为之前的状态值。
    	// 也可以是第i天时买入的，那么买入前我的收益为多少呢？ 因为该题可以进行多次买卖，
    	//那么 买入股票前我的收益可以是0（无收益，还没进行过买卖）也可以是i-1天时不持有股票的最大收益（之前有进行过买卖，有收益）
    	//dp[i][0] = max(dp[i-1][0], dp[i-1][1] +(0 - prices[i]))
    	//dp[i][1]: 第i天不持有股票的最大收益，可以是第i-1天就不持有的，也可以是第i天时不持有的
    	//dp[i][1] = max(dp[i-1][1], dp[i][0] + prices[i])
    	//3.初始化 dp[0][0]：表示第0天持有的，dp[0][1]：表示第0天不持有
    	dp[0][0] = -prices[0];
    	dp[0][1] = 0;
    	//4.遍历顺序，需要依靠前面的状态值，正序遍历
    	for(int i = 1; i < prices.length; i++) {
    		dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + (-prices[i]));
    		dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + prices[i]);
    	}
    	//返回最后一天，不持有的最大收益。就是卖了股票之后的最大收益
    	return dp[prices.length - 1][1];
    }

}
