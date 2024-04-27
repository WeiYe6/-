package 动态规划;

public class pro83 {

	public static void main(String[] args) {
		// 编辑距离
//		给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//		你可以对一个单词进行如下三种操作：
//		插入一个字符
//		删除一个字符
//		替换一个字符
//		示例 1：
//		输入：word1 = "horse", word2 = "ros"
//		输出：3
//		解释：
//		horse -> rorse (将 'h' 替换为 'r')
//		rorse -> rose (删除 'r')
//		rose -> ros (删除 'e')
//		示例 2：
//		输入：word1 = "intention", word2 = "execution"
//		输出：5
//		解释：
//		intention -> inention (删除 't')
//		inention -> enention (将 'i' 替换为 'e')
//		enention -> exention (将 'n' 替换为 'x')
//		exention -> exection (将 'n' 替换为 'c')
//		exection -> execution (插入 'u')
		String word1 = "intention";
		String word2 = "execution";
		int minDistance = minDistance(word1, word2);
		System.out.println(minDistance);

	}

	public static int minDistance(String word1, String word2) {
		// 动规五部曲
		// 1.dp数组含义
		// dp[i][j]-以i-1结尾的word1 经过多少次的增|删|换 变成以 j-1结尾的word2的最少次数为dp[i][j]
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		// 2.递推公式
		// 相等时，不需要操作，保持上一个状态值即可
		// if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
		// 不相等时，需要操作，有增(这里可以理解为删除word2中的元素就是变相增加word1的元素了)、
		//删、换的3种使之相等的操作，我们取操作次数最少的即可
		// else Math.min(dp[i-1][j] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j-1] + 1);
		// 3.初始化
		// dp[0][0],已经相等，不操作 0
		// dp[i][0],如何使word1变成空集，全删 = i
		// dp[0][j],如何使空集变成word2, 全增 =j
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}
		// 4.遍历顺序，由我们的递推公式得知，需要前面的状态，由左往右，由上往下遍历
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; // 相等时不需要操作
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));// 有3种操作，取操作次数最少的
				}
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		// 返回以 word1 和 word2最后一个元素结尾的dp
		return dp[word1.length()][word2.length()];
	}

}
