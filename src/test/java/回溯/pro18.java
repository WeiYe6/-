package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro18 {

	public static void main(String[] args) {
		// 所有可能的路径 - dfs
//		给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
//		 graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。

//		输入：graph = [[1,2],[3],[3],[]]
//		输出：[[0,1,3],[0,2,3]]
//		解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
		int[][] graph = {{1,2},{3},{3},{}};
		List<List<Integer>> allPathsSourceTarget = allPathsSourceTarget(graph);
		System.out.println(allPathsSourceTarget);
	}

	// 定义全局变量-用于收集结果集 和 单次结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		path.add(0);// 每次手动添加 0节点
		dfs(graph, 0);// node -当前节点
		return result;
	}

	private static void dfs(int[][] graph, int node) {
		// 终止条件 - 当前节点 等于 n-1
		if (node == graph.length - 1) {
			// 收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		// 横向遍历 - 遍历每个节点对应可访问的节点列表
		for (int i = 0; i < graph[node].length; i++) {
			// 处理节点
			path.add(graph[node][i]);
			// 递归：纵向遍历
			dfs(graph, graph[node][i]);
			// 回溯：撤销处理结果
			path.removeLast();
		}

	}

}
