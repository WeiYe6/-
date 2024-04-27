package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pro6 {

	public static void main(String[] args) {
		// 组合总和II
//		给定一个候选人编号的集合 candidates 和一个目标数 target,找出 candidates 中所有可以使数字和为 target 的组合。
//		candidates 中的每个数字在每个组合中只能使用 一次 。
//		注意：解集不能包含重复的组合。 
//		示例 1:
//		输入: candidates = [10,1,2,7,6,1,5], target = 8,
//		输出:
//		[
//		[1,1,6],
//		[1,2,5],
//		[1,7],
//		[2,6]
//		]
//				
//		示例 2:
//		输入: candidates = [2,5,2,1,2], target = 5,
//		输出:
//		[
//		[1,2,2],
//		[5]
//		]
		int[] candidates = { 2, 5, 2, 1, 2 };
		int target = 5;
		List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);
		System.out.println(combinationSum2);
	}

	// 定义全局变量，存放结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	// 加标记数组，用来去重操作（这里是树层去重）
	static boolean[] used;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		used = new boolean[candidates.length];// 加标记数组，默认初始值为false
		Arrays.sort(candidates);
		dfs(candidates, target, 0, 0);
		return result;
	}

	public static void dfs(int[] candidates, int target, int sum, int index) {
		// 终止条件
		if (sum > target) {
			return;
		}
		// 收集结果
		if (sum == target) {
			result.add(new ArrayList<>(path));

		}
		// 横向遍历
		for (int i = index; i < candidates.length; i++) {
			//出现重复节点，同层的第一个节点已经被访问过了，所以直接跳过
			if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
				continue;
			}
			// 剪枝-优化
			// 数组已经从小到大排序
			if (sum + candidates[i] > target) {
				break;
			}
			// 处理节点
			used[i] = true;
			sum += candidates[i];
			path.add(candidates[i]);
			// 递归：纵向遍历 题目要求- 每个数字在每个组合中只能使用 一次
			dfs(candidates, target, sum, i + 1);
			// 回溯，撤销处理结果
			used[i] = false;
			sum -= candidates[i];
			path.removeLast();
		}
	}

}
