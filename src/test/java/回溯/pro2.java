package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro2 {

	public static void main(String[] args) {
		// 组合
		int n = 4;
		int k = 2;
		List<List<Integer>> combine = combine(n, k);
		System.out.println(combine);
	}

	public static List<List<Integer>> combine(int n, int k) {
		dfs(n, k, 1);
		return result;
	}

	// 定义两个全局变量，用来存放结果集 和 单次递归结果集
	static ArrayList<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	// 深搜 / 回溯
	// 参数: 组合问题,取过的数字不需要重复取，用index 来表示下一次的递归 从那个数字开始
	public static void dfs(int n, int k, int startIndex) {
		// 终止条件（单次递归结束）
		if (path.size() == k) {
			// 收集结果
			result.add(new ArrayList<>(path));
			return;
		}
		// 控制树的横向遍历
		
		// 优化 - 剪枝操作：减少一些不必要的递归次数
		// 比如: n = 4, k = 3, 那么 1(234) 2(34) 3(4) 4,可以看到最大的起始位置应该是2，
		// 3和4已经没必要了,因为不可能组成k个数了 ,把这些不必要的操作剪去，就是我们的剪枝操作了。
		// 取了：path.size() 个数，还需要取 k - (path.size()) 个数
		// 看剩余的数有那些还满足k个数的: n - (k-path.size()) + 1
		// 为什么 +1,因为我们是左闭右闭区间，举个例子 
		// path.size = 0,  k - path.size = 3
		// 4 - 3 + 1 == 2, 这个2，就是我们需要的最大的结束数字了，大于2的都是不满足k个数的
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			dfs(n, k, i + 1);// 递归，控制树的纵向遍历，注意: i + 1
			path.removeLast();// 回溯，撤销处理结果（恢复现场）
		}

	}

}
