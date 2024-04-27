package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro3 {

	public static void main(String[] args) {
		// 组合总和III
//		找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
//		并且每种组合中不存在重复的数字。
//		说明：
//		所有数字都是正整数。
//		解集不能包含重复的组合。
//		示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
//		示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]

		int k = 3;
		int n = 9;
		List<List<Integer>> combinationSum3 = combinationSum3(k, n);
		System.out.println(combinationSum3);

	}

	// 回溯算法
	// 定义两个全局变量
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> combinationSum3(int k, int n) {
		dfs(n, k, 0, 1);
		return result;
	}

	// startIndex：递归下一次的起始位置 - （防止数字重复选取）
	public static void dfs(int n, int k, int sum, int startIndex) {
		// 剪枝
		if (sum > n) {
			return;
		}
//     【 if (path.size() > k) return;】 和 【 i <=  9 - (k - path.size()) + 1  】一样的效果
		// 终止条件
		if (path.size() == k) {
			// 收集结果
//			int sum = 0;
//			for (int i : path) {
//				sum += i;
//			}
			if (sum == n) {
				result.add(new ArrayList<>(path));
			}
			return;
		}
		// 控制树的横向遍历
		// 优化 - 剪枝操作
		// 选择的元素个数: path.size()
		// 剩余的需要选择的元素个数： k - path.size()
		// 选取长度符合的元素个数 9 - (k - path.size()) + 1
		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			// 处理节点
			sum += i;
			path.add(i);
			// 递归： 控制树的纵向遍历
			dfs(n, k, sum, i + 1);
			// 回溯,撤销处理结果
			sum -= i;
			path.removeLast();
		}
	}

}
