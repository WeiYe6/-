package 动态规划;

public class pro66 {

	public static void main(String[] args) {
		// 动态规划- 打家劫舍II
//		你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
//		这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
//		同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//		给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//		示例 1：
//		输入：nums = [2,3,2]
//		输出：3
//		解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//		示例 2：
//		输入：nums = [1,2,3,1]
//		输出：4
//		解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//		     偷窃到的最高金额 = 1 + 3 = 4 。
//		示例 3：
//		输入：nums = [1,2,3]
//		输出：3
		int[] nums = { 1, 2, 3, 1, 1 };
		int rob = rob(nums);
		System.out.println(rob);

	}

	public static int rob(int[] nums) {
		// 1.dp数组含义: dp[j] -考虑下标(0-j)房间，所能盗窃最大的金额数为dp[j]
		// dp1 - 考虑1----到n-1个房间：取头
		// dp2 - 考虑2----到n个房间： 取尾部
		int[] dp1 = new int[nums.length];
		int[] dp2 = new int[nums.length];
		// 2.递推公式 第下标 j房间取还是不取: 不取 dp[j] = dp[j-1]
		// 展开: 圆形，第一个dp1取头
		// 第二个dp2 取尾部， 然后获取max(dp1, dp2)
		// 3.初始化  dp[0] 和 dp[1] 
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length > 1) {
			dp1[0] = nums[0]; // 取头,不取尾
			dp1[1] = Math.max(nums[0], nums[1]);
		}

		if (nums.length > 1) {
			dp2[0] = 0; // 不取头，取尾
			dp2[1] = nums[1];
		}
		// 4.遍历顺序，依靠前面的状态值 ，正序遍历
		for (int j = 2; j < nums.length; j++) {
			// if (j < nums.length - 1) {// 不取尾
			dp1[j] = Math.max(dp1[j - 1], dp1[j - 2] + nums[j]);
			// }
			dp2[j] = Math.max(dp2[j - 1], dp2[j - 2] + nums[j]);
		}
		return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
	}

}
