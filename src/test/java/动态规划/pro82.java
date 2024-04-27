package 动态规划;


public class pro82 {

	public static void main(String[] args) {
		// 两个字符串的删除操作
		// 题目：
//		给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
//		每步 可以删除任意一个字符串中的一个字符。
//		示例 1：
//		输入: word1 = "sea", word2 = "eat"
//		输出: 2
//		解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
//		示例  2:
//		输入：word1 = "leetcode", word2 = "etco"
//		输出：4
		String word1 = "sea";
		String word2 = "eat";
		int minDistance = minDistance2(word1, word2);
		System.out.println(minDistance);

	}

	// 方法一：
	public static int minDistance(String word1, String word2) {
		// 动规五部曲
		// 1.dp数组含义
		// dp[i][j]-以i-1结尾的word1 和以j-1结尾的word2,使得他们相同的最少删除次数为dp[i][j]
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		// 2.递推公式
		// 相等时，删与不删都不影响我们最终相等，且要求的是最少次数，那我们就不删了，保留上一个状态值即可
		// if(word1.charAt(i-1) == word.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
		// 不等时，需要删除，那么有多少种删除的操作呢? 可以删除word1 可以删除word2,也可以都删除(word1 和 word2都删除)
		// else Math.min(dp[i-1][j] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j-1] + 2));
		// 3.初始化
		// dp[i][0]：表示word1删除多少次变成空集 就是 i次咯 eg dp[2][0],2对应的索引为1，以索引1结尾的word1
		// 长度为2,就是全删除咯
		// dp[0][j]：表示word2删除多少次变成空集 就是j次咯
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}
		
		//4.遍历顺序 - 由递推公式得知 可由我们的左方、上方、左上方推导出来，所以需要前面的状态值，正序遍历
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {//如果相等，不删除
					dp[i][j] = dp[i-1][j-1];//保留之前的状态值
				}else {//如果不相等，需要删除，有三种删除的方法，取最小值
					dp[i][j] = Math.min(dp[i-1][j] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j-1] + 2));
				}
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		//返回以word1 和 word2最后那个元素结尾的dp
		return dp[word1.length()][word2.length()];
	}
	
	// 方法二：求出来两个字符串的 最长公共子序列长度 之后 【(word1 + word2) - 2*公共子序列长度】就是我们需要的最少删除次数了
	public static int minDistance2(String word1, String word2) {
		//1.dp数组含义
		//dp[i][j]-以i-1结尾的word1 和 以j-1结尾的word2的最长公共子序列长度为dp[i][j]
		int[][] dp = new int[word1.length() + 1][word2.length()  +1];
		//2.递推公式
		//相等时，最长公共子序列加1
		//if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
		//不等时，保持前一个状态值即可，但是有两种情况，word1删除一个元素（回溯一步 或者 word2删除一个元素（回溯一步），取最大值那个
		//esle dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		//3.初始化, dp[i][0] 和 dp[0][j] 对于我们的dp数组定义来说是无意义的，由递推公式得知，为了不影响递推解决初始化为0即可
		//dp[i][0] = 0
		//dp[0][j] = 0
		//4.遍历顺序，由递推公式得知 可以由左方 、左上方、上方推导出来当前值,需正序遍历
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;//相等时，在之前的状态值 + 1
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//不等时，保留之前状态的最大值即可
				}
			}
		}
		return (word1.length() + word2.length()) - (2* dp[word1.length()][word2.length()]);
	}

}
