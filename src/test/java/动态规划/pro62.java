package 动态规划;

public class pro62 {

	public static void main(String[] args) {
		// 322. 零钱兑换 - 完全背包问题
//		给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//		计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//		你可以认为每种硬币的数量是无限的。
//		示例 1：
//		输入：coins = [1, 2, 5], amount = 11
//		输出：3 
//		解释：11 = 5 + 5 + 1
//		示例 2：
//		输入：coins = [2], amount = 3
//		输出：-1
//		示例 3：
//		输入：coins = [1], amount = 0
//		输出：0
		int[] coins = { 1,2,5 };
		int amount = 3;
		int coinChange = coinChange(coins, amount);
		System.out.println(coinChange);

	}

	// 动态规划 解决
	public static int coinChange(int[] coins, int amount) {
		// 1.dp数组含义: dp[j] - 容量为j的背包 所需最少能填满背包的物品个数为dp[j]
		int[] dp = new int[amount + 1];
		// 2.递推公式: 求个数(最大值/最小值)公式： dp[j] =Math.min(dp[j], dp[j-coins[i]] + 1)
		// 3.初始化: dp[0]- 容量为0的背包所能装的物品个数为0, 非0下标如何初始化，此题我们要求的是最小值，所以不能初始化
		dp[0] = 0;
		int max = Integer.MAX_VALUE;
		for (int i = 1; i < dp.length; i++) {// 非0下标初始化为Integer的最大值
			dp[i] = max;
		}
		// 4.遍历顺序 - 完全背包 - 求个数（先遍历物品，再遍历背包（正序））
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {// j == coins[i] 不能从1开始，否则 j-coins[i]就会索引越界
				// 只有该位不是dp[j-coins[i]] == max时，才有选择的必要
				// 这里这样理解
				// dp[j-coins[i]]： 装满容量为 j-coins[i] 的背包所需要的最少物品个数，但是如果该背包还是初始值的话
				// 就表示还没装过任何物品，所以不满足我们的定义，不选择它
				if (dp[j - coins[i]] != max) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();

		if (dp[amount] == max) {
			return -1;
		}
		return dp[amount];
	}
	
	//优化 - 代码
	public int coinChange2(int[] coins, int amount) {
        //动规五部曲
        //1.dp数组含义: dp[j] -装满容量为j的背包所需要的最少物品个数为dp[j]
        int[] dp = new int[amount + 1];
        //2.递推公式：求的是物品个数-常规 dp[j] = Math.max/min(dp[j], dp[j-nums[i]]+1)
        //这题我们求的是最少的物品个数所以我们采用的递推公式为:
        //dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1)
        //3.初始化 0下标 和 非0下标如何初始化
        //本题示例3告诉我们 dp[0] = 0, 由于我们要求的是最小值所以非0下标初始为Integer的最大值
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for(int i = 1; i < dp.length; i++) dp[i] = max;
        //4.遍历顺序 该题硬币数量无限个 为完全背包问题，且求的是个数，和排列组合不相关，可以先物品后背包，也可以反过来
        //我采用: 先遍历物品，后（正序）遍历背包
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //这里我们只选择满足我们dp数组定义的
                //即 dp[j-coins[i] != max], 如果等于初始值则表示还没装过任何物品不符合我们的定义
                if(dp[j-coins[i]] != max){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        //如果等于初始值表示没有任何一种组合能满足题意的返回-1
        return dp[amount] == max ? -1: dp[amount];
    }

}
