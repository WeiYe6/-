package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pro11 {

	public static void main(String[] args) {
		// 子集II
//		给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 
//		子集（幂集）。
//		解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//		 
//		示例 1：
//		输入：nums = [1,2,2]
//		输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//				
//		示例 2：
//		输入：nums = [0]
//		输出：[[],[0]]、
		int[] nums = {1,2,2};
		List<List<Integer>> subsetsWithDup = subsetsWithDup(nums);
		System.out.println(subsetsWithDup);

	}

	//定义全局变量 收集结果集 和 单次结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	//定义一个标记数组，用来记录访问过的节点
	static boolean[] used;
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums, 0);
		return result;
	}
	
	public static void dfs(int[] nums, int startIndex) {
		//收集结果 - 因为结果在每个节点上，所以需要提前收集
		result.add(new ArrayList<>(path));
		//终止条件
		if (startIndex == nums.length) {
			return;
		}
		//横向遍历
		for (int i = startIndex; i < nums.length; i++) {
			//数层去重 - 防止出现过的组合再次出现 used[i-1] == false:表示同层的前一个相等元素已经使用过了，回溯到本元素的。
			if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
				continue;//跳过
			}
			//处理节点
			path.add(nums[i]);
			used[i] = true;//做标记
			//递归，纵向遍历，取过的不能再取了
			dfs(nums, i+1);
			//回溯-撤销处理结果
			path.removeLast();
			used[i] = false;//清除标记
		}
		
		
	}

}
