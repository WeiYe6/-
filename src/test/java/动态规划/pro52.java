package 动态规划;

public class pro52 {

	public static void main(String[] args) {
		// 整数拆分 - 动态规划
//		给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//		示例 2:
//			输入: 10
//			输出: 36
//			解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//			说明: 你可以假设 n 不小于 2 且不大于 58。
		int fn = fn(10);
		System.out.println(fn);

	}

	public static int fn(int n) {
		// 1.dp[i]含义: 对i拆分之后最大的乘积为dp[i]
		int[] dp = new int[n + 1]; // 我们要求的是dp[n] 所以长度为n+1
		// 递推公式,要么拆分成2个、3个、4...取最大值
		// dp[i] = Math.max(dp[i], Math.max((i-j)*j, dp[i-j]*j))
		// 为什么需要比较 dp[i]？因为我们是固定i，不断拆分j的，所以需要取最大值那个罢了
		// (i-j)*j：拆分成两个数 、 dp[i-j]*j)在两个数的基础上继续拆分
		// 初始化 dp[0] dp[1],对于我们的定义来说有意义吗？无意义，所以我们只需要初始化dp[2] = 1*1 = 1即可
		dp[2] = 1;
		// 遍历顺序，因为我们是不断把n拆分的，是需要之前的状态值的
		// 比如: 我拆分10的时候，3+3+4 是需要之前保存过dp[4]的状态值的
		for (int i = 3; i <= n; i++) {// 从3开始
			// 这里写 j < i也是可以通过的，但是我们优化成 j <= i-j, 就不会用到dp[1]、dp[0]那些了
			for (int j = 1; j <= i - j; j++) {
				dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
			}
		}
		return dp[n];

	}

}
