package 动态规划;

public class pro85 {

	public static void main(String[] args) {
		// 最长回文子序列
//		给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//		子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//		示例 1：
//		输入：s = "bbbab"
//		输出：4
//		解释：一个可能的最长回文子序列为 "bbbb" 。
//		
//		示例 2：
//		输入：s = "cbbd"
//		输出：2
//		解释：一个可能的最长回文子序列为 "bb" 。
		String s = "bbbab";
		int longestPalindromeSubseq = longestPalindromeSubseq(s);
		System.out.println(longestPalindromeSubseq);

	}

	public static int longestPalindromeSubseq(String s) {
		//动规五部曲
		//1.dp数组含义
		//dp[i][j]-在[i,j]区间范围内的字符串s的最长回文子序列的长度为dp[i][j]
		int[][] dp = new int[s.length()][s.length()];
		//2.递推公式 (i <= j)
		//左右两边的字符相等时,可以把这两个字符添加进回文子序列中 dp[i+1][j-1]为中间字符串内最长的子序列长度
		// if s.charAt(i) == s.chat(j) dp[i][j] = dp[i+1][j-1] + 2;
		//左右两边不相等时，可以把s.charAt(i) 或者 s.charAt(j)其中一个添加进去，判断谁添加进去的回文子序列长度更长
		//else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j])
		//3.初始化，由我们的递推公式 i i+1 j-1 j知，是不断向中间 i==j靠拢的，那么i==j就是我们的根基了
		//dp[i][i], 00,11,22..就是单独一个字符的时候了，最长回文最长就是1
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		//4.遍历顺序，由我们的递推公式得知，需要依靠下方、左下方、左方的状态来进推导出来，
		//所以我们的遍历顺序为 从下往上，从左往右
		for (int i = s.length() - 1; i >= 0; i--) {//从下往上
			for (int j = i + 1; j < s.length(); j++) {//从左往右，j == i+ 1,为什么加1，就是i==j时我们已经初始化了
				if (s.charAt(i) == s.charAt(j)) {//相等时
					dp[i][j] = dp[i+1][j-1] + 2;
				}else {//不等时
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		//返回我们的区间范围为 0--(s.len - 1)的dp即可
 		return dp[0][s.length() - 1];
	}

}
