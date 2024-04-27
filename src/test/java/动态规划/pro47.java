package 动态规划;

public class pro47 {

	public static void main(String[] args) {
		// 16. 分割等和子集
		//给你一个 只包含正整数 的 非空 数组 nums 。
		//请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
		int[] nums = {1,5,11,5,1};
		boolean canPartition = canPartition(nums);
		System.out.println(canPartition);

	}
	
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return false;
        }
        int sum = 0;
        for(int i =0; i < len; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) {
        	return false;
        }
        int tager = sum / 2;
        
        //动态规划 -  状压
        int[] dp = new int[tager +1];
        dp[0] = 0;
        //先遍历物品，再遍历背包
        //物品的重量 和 价值都等于 nums[i];
        for(int i =1; i < len; i++) {
        	for (int j = tager; j >= nums[i -1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - nums[i -1]] + nums[i-1]);
			}
        }
        if (dp[tager] == tager) {
            return true;
		}
        return false;
    }
    
    

}
