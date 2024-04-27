package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro10 {

	public static void main(String[] args) {
		// 子集
//		给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
//		子集（幂集）。
//		解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//		
//		示例 1：
//		输入：nums = [1,2,3]
//		输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//				
//		示例 2：
//		输入：nums = [0]
//		输出：[[],[0]]\
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(nums);
		System.out.println(subsets);
	}

	// 定义全局变量 - 收集结果集和单次结果
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> subsets(int[] nums) {
		//Arrays.sort(nums); // 排序
		dfs(nums, 0);
		return result;
	}

	public static void dfs(int[] nums, int startIndex) {
		// 收集结果 「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
		//if (!result.contains(path)) {// 存在就不需要添加了
			result.add(new ArrayList<>(path));
		//}
		// 终止条件
		if (startIndex == nums.length) {
			return;
		}
		// 横向遍历
		for (int i = startIndex; i < nums.length; i++) {
			// 处理节点
			path.add(nums[i]);
			// 递归-纵向遍历，因为不能取过上一次用过的所以i+1
			dfs(nums, i + 1);
			// 回溯：撤销处理结果
			path.removeLast();
		}

	}

}
