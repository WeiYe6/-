package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro1 {

	public static void main(String[] args) {
		// 组合
//		给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//		你可以按 任何顺序 返回答案。
//		示例 1：
//		输入：n = 4, k = 2
//		输出：
//		[
//		  [2,4],
//		  [3,4],
//		  [2,3],
//		  [1,2],
//		  [1,3],
//		  [1,4],
//		]
//		示例 2：
//		输入：n = 1, k = 1
//		输出：[[1]]
		
		int n = 4;
		int k = 2;
		List<List<Integer>> combine = combine(n, k);
		System.out.println(combine);
	
	}

//	回溯算法模板:
//		void backtracking(参数) {
//		    if (终止条件) {
//		        存放结果;
//		        return;
//		    }
//
//		    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
//		        处理节点;
//		        backtracking(路径，选择列表); // 递归
//		        回溯，撤销处理结果
//		    }
//		}
	
	
	//定义两个全局变量
	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	public static List<List<Integer>> combine(int n, int k) {
		dfs(n, k, 1);
		return result;
	}
	
	public static void dfs(int n, int k, int startIndex) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = startIndex; i <= n; i++) { //控制树的横向遍历
			path.add(i); //处理节点
			dfs(n, k, i+1); //递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
			path.removeLast();//回溯，撤销处理的节点
		}
	}

}
