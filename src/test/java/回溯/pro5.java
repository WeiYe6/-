package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pro5 {

	public static void main(String[] args) {
		// 组合总和
//		给定一个无重复元素的数组 candidates 和一个目标数 target ，
//		找出 candidates 中所有可以使数字和为 target 的组合。
//		candidates 中的数字可以无限制重复被选取。
//
//		说明：
//		所有数字（包括 target）都是正整数。
//		解集不能包含重复的组合。
//		
//		示例 1：
//		输入：candidates = [2,3,6,7], target = 7,
//		所求解集为： [ [7], [2,2,3] ]
//				
//		示例 2：
//		输入：candidates = [2,3,5], target = 8,
//		所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
		int[] candidates = {2,3,5};
		int target = 8;
		List<List<Integer>> combinationSum = combinationSum(candidates, target);
		System.out.println(combinationSum);

	}

	//全局变量，用于存放结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates); //排序，从小到大排序
		dfs(candidates, target, 0, 0);
		return result;
	}
	public static void dfs(int[] candidates, int target,int sum, int index) {
		//终止条件
		if (sum > target) {
			return;
		}
		if (sum == target) {
			//收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		//横向遍历
		for (int i = index; i < candidates.length; i++) {
	//剪枝优化: 数组已经从小到大排序好了，如果 sum+candidates[i] > target ,就可以结束本次循环了，后面的一定大于
			if (sum + candidates[i] > target) {
				break;
			}
			//处理节点
			sum += candidates[i];
			path.add(candidates[i]);
			//递归，纵向遍历
			dfs(candidates, target, sum, i);
			//回溯，撤销处理结果
			sum -= candidates[i];
			path.removeLast();
		}
	}

}
