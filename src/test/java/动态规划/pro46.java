package 动态规划;

public class pro46 {

	public static void main(String[] args) {
		// 动态规划 - 01背包问题
		int V = 10;
		int N = 4;
		int[] weight = {2,3,4,5};
		int[] value = {3,4,5,6};
		
		String zeroOnePack = ZeroOnePack(V, N, weight, value);
		System.out.println("被放入背包的物品编号为: "+zeroOnePack);
		
		int zeroOnePack2 = ZeroOnePack2(V, N, weight, value);
		System.out.println("最大价值和为: "+zeroOnePack2);
	}

	/**
	 * 0-1背包问题 - 动态规划
	 * 
	 * @param V      背包容量
	 * @param N      物品种类
	 * @param weight 物品重量
	 * @param value  物品价值
	 * @return
	 */
	public static String ZeroOnePack(int V, int N, int[] weight, int[] value) {

		//问题一: 求在N物品种类下 V容量背包所能装的最大价值总和为？
		// 初始化动态规划数组 dp[i][0]、dp[0][j] = 0, 便于理解，我们从1开始计算
		// 解析: dp[i][j]表示； 前i个物品能装入容量为j的背包中物品价值总和的最大值
		int[][] dp = new int[N + 1][V + 1];
		// 状态转移方程
		// 如果weight[i] > j,则表示当前物品放不进该背包中 - 最大价值不变 : dp[i][j] = dp[i-1][j]
		// 反之 当前物品能放入背包中，但是放不放入该物品呢？我们需要比较最大价值，
		// 如果放入之后最大价值还小于等于前一个背包的最大价值，则没必要放入。
		// Math.max(dp[i-1[j], dp[i-1][j-weight[i]+value[i]]])
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < V + 1; j++) {
				// weight[] 和 value[] 数组的下标都是从0开始的所有我们需要减一
				if (weight[i - 1] > j) {// 放不下
					dp[i][j] = dp[i - 1][j];
				} else {                //在背包容量为 j 下获取价值最大的
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
				}
			}
		}
		//在N物品下 V容量背包的最大价值总和为
		int maxValue = dp[N][V];
		System.out.println("最大价值和为: "+maxValue);
		
		//求装入背包中物品的编号？
		//采用回溯法: 
		//分析: 如果dp[i][j] > dp[i-1][j],则说明第i个物品被放入了背包中, 反之第i个物品没有被放入背包中
		//然后依次比较 dp[i-1][j-weight[i]]和前面的。即可知道那些编号的物品被放入了背包中
		int j = V;
		String numStr = "";//记录放入背包物品编号的
		//逆序遍历
		for(int i = N; i>0; i--) {
			if(dp[i][j] > dp[i-1][j]) {//第i个物品被放入
				numStr = i + " " + numStr;
				//继续判断剩下的
				j = (j - weight[i-1]); //这里为什么是weight[i-1],还是我们这个数组是从0索引开始的。
			}
			//如果容量置为0，则该次回溯结束
			if (j == 0) {
				break;
			}
		}
		return numStr;

	}
	
	/**
	 * 0-1背包优化解法    --- 状压 (把二维数组压缩成一维数组)
	 * @param V      背包容量
	 * @param N      物品种类
	 * @param weight 物品重量
	 * @param value  物品价值
	 * @return
	 */
	public static int ZeroOnePack2(int V, int N, int[] weight, int[] value) {
		//用一维数组来记录，dp[i]: 表示容量为i的背包所能装入物品的最大价值
		int[] dp = new int[V+1];
		//先遍历物品，再逆序遍历背包
		//0-1背包问题中，每个物品只能选择装入一次，
		//如果先遍历背包，则可能会出现当前背包容量下的状态已经考虑了当前物品，而在后续更新状态时再次考虑该物品
		for(int i = 1; i<N+1; i++) {
			//逆序遍历背包
			for (int j = V; j >= weight[i-1]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i-1]] + value[i-1]);
			}
		}
		return dp[V];
	}
	
	
	//状压解法
	public static int ZeroOnePack3(int V, int N, int[] weight, int[] value) {
		int[] dp = new int[V+1]; //dp[i]： 容量为i的背包所能装的物品最大价值
		for(int i = 1; i < N+1; i++) {
			for (int j = V; j >= weight[i-1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i-1]] + value[i-1]);
			}
		}
		return dp[V];
	}

}
