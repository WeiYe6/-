package 动态规划;

public class pro80 {

	public static void main(String[] args) {
		//  判断子序列
		//题目: 
//		给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//		字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
//		（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//		示例 1：
//		输入：s = "abc", t = "ahbgdc"
//		输出：true
//		示例 2：
//		输入：s = "axc", t = "ahbgdc"
//		输出：false
		String s = "abc";
		String t = "ahbgdc";
		boolean subsequence = isSubsequence(s, t);
		System.out.println(subsequence);
	}
	
	//动态规划
    public static boolean isSubsequence(String s, String t) {
    	//动规五部曲
    	//1.dp数组含义
    	//dp[i][j]-以长度为0-(i-1)的s 和 长度为0-(j-1)的t的最长子序列为dp[i][j]
    	int[][]  dp = new int[s.length()+1][t.length()+1];
    	//2.递推公式
    	//if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
    	//esle dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])//保持前面的状态
    	//3.初始化 注意我的dp数组定义，我使用了冗余字段，减轻初始化的复杂性
    	//且 dp[0][j] 和 dp[i][0]都是无意义的，但是根据我的递推公式得知，应该初始化为0
    	//4.遍历顺序 - 需要前面的状态值，从左到右，正序遍历
    	for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					//dp[i][j] =  dp[i][j-1]; 这题这样写就足以了，因为我们的s是固定的，只需要移动t
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[s.length()][t.length()] == s.length();
    }
    
    
	//暴力
    public static boolean isSubsequence2(String s, String t) {
    	int sIndex = 0;
    	int tIndex = 0;
    	while(sIndex < s.length() && tIndex < t.length()) {
    		if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++; //找到一个了
			}
    		tIndex++;//未找到，t继续向后查找
    	}
    	return sIndex == s.length();//相等，说明全部找到了
    }

}
