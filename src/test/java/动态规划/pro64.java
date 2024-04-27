package 动态规划;


import java.util.*;

public class pro64 {

	public static void main(String[] args) {
		// 139. 单词拆分 - 完全背包问题
//		给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
//		如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//		注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//		示例 1：
//		输入: s = "leetcode", wordDict = ["leet", "code"]
//		输出: true
//		解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//		
//		示例 2：
//		输入: s = "applepenapple", wordDict = ["apple", "pen"]
//		输出: true
//		解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//		     注意，你可以重复使用字典中的单词。
//		     
//		示例 3：
//		输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//		输出: false
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean wordBreak = wordBreak(s, wordDict);
		System.out.println(wordBreak);
		 

	}
	
    public static boolean wordBreak(String s, List<String> wordDict) {
    	//动规五部曲
    	//1.dp数组的含义：dp[j]-是否能正好装满容量为j的背包, 求dp[s.length].equals(s)  ? true : false;
    	String[] dp = new String[s.length() + 1];
    	//2.递推公式: 求的是该背包能否被物品装满，且要求装进背包里面的物品顺序 (知- 求排列数)
    	//3.初始化,均初始化为空字符串
    	for (int i = 0; i < dp.length; i++) {
			dp[i] = "";
		}
    	//遍历顺序，排列问题 先遍历背包（正序），再遍历物品
    	for(int j = 0; j <= s.length(); j++) {//背包
    		for(int i = 0; i < wordDict.size(); i++) {//物品
    			if(wordDict.get(i).length() <= j) {
    				String temp = s.substring(0,j);
    				if (dp[j].equals(temp)) { //等于的话就不用添加了，保持上一个状态值
						dp[j] =dp[j];
					}else {
						dp[j] = dp[j-wordDict.get(i).length()] + wordDict.get(i);//添加进来
					}
    			}
    		}
    	}
    	
    	for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}
    	
    	return dp[s.length()].equals(s);
    }

}
