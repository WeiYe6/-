package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro12 {

	public static void main(String[] args) {
		// 递增子序列 - 方法一
//		给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
//		你可以按 任意顺序 返回答案。
//		数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//		示例 1：
//		输入：nums = [4,6,7,7]
//		输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//				
//		示例 2：
//		输入：nums = [4,4,3,2,1]
//		输出：[[4,4]]
		int[] nums = { 4, 6, 7, 7 };
		List<List<Integer>> findSubsequences = findSubsequences(nums);
		System.out.println(findSubsequences);

	}

	// 定义全局变量 - 用于收集结果集 和 单次结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	// 标记数组- 用于去重操作
	static boolean[] used;

	public static List<List<Integer>> findSubsequences(int[] nums) {
		used = new boolean[nums.length];
		dfs(nums, 0);
		return result;
	}

	// startIndex: 用于防止 取过的元素在同层中不能再次取
	public static void dfs(int[] nums, int startIndex) {
		// 结果在每个节点中
		// 收集结果
		if (path.size() >= 2) {
			result.add(new ArrayList<>(path));
		}
		// 终止条件
		if (startIndex == nums.length) {
			return;
		}
		// 横向遍历
		for (int i = startIndex; i < nums.length; i++) {
			// 处理节点
			// 实现树层去重操作,因为我们没有排序，所以需要从当前元素向前寻找和它相同的元素(如果存在)
			if (i > startIndex) { //startIndex: 每一层的起始索引
				int j = i - 1;
				while (j >= startIndex && nums[j] != nums[i])
					j--;
				if (j >= startIndex) {//判断索引有效性
					if (used[j] == false) {
						continue;
					}
				}
			}
			// 判断 下一个要添加的元素需要 大于等于 前一个刚刚添加的元素 -注 第一次不用判断
			if (!path.isEmpty() && nums[i] < path.getLast()) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			dfs(nums, i + 1);
			// 回溯 -撤销处理结果
			path.removeLast();
			used[i] = false;
		}
	}

}
