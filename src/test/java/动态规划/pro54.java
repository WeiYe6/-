package 动态规划;


public class pro54 {

	public static void main(String[] args) {
		// 01背包 - 动态规划
		int V = 10;
		int N = 4;
		int[] weight = { 2, 3, 4, 5 };
		int[] value = { 3, 4, 5, 6 };
		String fn = fn(N, V, weight, value);
		System.out.println("被放入背包的物品编号为: "+fn);
	}

	/**
	 * 01背包问题 - 动态规划
	 * 
	 * @param N      物品种类
	 * @param V      背包容量
	 * @param weight 物品重量
	 * @param value  物品价值
	 * @return
	 */
	public static String fn(int N, int V, int[] weight, int[] value) {
		// 动规五部曲
		// dp数组的含义: dp[i][j] 表示 前i个物品能放入容量为j的背包中的价值总和最大值
		int[][] dp = new int[N + 1][V + 1];// 我们从1开始，便于理解，不然还需要针对第一个物品进行初始化
		// 递推公式 因为value[] 和 weight[]数组的索引是从0开始的，所以我们需要减1，才是当前i对应的重量和价值
		// 放不下 和 放得下但是要考虑放下后价值是否变大，否则不需要放。
		// dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1])

		// 初始化 当背包的容量为0时，那么最大价值就是0了，还要考虑放置第一个物品时，在weight[0] >= V,时要初始化
		// dp[0][j] = value[0]
		// 但是我们不需要初始化了，因为我们默认第0个(索引0)的物品价值为0，所以我们才初始化dp[][]的长度+1的，从dp[1][1]算
		// 遍历顺序，正序遍历，因为我们需要前面的状态
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= V; j++) {
				if (weight[i - 1] > j) {// 放不下
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
				}
			}
		}
		int maxValue = dp[N][V];// 最大价值
		System.out.println("最大价值和为: " + maxValue);

		// 如果需要找出放入背包中的物品编号
		// 采用回溯法，dp[i][j] > dp[i-1][j]时，则说明物品i被放入了背包
		int j = V;
		String numString = "";
		for (int i = N; i > 0; i--) {
			if (dp[i][j] > dp[i - 1][j]) {
				numString = i + " " + numString;
				j = j - weight[i-1];
			}
			if (j == 0) {
				break;
			}
		}
		return numString;

	}
	

	/**
	 * 01背包问题 - 动态规划 - 优化(状压)
	 * 
	 * @param N      物品种类
	 * @param V      背包容量
	 * @param weight 物品重量
	 * @param value  物品价值
	 * @return
	 */
	public static int fn2(int N, int V, int[] weight, int[] value) {
		// 动规五部曲
		//dp[j]：背包容量为j时，装入物品价值总和的最大值
		int[] dp = new int[V+1];
		//递推公式
		//dp[j] = Math.max(dp[j], dp[j-weight[i-1]] + value[i-1]);
		//初始化，初始化为0
		//遍历顺序: 先遍历物品，再逆序遍历容量 
		// 如果反过来，先遍历容量，再遍历物品，会出现一个背包只放一个物品的问题
		//如果正序遍历容量，会出现物品被重复放入的问题
		for(int i = 1; i < N+1; i++) {
			for(int j = V; j >= weight[i-1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i-1]] + value[i-1]);
			}
		}
		return dp[V];
		
	}
}
