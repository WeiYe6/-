package 动态规划;

public class pro56 {

	public static void main(String[] args) {
		// 目标和 - 动态规划
//		输入：nums = [1,1,1,1,1], target = 3
//				输出：5
//				解释：一共有 5 种方法让最终目标和为 3 。
//				-1 + 1 + 1 + 1 + 1 = 3
//				+1 - 1 + 1 + 1 + 1 = 3
//				+1 + 1 - 1 + 1 + 1 = 3
//				+1 + 1 + 1 - 1 + 1 = 3
//				+1 + 1 + 1 + 1 - 1 = 3
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		int findTargetSumways = findTargetSumways3(nums, target);
		System.out.println(findTargetSumways);

	}

	// 二维数组 - 解决
	public static int findTargetSumways(int[] nums, int target) {
		// 二维数组 01背包解决 - 有多少种不同的填满背包最大容量的方法
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		// nums[i]均 >= 0，所以 sum + target >= 0 left(所有正整数的和集合) >= 0
		if (sum < Math.abs(target)) {
			return 0;
		}
		if ((sum + target) % 2 != 0) { // 这说明我们的left出现了小数，也是不可能的，我们nums[] 正整数集合是没有办法凑出小数来的
			return 0;
		}

		int left = (sum + target) / 2;
		// dp含义: dp[i][j]: 从下标为【0...i】的物品里任取，填满j这么大容积的背包，有dp【i】【j】种方法
		int[][] dp = new int[nums.length][left + 1];
		// 递推公式: nums[i] > j时，nums[i]不能取，所以为dp[i-1][j]
		// nums[j] <= j时， dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
		// 初始化：dp【0】【0】 = 1 表示装满容量为0的背包，有1种⽅法，就是装0件物品。
		// 如果nums【0】在范围内的话，dp【0】[nums【0】] = 1
		// 其他全为0
		dp[0][0] = 1;
		if (nums[0] <= left) {
			dp[0][nums[0]] = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j <= left; j++) {
				if (nums[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[nums.length - 1][left];
	}

	// 二维数组 - 解决（深度理解）- 目标和
	public static int findTargetSumways2(int[] nums, int target) {
		// 我们要求的是给定一个数组 和 一个目标值
		// 该数组经过多少次的取反(加减法) = 目标值的 方法数
		// 我们定义取正数的集合为left 取负数的结合为right
		// left + right = sum
		// left - right = target
		// 推导出: left = (sum + target)/2
		// 前期准备:
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum + target < 0) {// 因为nums[i]均是正整数，所以sum + target >= 0, 即left >= 0
			return 0;
		}
		if ((sum + target) % 2 != 0) {// left 等于小数，正整数怎么可能拼凑出小数来
			return 0;
		}
		int left = (sum + target) / 2;
		// 动态规划五部曲
		// 1.dp数组含义: dp[i][j], 从【0...i】索引下任意获取物品，能填满容量为j的背包的方法数是dp[i][j]
		int[][] dp = new int[nums.length][left + 1];
		// 2.递推公式
		// 判断nums[i] > j ： 不选: dp[i][j] = dp[i-1][j]
		// 反之： 选: dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
		// 3.初始化； dp[0][0] = 1; 当需要填满容量为0背包的方法就是全都不取，有一种方法
		// 如果 nums[0] <= left, 第一个数能放进背包中时 : dp[0][nums[0]] = 1，有一种方法
		dp[0][0] = 1;
		if (nums[0] <= left) {
			dp[0][nums[0]] = 1;
		}
		// 遍历顺序,需要前面的状态，所以正序遍历：先遍历物品再遍历背包(二维可互换)
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= left; j++) {
				if (nums[i] > j) {
					dp[i][j] = dp[i - 1][j];// 不选
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[nums.length - 1][left];
	}

	// 一维数组 - 优化- 目标和
	public static int findTargetSumways3(int[] nums, int target) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if (sum + target < 0) {
			return 0;
		}
		if ((sum + target) % 2 != 0) {
			return 0;
		}
		int left = (sum + target) / 2;
		if (left < 0)
			left = -left;
		int[] dp = new int[left + 1];
		//初始化
		dp[0] = 1;
		// 先遍历物品，后逆序遍历背包
		for (int i = 0; i < dp.length; i++) {
			for (int j = left; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[left];
	}

}
