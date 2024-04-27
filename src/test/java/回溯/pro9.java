package 回溯;

import java.util.ArrayList;
import java.util.List;

public class pro9 {

	public static void main(String[] args) {
		// 复原IP地址 - 方法二

//		示例 5：
//		输入：s = "101023"
//		输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
		String s = "010010";
		List<String> restoreIpAddresses = restoreIpAddresses(s);
		System.out.println(restoreIpAddresses);
	}

	// 定义全局变量,用于收集结果集
	static ArrayList<String> result = new ArrayList<>();

	public static List<String> restoreIpAddresses(String s) {
		//剪枝操作 ，ip的个数最多只有12个
		if (s.length() > 12) {
			return result;
		}
		//将s转换成sb,便于我们对字符串的操作
		StringBuilder sb = new StringBuilder(s);
		dfs(sb, 0, 0);
		return result;
	}
	//startIndex: 切割字符串的起始位置
	//pointCount: 逗点的个数，只需要加入三个逗点即可
	public static void dfs(StringBuilder sb, int startIndex, int pointCount) {
		//终止条件 - 逗点个数为3时，即可结束了
		if (pointCount == 3) {
			//收集结果
			//还要判断 最后一段 的数字字符是否合法(因为我们判断不到最后一段的数字字符)
			if(check(sb, startIndex, sb.length() - 1)) {
				result.add(sb.toString());
			}
			return;
		}
		//横向遍历
		for (int i = startIndex; i < sb.length(); i++) {
			//处理节点，也是需要判断切割的数字字符是否合法 [startIndex,i] 起始位置 和 终止位置
			if (check(sb, startIndex, i)) {
				//合法，添加逗点
				sb.insert(i + 1, '.');
				pointCount++;
				//递归；纵向遍历 切割过的不能切割 i+1，但是我们加了逗点，所以需要 i + 2
				dfs(sb, i+2, pointCount);
				//回溯-撤销处理结果
				sb.deleteCharAt(i+1);//删除逗点
				pointCount--;
			}else {
				break; //不满足
			}
		}
		
	}
	//判断数字字符的合法性
	//1.只有单个时 开头的数字不能为0
	//2.判断是否有非法字符
	//3.判断切割的数字字符是否在[0-255]之间
	public static boolean check(StringBuilder sb, int startIndex, int end) {
		if (startIndex > end) {
			return false;
		}
		//1.只有单个时 开头的数字不能为0
		if (sb.charAt(startIndex) == '0' && startIndex != end) {
			return false;
		}
		//2.判断是否有非法字符
		for (int i = startIndex; i <= end; i++) {
			if (sb.charAt(i) < '0' || sb.charAt(i) > '9') {
				return false;
			}
		}
		//3判断切割的数字字符是否在[0-255]之间
		int parseInt = Integer.parseInt(sb.substring(startIndex, end + 1));
		if (parseInt < 0 || parseInt  > 255) {
			 return false;
		}
		return true;
	}

}
