package 回溯;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro7 {

	public static void main(String[] args) {
		// 分割回文串
//		给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 
//		回文串
//		 。返回 s 所有可能的分割方案。
//
//		示例 1：
//		输入：s = "aab"
//		输出：[["a","a","b"],["aa","b"]]
//				
//		示例 2：
//		输入：s = "a"
//		输出：[["a"]]
		
//		本题几个难点：
//		1.切割问题可以抽象为组合问题
//		2.如何模拟那些切割线
//		3.切割问题中递归如何终止
//		4.在递归循环中如何截取子串
//		5.如何判断回文
		
		String s = "abbab";
		List<List<String>> partition = partition(s);
		System.out.println(partition);
		
	}

	// 定义全局变量，用于收集结果集 和 的单次结果
	static ArrayList<List<String>> result = new ArrayList<>();
	static LinkedList<String> path = new LinkedList<>();

	public static List<List<String>> partition(String s) {
		dfs(s, 0);
		return result;
	}

	// startIndex：切割字符串的起始位置
	public static void dfs(String s, int startIndex) {
		// 终止条件,切割的起始位置已经到字符串的末尾了
		if (startIndex >= s.length()) {
			// 收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		// 横向遍历
		for (int i = startIndex; i < s.length(); i++) {
			// 处理节点，搜集满足 回文字符串 的节点
			if (check(s, startIndex, i)) {
				//添加范围在[startIndex,i]左闭右闭区间范围的字符串
				String str = s.substring(startIndex, i+1);//i+1,就是取右闭区间的
				path.add(str);
			}else {
				continue;//不满足不添加
			}
			//递归，纵向遍历，注意: 切割过的不能在切割了 i + 1
			dfs(s, i + 1);
			//回溯，撤销处理结果
			path.removeLast();
		}
	}

	// 判断s字符串在 [startIndex,i]的范围中是不是回文串
	public static boolean check(String s, int startIndex, int end) {
		// i < j - 就是如果字符串的个数大于等于2才判断，如果只有1个字符串，直接返回true
		for (int i = startIndex, j = end; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
