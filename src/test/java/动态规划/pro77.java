package 动态规划;

public class pro77 {

	public static void main(String[] args) {
		// 最长公共子序列
		//题目:
//		给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//		一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
//		（也可以不删除任何字符）后组成的新字符串。
//		例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//		两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列
//		示例 1：
//		输入：text1 = "abcde", text2 = "ace" 
//		输出：3  
//		解释：最长公共子序列是 "ace" ，它的长度为 3 。
//		示例 3：
//		输入：text1 = "abc", text2 = "def"
//		输出：0
//		解释：两个字符串没有公共子序列，返回 0 。
		String text1 = "abcde";
		String text2 = "ace";
		int longestCommonSubsequence = longestCommonSubsequence(text1, text2);
		System.out.println(longestCommonSubsequence);
	}
	
    public static int longestCommonSubsequence(String text1, String text2) {
    	//动规五部曲
    	//1.dp数组含义
    	//dp[i][j]- 是长度为[0 到 (i-1)]的text1 和 长度为[0 到 (j-1)]的text2的最长公共子序列的长度为dp[i][j]
    	int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    	//2.递推公式 dp[i][j] 可以 由它的左方，上方，左上方推导出来（如果text1当前元素 不等于 text2的当前元素，那么就保留之前状态的）
    	//if( text1.chat(i-1) == text2.chat(j-1) ) {当前两元素相等
    	//   dp[i][j] = dp[i-1][j-1] + 1;
    	//}else{//不相等时，保留之前最大的状态值即可
    	//   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    	//}
    	//3.初始化: dp[0][j] 和 dp[i][0] 对于我们的dp数组定义来说是无意义的，是我们的冗余字段(减少代码初始化常用手段)
    	//dp[0][j] = 0,由我们的递推公式 只有等于0才不影响后面的结果 dp[i][0]同理
    	//4.遍历顺序，需要前面的状态值，需要从左到右，从上到下遍历 (均正序遍历)
    	for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
    	//返回dp[text1.length()][text2.length()]即可: 表示长度为0-(text1-1)
		return dp[text1.length()][text2.length()];
    }

}
