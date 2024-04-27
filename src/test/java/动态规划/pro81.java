package 动态规划;

public class pro81 {

	public static void main(String[] args) {
		// 不同的子序列
		//题目:
//		给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
//		示例 1：
//		输入：s = "rabbbit", t = "rabbit"
//		输出：3
//		解释：
//		如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//		rabbbit
//		rabbbit
//		rabbbit
//		
//		示例 2
//		输入：s = "babgbag", t = "bag"
//		输出：5
//		解释：
//		如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//		babgbag
//		babgbag
//		babgbag
//		babgbag
//		babgbag
		String s = "rabbbit";
		String t = "rabbit";
		int numDistinct = numDistinct(s, t) % 1000000007;
		System.out.println(numDistinct);

	}
	
    public static int numDistinct(String s, String t) {
    	//动规五步曲
    	//1.dp数组含义
    	//dp[i][j]-以长度为 i-1结尾的s中出现了以j-1结尾的t中的个数为dp[i][j]
    	int[][] dp = new int[s.length() + 1][t.length() + 1];
    	//2.递推公式
    	//相等时:if(s.charAt(i-1) == t.charAt[j-1]) dp[i][j] = dp[i-1][j-1] + dp[i-1][j] 推导出来，
  //可由 它的左上方 和 上方推导出来，如何理解上方呢? 就是删除掉一个s元素时看是否也满足t为它的子序列，可自己打表推导一下就全明白了
    	//不相等时:else dp[i-1][j]// 保持上一个满足的状态即可
    	//3.初始化 dp[0][j] 和 dp[i][0] 、dp[0][0]的含义
    	//dp[0][0] = 1, 由dp定义知，s为空集时有多少种方法变成t空集 - 1种
    	//dp[0][j] = 0, s为空集时有多少种方法变成 t 0种
    	//dp[i][0] = 1; s有多少种方法变成t空集，1种全删了
    	for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 1;
		}
    	//4.遍历顺序 由递推公式得知 我们需要从上到下 从左到右来遍历
    	for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; //相等时
				}else {
					dp[i][j] = dp[i-1][j];//不等时,等于s上一个字符的时候（既然加上这个字符不相等，那就减去这个字符）
				}
			}
		}
    	//返回以s和t的最后一个索引为长度的dp
		return dp[s.length()][t.length()];
    }

}
