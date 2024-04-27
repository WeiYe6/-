package 动态规划;

public class pro76 {

	public static void main(String[] args) {
		// 最长重复子数组
		// 题目:
//		给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
//		示例 1：
//		输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//		输出：3
//		解释：长度最长的公共子数组是 [3,2,1] 。
//		示例 2：
//		输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//		输出：5
		int[] nums1 = { 1, 2, 3, 2, 1 };
		int[] nums2 = { 3, 2, 1, 4, 7 };
		int findLength = findLength2(nums1, nums2);
		System.out.println(findLength);
	}

	// 暴力解法
	public static int findLength(int[] nums1, int[] nums2) {
		int res = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int count = 0;
				while (i + count < nums1.length && j + count < nums2.length && nums1[i + count] == nums2[j + count]) {
					count++;
				}
				res = Math.max(count, res);
			}
		}
		return res;
	}

	// 递归解法
	public static int findLength2(int[] nums1, int[] nums2) {
		// 动规五步曲
		// 1.dp数组含义: dp[i][j]-以下标为i-1结尾的nums1 和 以下标为j-1结尾的nums2的最长公共子数组长度为dp[i][j]
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		// 2.递推公式
		// 这里dp[i][j],存储的是上一个元素的状态值
		// if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
		// 3.初始化 dp[i][0] 和 dp[0][j] 对于我们的递推公式来说都是无意义的
		// 由 dp[1][1] = dp[0][0] + 1 为什么不影响结果我们应该初始化为0
		// 4.遍历顺序，由递推公式知 ，需要前面的状态值
		int res = 0;
		for (int i = 1; i <= nums1.length; i++) { // 这里的相等，结合我们的dp数组定义就理解了
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				if (dp[i][j] > res) {
					res = dp[i][j];
				}
			}
		}
		// 我们需要找的是最长的，那么就找dp数组中最长的即可
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp.length; j++) {
//				res = Math.max(res, dp[i][j]);
//			}
//		}
		return res;
	}
}
