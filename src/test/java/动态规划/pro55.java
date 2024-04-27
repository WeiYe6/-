package 动态规划;

public class pro55 {

	public static void main(String[] args) {
		// 最后一块石头的重量II - 动态规划
//		输入：stones = [2,7,4,1,8,1]
//		输出：1
//				解释：
//				组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//				组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//				组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//				组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		int lastStoneWeightII = lastStoneWeightII(stones);
		System.out.println(lastStoneWeightII);

	}

	public static int lastStoneWeightII(int[] stones) {
		// 动规五部曲
		// dp[j]含义: 容量为j的背包所能装的物品的最大价值总和
		// 这题我们要知道，如果能把这堆石头分成近似相等的两堆石头再相撞的话，那是不是就是最优解了
		// 还要知道stones[i]： 既是重量也是对应的价值
		// 那么这题 dp[j]： 容量为j的背包所能装的最大重量总和（价值）我们要求的就是 dp[sum/2]
		// dp[sum/2]：容量为sum/2的背包所能装的最大重量
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		int target = sum / 2;
		int[] dp = new int[target + 1];// 我们还是从1开始算
		// 递推公式 //放得下 -(放了价值有变大吗?) 还是 放不下-等于前一个的dp[j]
		// dp[j] = Math.max(dp[j], dp[j-stones[i-1]] + stones[i-1])
		// 初始化: dp[0] = 0：容量为0时放入的重量就为0，默认就是0
		// 遍历顺序
		// 先遍历物品，后逆序遍历背包
		for (int i = 1; i <= stones.length; i++) {
			for (int j = target; j >= stones[i - 1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
			}
		}
		return sum - 2 * dp[target]; 
		//注意: 这里为什么要 乘2？ 因为我们的sum就是还未分之前的总和，所以相当与一大推 - 2小推: (sum-dp[target]) - dp[target]
		//也可以写成 sum/2 - dp[target]：但是要注意如果sum是奇数的话，就会向下取整，那么我们就要加回1，有点麻烦所以这样写
	}

}
