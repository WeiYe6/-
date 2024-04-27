package 回溯;

import java.util.ArrayList;
import java.util.List;

public class pro4 {

	public static void main(String[] args) {
		// 电话号码的字母组合
//		给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//		给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//		示例 1：
//		输入：digits = "23"
//		输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//				
//		示例 2：
//		输入：digits = ""
//		输出：[]
//				
//		示例 3：
//		输入：digits = "2"
//		输出：["a","b","c"]
		String digits = "23";
		List<String> letterCombinations = letterCombinations(digits);
		System.out.println(letterCombinations);
	}
	//定义全局变量 存放结果集 和 单次结果集
	static ArrayList<String> result = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
    public static List<String> letterCombinations(String digits) {
    	if (digits.length() == 0) {
			return new ArrayList<>();
		}
    	dfs(digits, 0);
		return result;
    }
    public static void dfs(String digits, int index) {
		//数字映射字符操作
    	String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	//终止条件
    	if(digits.length() == sb.length()) {
    		//收集结果
    		result.add(sb.toString());
    		return;
    	}
    	int strInex = digits.charAt(index) - '0';//获取传入的数字字符
    	String digit = map[strInex]; //获取到该数字对应的 字符集合
    	//横向遍历
    	for (int i = 0; i < digit.length(); i++) {
    		//处理节点
			sb.append(digit.charAt(i));
			//递归：纵向遍历
			dfs(digits, index+1);
			//回溯，撤销处理结果
			sb.deleteCharAt(sb.length() - 1);//弹出刚刚添加的那个
		}
    	
	}

}
