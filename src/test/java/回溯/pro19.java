package 回溯;

public class pro19 {

	public static void main(String[] args) {
//		// 岛屿数量
//		给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//		岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//		此外，你可以假设该网格的四条边均被水包围。
//
//		示例 1：
//
//		输入：grid = [
//		  ["1","1","1","1","0"],
//		  ["1","1","0","1","0"],
//		  ["1","1","0","0","0"],
//		  ["0","0","0","0","0"]
//		]
//		输出：1
//		示例 2：
//
//		输入：grid = [
//		  ["1","1","0","0","0"],
//		  ["1","1","0","0","0"],
//		  ["0","0","1","0","0"],
//		  ["0","0","0","1","1"]
//		]
//		输出：3
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','1'}};
		int numIslands = numIslands(grid);
		System.out.println(numIslands);

	}

	// 思想: dfs-找到一块陆地之后，记录下来，并且利用dfs把与这块陆地相邻的所有陆地进行“水淹”，放置重复计算岛屿数量，
	// 那边（上下左右）遇到边界 或者 水 就停止该方向的水淹。
	public static int numIslands(char[][] grid) {
		// 找陆地
		int res = 0;
		for (int i = 0; i < grid.length; i++) {// 有多少行
			for (int j = 0; j < grid[0].length; j++) {// 有多少列
				if (grid[i][j] == '1') {// 找到一块陆地
					res++;
					// 把该相邻的陆地"水淹"
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	private static void dfs(char[][] grid, int i, int j) {
		// 终止条件
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		// 把该陆地的上下左右陆地进行水淹
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

}
