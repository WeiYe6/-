package 回溯;

public class pro21 {

	public static void main(String[] args) {
		// dfs - 飞地的数量 （深搜）
		int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int numEnclaves = numEnclaves(grid);
		System.out.println(numEnclaves);
	}

	// 移动方向 上下左右
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, };

	public static int numEnclaves(int[][] grid) {
		// 标记数组 - true(靠岸边的) - false（飞地）
		int rowLen = grid.length;
		int colLen = grid[0].length;
		boolean[][] mark = new boolean[rowLen][colLen];
		// 左右边界-dfs
		for (int row = 0; row < rowLen; row++) {
			// 左边界查找1的 和 标记为false的
			if (grid[row][0] == 1 && mark[row][0] == false) {
				// 做标记
				mark[row][0] = true;
				dfs(row, 0, grid, mark);
			}
			// 右边界查找1的 和 标记为false的
			if (grid[row][colLen - 1] == 1 && mark[row][colLen - 1] == false) {
				// 做标记
				mark[row][colLen - 1] = true;
				dfs(row, colLen - 1, grid, mark);
			}
		}

		// 上下边界-dfs -从1开始找即可,0找过了
		for (int col = 1; col < colLen; col++) {
			// 上边界查找1的 和 标记为false的
			if (grid[0][col] == 1 && mark[0][col] == false) {
				// 做标记
				mark[0][col] = true;
				dfs(0, col, grid, mark);
			}
			// 下边界查找1的 和 标记为false的
			if (grid[rowLen - 1][col] == 1 && mark[rowLen - 1][col] == false) {
				// 做标记
				mark[rowLen - 1][col] = true;
				dfs(rowLen - 1, col, grid, mark);
			}
		}
		// 获取结果
		int res = 0;
		// 遍历剩余为1的个数，就是飞地的数量了
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (grid[i][j] == 1 && mark[i][j] == false) {
					res++;
				}
			}
		}
		return res;
	}

	private static void dfs(int row, int clo, int[][] grid, boolean[][] mark) {
		// 移动
		for (int[] di : dir) {
			int nrow = row + di[0];
			int ncol = clo + di[1];
			// 终止条件 -边界判断
			if (nrow < 0 || nrow >= grid.length || ncol < 0 || ncol >= grid[0].length) {
				continue; //不能break,不然走了上，就其它方位还没走过，就被提前结束了
			}
			//合理性判断 -当前位置为true 或者 grid 为0,  跳过
			if (mark[nrow][ncol] == true || grid[nrow][ncol] == 0) {
				continue;
			}
			//做标记
			mark[nrow][ncol] = true;
			dfs(nrow, ncol, grid, mark);
		}
	}
}
