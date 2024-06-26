package 动态规划;

public class pro45 {

	public static void main(String[] args) {
		// 动态规划 - 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
		int nums[] = { 3, 2, 5, 4, 8, 9, 6 };
		System.out.println(getLengthOfList(nums));
	}

	// 动态规划 - 解决 严格最长子序列问题
	// 动态规划核心：拆分子问题，记住过往，减少重复计算
	// 解题思路:穷举分析 - 确定边界 - 找规律,确定最优子结构 - 状态转移方程
	// 假设nums[] = {3,2,5,4,8,9,6}
	// 步骤1：穷举分析：
	// 当加入第1个元素时： 最长递增子序列是 【3】：长度1
	// 当加入第2个元素时： 最长递增子序列是 【3】|【2】：长度1
	// 当加入第3个元素时： 最长递增子序列是 【3、5】|【2、5】：长度2
	// 当加入第4个元素时： 最长递增子序列是 【3、5】|【2、5】|【3、4】|【2、4】：长度2
	// 当加入第5个元素时： 最长递增子序列是 【3、5、8】|【2、5、8】|【3、4、8】|【2、4、8】：长度3
	// 当加入第6个元素时： 最长递增子序列是 【3、5、8、9】|【2、5、8、9】|【3、4、8、9】|【2、4、8、9】：长度4
	// 当加入第7个元素时： 最长递增子序列是 【3、5、8、9】|【2、5、8、9】|【3、4、8、9】|【2、4、8、9】|【3、5、6】
	// |【2、5、6】|【3、4、6】|【2、4、6】：长度4
	// 发现规律: 当加入第i个元素时，以nums[i]结尾的数组
	// 如果存在j属于区间[0, i-1]，并且nums[i] > nums[j]的话，则有 dp[i] = max(dp(j)) + 1  ==> j 元素下的最长子序列 + 1
	// 如果 nums[i] < nums[j]，则最长子序列还是之前那个，不用变化。
	// 确定边界: 当数组有1个元素时，dp(1) = 1 、两个元素时，未知，那么边界就是 i = 1 => dp[1] = 1
	// 最优子结构: max(dp(j)) + 1
	// 状态转移方程: i = 1 ===> dp(1) = 1
	// 0<=j<i且nums[i] > nums[j] ===> max(dp(j)) + 1
	public static int getLengthOfList(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}

		int[] dp = new int[length];// 存储第i个元素对应的 最长严格递增子序列的长度。
		// 边界 - 初始化
		dp[0] = 1; // 只有一个元素
		int res = 1; // 存储长度最大值的
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1; // 先初始化 当前长度为1
			for (int j = 0; j < i; j++) {
				// 从 0 - (i-1) 中找 比nums[i]小的数  nums[j] ==> dp[i] = dp[j] + 1
				if (nums[i] > nums[j]) {
					// 因为会有多种组合，我们取最大值的那个
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				// 注意这里，我为什么没有写else呢?,因为如果nums[i] <= nums[j]那么最长子序列是没有变化的，
				// 我在上面写了dp[i] = 1了，就是不满足的时候就默认为1咯，其实不写这个, 默认为0时也不影响我们的结果的。
			}
			// 求出dp[i]后，dp元素值最大的那个就是nums的最长递增子序列了
			res = Math.max(res, dp[i]);
		}

		return res;
	}

}
