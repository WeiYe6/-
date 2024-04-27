package 回溯;

import java.util.ArrayList;
import java.util.List;

public class pro8 {

	public static void main(String[] args) {
		// 复原IP地址 - 方法一
//		给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//		有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//		例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//		和 "192.168@1.1" 是 无效的 IP 地址。
//
//		示例 1：
//		输入：s = "25525511135"
//		输出：["255.255.11.135","255.255.111.35"]
//				
//		示例 2：
//		输入：s = "0000"
//		输出：["0.0.0.0"]
//				
//		示例 3：
//		输入：s = "1111"
//		输出：["1.1.1.1"]
//				
//		示例 4：
//		输入：s = "010010"
//		输出：["0.10.0.10","0.100.1.0"]
//				
//		示例 5：
//		输入：s = "101023"
//		输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
		String s = "010010";
		List<String> restoreIpAddresses = restoreIpAddresses(s);
		System.out.println(restoreIpAddresses);

	}

	// 定义全局变量，收集结果集
	static ArrayList<String> result = new ArrayList<>();

	public static List<String> restoreIpAddresses(String s) {
		//剪枝
		if (s.length() > 12) {
			return result;
		}
		dfs(s, 0, 0);
		return result;
	}

	// 数字字符串的切割起始位置为: startIndex
	// pointNum： 逗点的个数: 只能加三个逗点
	public static void dfs(String s, int startIndex, int pointNum) {
		// 终止条件: 只能加3个逗点
		if (pointNum == 3) {
			// 收集结果
			// 判断最后一段的数字是否是合法
			if (check(s, startIndex, s.length() - 1)) {
				result.add(s);
			}
			return;
		}
		// 横向遍历
		for (int i = startIndex; i < s.length(); i++) {
			// 处理节点 , 添加符合条件的节点
			// 1.只有单个时 开头的数字不能为0
			// 2.数字的范围在0---255之间
			if (check(s, startIndex, i)) {// 判断符合上面的条件吗？
				// 改变s即可，就是在需要的位置加逗点，不需要sb拼接
				s = s.substring(0, i + 1) + "." + s.substring(i + 1);
				pointNum++;
				// 递归：纵向遍历 - 注意：切割过的不能再次切割 且加了一个逗点 所以下一次的起始位置为 i + 2
				dfs(s, i + 2, pointNum);
				// 回溯：撤销处理结果，删除掉逗点
				pointNum--;
				s = s.substring(0, i + 1) + s.substring(i + 2);
			} else {
				break;// 不满足直接跳过
			}

		}

	}

	public static boolean check(String s, int startIndex, int end) {
		// 判断传进来的数字字符串是否是合法
		if (startIndex > end) {
			return false;
		}
		// 只有单个时 开头的数字不能为0
		if (s.charAt(startIndex) == '0' && startIndex != end) {
			return false;
		}
		// 没有特殊符号
		for (int i = startIndex; i <= end; i++) {
			if (s.charAt(i) > '9' || s.charAt(i) < '0') {// 遇到非法字符
				return false;
			}
		}
		// 数字的范围在0---255之间,
		int parseInt = Integer.parseInt(s.substring(startIndex, end + 1));
		if (parseInt < 0 || parseInt > 255) {
			return false;
		}

		return true;
	}

}
