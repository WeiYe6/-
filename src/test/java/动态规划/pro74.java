package 动态规划;

public class pro74 {

	public static void main(String[] args) {
		// 最长递增子序列
		// 题目:
//		给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//		子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
//		例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
//		子序列。
//		示例 1：
//		输入：nums = [10,9,2,5,3,7,101,18]
//		输出：4
//		解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//		示例 2：
//		输入：nums = [0,1,0,3,2,3]
//		输出：4
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int lengthOfLIS = lengthOfLIS2(nums);
		System.out.println(lengthOfLIS);

	}

	// 动态规划 - 解决
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// 动规五部曲
		// 1.dp数组含义
		// dp[i]: 以nums[i]结尾的最大递增子序列长度为dp[i]
		int[] dp = new int[nums.length];
		// 2.递推公式
		// 当 j < i时，如果nums[j] < nums[i],则 dp[i] = dp[j] + 1
		// 因为我们取的是最大值即 dp[i] = Math.max(dp[i], dp[j] + 1)
		// 3.初始化
		// dp[i] = 1; 以索引为i就是第i个数结尾的最大递增子序列长度为 1, 比如单独只有自己一个嘛
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		// 4.遍历顺序, 由递推公式知，我们需要前面的状态值
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 因为我们要的是以nums[i]结尾的最长递增子序列
		// 不一定是dp[nums.length - 1],就是不一定是以最后一个元素结尾的最长递增子序列就是最长的，
		// 有可能，之前就出现了最长的了,所以我们遍历寻找最长的
		int res = 1;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(dp[i], res);
		}

		return res;
	}

	// 动态规划 - 解决
	public static int lengthOfLIS2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// 1.dp数组含义
		// dp[i]-以nums[i]结尾的最长递增子序列长度为dp[i]
		int[] dp = new int[nums.length];
		//2.递推公式
		//当 j < i时，if nums[j] < nums[i]  dp[i] = Math.max(dp[j] + 1, dp[i]); //取最大的那个
		//3.初始化 dp[0]：以nums[0]结尾的最长递增子序列长度为1, 只有一个嘛
		//dp[1]: 以nums[1]结尾的，最少也有一个嘛，就是自己啊。。。。。以此类推，dp[i] = 1
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		//4.遍历顺序, 需要前面的状态值，由左往右遍历
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {//保证了j < i
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
				if (dp[i] > res) {
					res = dp[i];
				}
			}
		}
		return res;
	}

}
