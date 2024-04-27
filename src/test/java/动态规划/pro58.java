package 动态规划;

public class pro58 {

	public static void main(String[] args) {
		// 完全背包 - 一维数组
		int N = 3;
		int V = 4;
		int[] weight = {1,3,4};
		int[] value = {15,20,30};
		int fn = fn2(N, V, weight, value);
		System.out.println("最大价值：" + fn);
		
	}
	
	/**
	 * 完全背包问题 - 滚动数组实现:  每个物品可以放入多次
	 * @param N: 物品种类数量
	 * @param V：背包最大容量
	 * @param wight: 物品i对应的重量
	 * @param value: 物品i对应的价值
	 * @return
	 */
	public static int fn(int N, int V, int[] weight, int[] value) {
		// 1.dp数组含义:  dp[j]: 容量为j的背包，装入物品的最大价值总和是dp[j]
		int[] dp = new int[V+1];
		//2.递推公式: 常规: dp[j] = Maht.max(dp[j], dp[j-weight[i]] + value[i])
		//3.初始化: dp[0]: 容量为0的背包放入不了物品所以价值对应为0
		dp[0] = 0;
		//4.遍历顺序:  01背包是 先遍历物品后逆序遍历背包，逆序的原因就是防止物品被放入多次
		//而这题物品就是可以放入多次的，所以我们: 先遍历物品，再正序遍历背包即可 (这题: 背包和物品的遍历次序可以互换)
		for(int i = 0; i < N; i++) {
			for (int j = weight[i]; j <= V; j++) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}
		return dp[V];
	}
	
	/**
	 * 完全背包问题 - 二维数组实现
	 * @param N: 物品种类数量
	 * @param V：背包最大容量
	 * @param wight: 物品i对应的重量
	 * @param value: 物品i对应的价值
	 * @return
	 */
	public static int fn2(int N, int V, int[] weight, int[] value) {
		//1.dp数组含义: dp[i][j]： 前i个物品任意取（可重复），装入容量为j的背包中的最大价值是dp[i][j]
		int[][] dp = new int[N][V+1];
		//2.递推公式: 判断当前物品是否可放入： 不可放入: dp[i][j] = dp[i-1][j]
		// 可放入 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i]] + value[i]);
		//注意这里因为可重复，所以可考虑当前物品行（之前是只能考虑当前物品之前的 dp[i-1][j-weight[i]]+ value[i]）
		//3.初始化: //这里如果我们 从第一个（i = 1）索引下开始，即i = 0，默认0，则全初始化为0即可
		//dp[i][0] = 0： 容量为0的背包装不了任何东西
		//dp[0][j] ；第一个物品的重量 <= V时，等于=，后面的默认为0
		for (int j = V; j >= weight[0]; j--) {  
			dp[0][j] = value[0];
		}
		//4.遍历顺序: 先遍历物品，再遍历背包
		for(int i = 1; i < N; i++) {
			for(int j = 1; j <= V; j++) {
				if(weight[i-1] > j) {
					dp[i][j] = dp[i-1][j]; //放不下
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i-1]] + value[i-1]);//可重复放入该物品
				}
			}
		}
		
		return dp[N-1][V];
	}

}
