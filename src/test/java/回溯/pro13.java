package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class pro13 {

	public static void main(String[] args) {
		// 递增子序列 - 方法二
//		示例 1：
//		输入：nums = [4,6,7,7]
//		输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
		int[] nums = { 4, 6, 7, 7 };
		List<List<Integer>> findSubsequences = findSubsequences(nums);
		System.out.println(findSubsequences);

	}

	// 本题难点: 1.去重且元素无序，不能排序
	// 2.判断要添加的元素是否大于刚刚添加的元素

	// 定义全局变量 -用于收集结果集 和 单次结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> findSubsequences(int[] nums) {
		dfs(nums, 0);
		return result;
	}

	public static void dfs(int[] nums, int startIndex) {
		//收集结果 因为是获取各个节点上的组合
		if (path.size() >= 2) {
			result.add(new ArrayList<>(path));
		}
		//终止条件
		if (startIndex == nums.length) {
			return;
		}
		//定义map，用于去重操作
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		//横向遍历
		for (int i = startIndex; i < nums.length; i++) {
			//判断 当前要添加的元素必须要大于等于 上一个刚刚添加的元素 - 注:第一次不用判断
			if (!path.isEmpty() && nums[i] < path.getLast()) {
				continue;
			}
			//去重操作：判断 之前是否使用过该数字了(同层判断即可: 我这里每一层都new 了一个map就是用于同层的)
			if (hashMap.getOrDefault(nums[i], 0) >= 1) {
				continue;
			}
			//做标记
			hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
			//处理节点
			path.add(nums[i]);
			//递归: 纵向遍历
			dfs(nums, i + 1);
			//回溯：撤销处理结果
			path.removeLast(); //这里我没有撤销做标记就是因为我是同层判断的
			
		}

	}

}
