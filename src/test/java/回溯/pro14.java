package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro14 {

	public static void main(String[] args) {
		// 全排列
//		给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//		示例 1：
//		输入：nums = [1,2,3]
//		输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//				
//		示例 2：
//		输入：nums = [0,1]
//		输出：[[0,1],[1,0]]
//				
//		示例 3：
//		输入：nums = [1]
//		输出：[[1]]
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> permute = permute(nums);
		System.out.println(permute);
	}
	// 全排列 与 之前（组合）题目的区别
	// 1.树层可重复取，树枝不可重复取: 需要used数组记录path里都放了哪些元素了
	// 2.每层都是从0开始搜索而不是startIndex

	// 定义全局变量用于收集结果集 和 单次结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	static boolean[] used; // 标记数组

	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return result;
		}
		used = new boolean[nums.length];
		dfs(nums);
		return result;
	}

	public static void dfs(int[] nums) {
		// 终止条件: 达到 nums[] 元素个数
		if (path.size() == nums.length) {
			// 收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		// 横向遍历： i=0 之前使用过的元素依然可以使用
		for (int i = 0; i < nums.length; i++) {
			// 实现树枝去重: 树枝上就是取过的元素不能再次使用了(一个排列里一个元素只能使用一次)
//			if (used[i] == true) {
//				continue;
//			}
			// 树枝去重 方法二:判断path中是否取过该元素
			if (path.contains(nums[i])) {
				continue;
			}
			// 处理节点
			path.add(nums[i]);
			used[i] = true;
			// 递归：纵向遍历，树层可重复取，树枝不可重复取
			dfs(nums);
			// 回溯：撤销处理结果
			path.removeLast();
			used[i] = false;
		}

	}

}
