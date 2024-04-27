package 动态规划;

public class pro75 {

	public static void main(String[] args) {
		// 最长连续递增序列
		// 题目:
//		给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//		连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
//		都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 
//		就是连续递增子序列。
//		示例 1：
//		输入：nums = [1,3,5,4,7]
//		输出：3
//		解释：最长连续递增序列是 [1,3,5], 长度为3。
//		尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
//		示例 2：
//		输入：nums = [2,2,2,2,2]
//		输出：1
//		解释：最长连续递增序列是 [2], 长度为1。
		int[] nums = {1,3,5,4,7};
		int findLengthOfLCIS = findLengthOfLCIS(nums);
		System.out.println(findLengthOfLCIS);
	}

	//不连续递增子序列的跟前0-i 个状态有关
	//连续递增的子序列只跟前一个状态有关
	public static int findLengthOfLCIS(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		//动规五部曲
		//1.dp数组含义
		//dp[i]：以nums[i]结尾的最长连续递增序列为dp[i]
		int[] dp = new int[len];
		//2.递推公式
		//要求(j = i-1) j < i 时，如果nums[j] < nums[i] 则 dp[i] = dp[j] + 1
		//3.初始化，dp[i]： 如果单独以自己结尾，那么就都是1了
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
		}
		//4.遍历顺序，因为依靠前面的状态,正序
		for (int i = 1; i < len; i++) {
				if (nums[i-1] < nums[i]) {
					dp[i] = dp[i-1] + 1;
				}
		}
		//找出我们dp[i],最长那个就可以了
		int res = 1;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(dp[i], res);
		}
		return res;
	}
}
