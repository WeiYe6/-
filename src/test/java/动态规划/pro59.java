package 动态规划;

public class pro59 {

	public static void main(String[] args) {
		// 零钱兑换II - 动态规划（完全背包问题）
		// 题目:
		// 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
		// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
		// 假设每一种面额的硬币有无限个。
		// 题目数据保证结果符合 32 位带符号整数。
		// 示例1：
		// 输入：amount = 5, coins = [1, 2, 5]
		// 输出：4
		// 解释：有四种方式可以凑成总金额：
		// 5=5
		// 5=2+2+1
		// 5=2+1+1+1
		// 5=1+1+1+1+1

		int[] coins = { 1, 2, 5 };
		int amount = 5;
		int change = change(amount, coins);
		System.out.println(change);

	}

	public static int change(int amount, int[] coins) {
		// 动规五部曲
		// 1.dp数组含义: 装满容量为j的背包，所具有的组合数为dp[j]。
		int[] dp = new int[amount + 1];
		// 2.递推公式: 常规: dp[j] = Math.max(dp[j], dp[j-coins[i]] + coins[i])
		// 这题由于要求的是组合数: 递推公式为: dp[j] += dp[j-coins[i]]
		// 3.初始化
		// dp[0]： 容量为0的背包，所具有的组合数为1，就是什么都不选
		dp[0] = 1;
		// 4.遍历顺序：由递推公式可知，需要前面的状态值
		//这题我们还需要知道 2+2+1 = 1+2+2： 是同一个组合数，所以这题我们要求的就是组合数
		//i； 完全背包中: 先遍历物品，再遍历背包就是求的组合数
		//ii：先遍历背包，再遍历物品就是求的排列数了。
		// 这题我们 - 先遍历物品，再正序遍历背包 
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[amount];
	}

}
