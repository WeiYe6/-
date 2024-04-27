package 动态规划;

public class pro79 {

	public static void main(String[] args) {
		// 最大子序和
		// 题目:
//		给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//		子数组是数组中的一个连续部分。
//		示例 1：
//		输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//		输出：6
//		解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//		示例 2：
//		输入：nums = [1]
//		输出：1
//		示例 3：
//		输入：nums = [5,4,-1,7,8]
//		输出：23
		int[] nums = { 1, -2, 3 };
		int maxSubArray = maxSubArray2(nums);
		System.out.println(maxSubArray);

	}

	// 动态规划
	public static int maxSubArray(int[] nums) {
		// 动规五步曲
		// 1.dp数组含义
		// dp[i]- 索引为从0-i的nums中的连续子数组最大和为dp[i]
		int[] dp = new int[nums.length];
		// 2.递推公式
		// dp[i]：从索引0-i的nums中的连续子数组最大和为dp[i]
		// dp[i]有哪些情况可以推出来呢？由我们的dp定义数组得知可以由2种情况推出来
		// 第一种: dp[i] = dp[i-1] + nums[i]//这时我们需要把前面的状态也算进来
		// 第二种: dp[i] = nums[i]; //我们抛弃前面的状态，重新计算
		// 我们需要的是取最大值: dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);这样就可以知道当前值需不需要重新计算了
		// 3.初始化 dp[0] ，只有一个元素时，直接赋值给nums[0]即可
		dp[0] = nums[0];
		// 4.遍历顺序，由递推公式知，需要前面的状态值从左往右，正序遍历
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
		}
		// 找出dp[i]中的最大值，就是我们需要的最大和了
		int max = nums[0];
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	// 暴力解决 - 超时了
	public static int maxSubArray2(int[] nums) {
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				res = Math.max(res, sum);
			}
		}
		return res;
	}

}
