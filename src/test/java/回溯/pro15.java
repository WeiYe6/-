package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class pro15 {

	public static void main(String[] args) {
		// 全排列 II
//		给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//		示例 1：
//		输入：nums = [1,1,2]
//		输出：
//		[[1,1,2],
//		 [1,2,1],
//		 [2,1,1]]
//				 
//		示例 2：
//		输入：nums = [1,2,3]
//		输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		int[] nums = {1,1,2};
		List<List<Integer>> permuteUnique = permuteUnique(nums);
		System.out.println(permuteUnique);

	}

	//区别: - 有重复元素 - 既要实现树枝去重，又要实现树层去重
	//定义全局变量 -收集结果集 和单次结果
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	static boolean[] used; //标记数组-去重
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0) {
			return result;
		}
		//Arrays.sort(nums);//排序
		used = new boolean[nums.length];
		dfs(nums);
		return result;
	}
	
	public static void dfs(int[] nums) {
		//终止条件
		if (path.size() == nums.length) {
			//收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		//横向遍历: 注意同层可以取过之前取过的元素所以: i = 0开始
		//HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();//层去重
		for (int i = 0; i < nums.length; i++) {
			//去重操作
			//树枝去重 (已经使用过的元素不能再次使用)
			if (used[i] == true) {
				continue;
			}
			//树层去重 (排好序: 当前元素和前一个刚刚使用过的元素相等，则不需要取)
//			if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
//				continue;
//			}
			//树层去重方法二: 获取到的value不是0,说明之前出现过
//			if (hashMap.getOrDefault(nums[i], 0) >= 1) {
//				continue;
//			}
			//树层去重方法三: 
			if (hashSet.contains(nums[i])) {
				continue;
			}
			
			//处理节点
			//hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);//map记录同层使用过的元素
			hashSet.add(nums[i]);
			path.add(nums[i]);
			used[i] = true;
			//递归：纵向遍历
			dfs(nums);
			//回溯：撤销处理结果
			path.removeLast();
			used[i] = false;
		}
		
	} 

}
