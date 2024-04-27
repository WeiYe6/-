package 动态规划;

public class pro78 {

	public static void main(String[] args) {
		// 不相交的线
		//题目:
//		我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
//		现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，
//		且我们绘制的直线不与任何其他连线（非水平线）相交。
//		以这种方法绘制线条，并返回我们可以绘制的最大连线数。

	}
	
	//仔细看例子，会发现其实就是要我们求最长公共子序列的长度，和上一题是一模一样的
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
    	//动规五步曲
    	//1.dp数组含义:
    	//dp[i][j]-索引从0-(i-1)的nums1 和 索引从0-(j-1)的nums2的最长公共子序列的长度为dp[i][j]
    	int[][] dp = new int[nums1.length + 1][nums2.length + 2];
    	//2.递推公式
    	//if nums[i-1] == nums[j-1]  dp[i][j] = dp[i-1][j-1] + 1
    	//else 保持上一个的最大状态 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    	//3.初始化 dp[0][j] 和 dp[i][0] 对于我们的dp数组定义来说都是无意义的
    	//又 dp[i][j] = dp[i-1][dp[j-1] + 1知，为了不影响我们的递推结果，我们应该初始化为0
    	//4.遍历顺序: 需要保持上一个的状态值，所以我们应该从上往下、从左往右遍历
    	for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
    	//返回 从0--nums.length-1 长度的最长公共子序列
		return dp[nums1.length][nums2.length];
    }

}
