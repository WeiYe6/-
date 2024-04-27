package 动态规划;

public class pro60 {

	public static void main(String[] args) {
		// 组合总和IV - 动态规划 - 完全背包问题
		//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
		//请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//		示例 1：
//		输入：nums = [1,2,3], target = 4
//		输出：7
//		解释：
//		所有可能的组合为：
//		(1, 1, 1, 1)
//		(1, 1, 2)
//		(1, 2, 1)
//		(1, 3)
//		(2, 1, 1)
//		(2, 2)
//		(3, 1)
//		请注意，顺序不同的序列被视作不同的组合。
		int[] nums = {1,2,3};
		int target = 4;
		int combinationSum4 = combinationSum4(nums, target);
		System.out.println(combinationSum4);
		

	}
	
	/**
	 * 完全背包 - 求排列数，此题和进阶爬楼梯是一样的，就是第一步可以爬1，第n步可以爬n步，问有几种爬到楼顶的方法。
	 * 掌握: 求排列数 和 求组合数的方式写法
	 * 排列数: 先遍历背包，再遍历物品
	 * 组合数: 先遍历物品，再遍历背包
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int combinationSum4(int[] nums, int target) {
    	//动规五部曲
    	//注意这里:题目说顺序不同为不同组合，所以应该为排列数
    	//1.dp数组含义:  装满容量为j的背包，所具有的排列数为dp[j]
    	int[] dp = new int[target + 1];
    	//2.递推公式: 排列组合问题一般的公式为: dp[j] += dp[j-nums[i]]
    	//3.初始化 dp[0] ： 背包容量为0时，排列数为1，就是什么都不选
    	dp[0] = 1;
    	//4.遍历顺序： 完全背包问题，且求的是排列数，所以
    	//采用； （正序）先遍历背包，再遍历物品
    	for(int j = 1; j <= target; j++) {
    		for(int i = 0; i < nums.length; i++) {
    			if (j >= nums[i]) {//放得下
					dp[j] += dp[j-nums[i]];
				}
    		}
    	}
    	return dp[target];
    }

}
