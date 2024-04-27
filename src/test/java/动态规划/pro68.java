package 动态规划;

public class pro68 {

	public static void main(String[] args) {
		// 买卖股票
		//题目: 买卖股票的最佳时机
//		给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//		你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//		返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//		示例 1：
//		输入：[7,1,5,3,6,4]
//		输出：5
//		解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//		     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//		示例 2：
//		输入：prices = [7,6,4,3,1]
//		输出：0
//		解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
		int[] prices = {7,1,5,3,6,4};
		int maxProfit = maxProfit2(prices);
		System.out.println(maxProfit);

	}
	//贪心解决
    public static int maxProfit(int[] prices) {
    	//贪心：局部最优解，
    	//找到一个最小的购入点，注意是先买 -再买的，那不是可以用贪心算法的局部最优来解决
    	//先不断找到最小的购入点，而后不断尝试卖该股票，找到最大值
    	int low = Integer.MAX_VALUE;
    	int res = 0;
    	for (int i = 0; i < prices.length; i++) {
			low = Math.min(prices[i], low);
			res = Math.max(prices[i] - low, res);
		}
		return res;
    }
    
    //动态规划解决
    public static int maxProfit2(int[] prices) {
    	//1.dp数组含义: dp[i][0]表示第i天持有股票的最大收益           - 状态0
    	//             dp[i][1]表示第i天不持有股票的最大收益       - 状态1
    	int[][] dp = new int[prices.length][2];
    	//2.递推公式：只能买卖一次, 那么我持有股票前肯定 是没有钱的（收益为0）
    	//dp[i][0]: 第i天持有股票的最大收益，可以是i天之前就持有了，也可以是第i天时持有的，
    	//就是第i天时买入，因为只能买卖一次，所以我肯定没有过收益(收益 = 0)
    	//dp[i][0] = max(dp[i-1][0], 0 +( - prices[i]))
    	
    	//dp[i][1]: 第i天不持有股票的最大收益，可以是第i天之前就不持有的，也可以是第i天时不持有的
    	//dp[i][1] = max(dp[i-1][1], dp[i][0] + prices[i])
    	//3.初始化 dp[0][0]：表示第0天持有的，dp[0][1]：表示第0天不持有
    	dp[0][0] = -prices[0];
    	dp[0][1] = 0;
    	//4.遍历顺序，需要依靠前面的状态值，正序遍历
    	for(int i = 1; i < prices.length; i++) {
    		dp[i][0] = Math.max(dp[i-1][0], 0 + (-prices[i]));
    		dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + prices[i]);
    	}
    	//返回最后一天，不持有的最大收益。就是卖卖了股票之后的最大收益
    	return dp[prices.length - 1][1];
    }

}
