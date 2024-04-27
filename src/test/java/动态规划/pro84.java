package 动态规划;

public class pro84 {

	public static void main(String[] args) {
		// 回文子串
//		给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//		回文字符串 是正着读和倒过来读一样的字符串。
//		子字符串 是字符串中的由连续字符组成的一个序列。
//		具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//		示例 1：
//		输入：s = "abc"
//		输出：3
//		解释：三个回文子串: "a", "b", "c"
		
//		示例 2：
//		输入：s = "aaa"
//		输出：6
//		解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
		String s = "abc";
		int countSubstrings = countSubstrings2(s);
		System.out.println(countSubstrings);


	}

	public static int countSubstrings(String s) {
		//动规五部曲
		//1.dp数组含义
		//dp[i][j]-在[i,j]区间范围中该字符串 是否是回文子串 是则 dp[i][j] = true
		boolean[][] dp = new boolean[s.length()][s.length()];
		int result = 0;
		//2.递推公式 j >= i的
		//情况1： s.charAt(i)==s.charAt(j) 相等时
		// 当 j == i时，就只有一个字符了，那么必定是回文子串                                                      result ++;
		// 当 j-i=1时，就是相差一个字符了，那么当 s.charAt(i)==s.charAt(j) 就是回文子串了   result ++;
		// 当 j-i > 1时，就是有多个字符了，那么我们需要判断[i,j]中间的字符串是否是回文子串，
		//即 dp[i+1][j-1] == true ，那么[i,j]该范围的字符串就是回文子串了                               result ++;
		//情况2： 就是  s.charAt(i)!=s.charAt(j) dp[i][j] = false，这步我们初始化时解决了
		//3.初始化 dp[i][0] dp[0][j] 根据我们的dp数组定义，我们是不知道该情况的，所以我们直接初始为false就好了
		//4.遍历顺序， 由递推公式得知，dp[i][j] 需要由 dp[i+1][j-1]的结果来进行推导，所以为 下到上、左到右进行遍历
		for (int i = s.length() - 1; i >= 0; i--) {//从下到上
			for (int j = i; j < s.length(); j++) {//从左到右
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i <= 1) {
						dp[i][j] = true;
						result ++;
					}else if (dp[i+1][j-1]) { //j - i > 1，判断中间的字符串是否是回文
						dp[i][j] = true;
						result ++;
					}
				}
			}
		}
		return result;
	}

	//方法二: 中心拓展法 以一个字符和两个字符为中心，向左右两边拓展，寻找回文子串
	public static int countSubstrings2(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= 1; j++) { //中心拓展点
				int l = i;
				int r = i + j;
				while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
					result++;
				}
			}
		}
		return result;
	}
}
