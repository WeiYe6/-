package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro16 {

	public static void main(String[] args) {
		// N皇后
//		按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//		n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//		给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//		每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//		输入：n = 4
//		输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//		解释：如上图所示，4 皇后问题存在两个不同的解法。
//		
//		示例 2：
//		输入：n = 1
//		输出：[["Q"]]
		int n = 4;
		List<List<String>> solveNQueens = solveNQueens(n);
		System.out.println(solveNQueens);


	}

	// 定义全局变量-收集结果集
	static ArrayList<List<String>> result = new ArrayList<>();

	public static List<List<String>> solveNQueens(int n) {
		// 定义单次结果集 - 表示n*n的棋盘
		char[][] path = new char[n][n];
		// 填充为.(空)
		for (char[] c : path) {
			Arrays.fill(c, '.');
		}
		dfs(n, 0, path); // row：控制到第几行放置皇后
		return result;
	}

	public static void dfs(int n, int row, char[][] path) {
		// 终止条件 放置到最后一行
		if (row == n) {// 虽然 row == n-1时为最后一行，但是那一行我们还是要放置的，所以终止条件为 row == n
			// 收集结果
			result.add(resultList(path));
		}
		// 横向遍历: 放置的列
		for (int clo = 0; clo < n; clo++) {
			// 处理节点: 判断该行、该列能不能放置皇后
			if (check(n, row, clo, path)) {
				path[row][clo] = 'Q';
				// 递归：纵向遍历 : 移动到下一行
				dfs(n, row + 1, path);
				// 回溯；撤销处理结果
				path[row][clo] = '.';
			} else {
				continue;
			}
		}

	}

	// 判断该行、该列能不能放置皇后
	public static boolean check(int n, int row, int clo, char[][] path) {
		// 同一行不能放置皇后 我们的(row + 1) 已经控制了不会在同一行了，这个不需要判断

		// 同一列不能放置皇后
		for (int i = 0; i < row; i++) {
			if (path[i][clo] == 'Q') {
				return false;
			}
		}

		// 同一斜线不能放置皇后
		// 45度对角线（左上方）为什么不用检查左下方呢？ 因为我们是从上往下放置的，下边肯定没有啊
		for (int i = row - 1, j = clo - 1; i >= 0 && j >= 0; i--, j--) {
			if (path[i][j] == 'Q') {
				return false;
			}
		} 
		// 135度对角线 （右上方）为什么不用检查右下方呢？ 因为我们是从上往下放置的，下边肯定没有啊
		for (int i = row - 1, j = clo + 1; i >= 0 && j <= n-1; i--, j++) {
			if (path[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	// 把二维数组中各个 一维数组 的字符，转成字符串，并添加到集合中返回
	public static List<String> resultList(char[][] path) {
		ArrayList<String> resultArray = new ArrayList<>();
		for (char[] c : path) {
			resultArray.add(String.valueOf(c));
		}
		return resultArray;
	}

}
