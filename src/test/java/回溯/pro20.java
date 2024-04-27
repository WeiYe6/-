package 回溯;

public class pro20 {

	public static void main(String[] args) {
		// 岛屿的最大面积
//		给你一个大小为 m x n 的二进制矩阵 grid 。
//		岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
//		你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//		岛屿的面积是岛上值为 1 的单元格的数目。
//		计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
//				示例1：
//				输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
//		           [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
//		           [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
//		           [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//				输出：6
//				解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//				
//				示例 2：
//				输入：grid = [[0,0,0,0,0,0,0,0]]
//				输出：0
	}

	// 定义全局变量
	// 控制上下左右方向的数组
	static int[][] dir = {
			{ 0, 1 }, // 右
			{ 1, 0 }, // 下
			{ 0, -1 }, // 左
			{ -1, 0 }// 上
	};
	static boolean[][] visited;// 做标记，加过的标记为true
	static int count; // 统计每块岛屿的数量

	public static int maxAreaOfIsland(int[][] grid) {
		visited = new boolean[grid.length][grid[0].length];
		// 定义结果
		int res = 0;
		for (int i = 0; i < grid.length; i++) {// 有多少行
			for (int j = 0; j < grid[0].length; j++) {// 有多少列
				if (grid[i][j] == 1 && visited[i][j] == false) {
					count = 0;// 找每一块的岛屿陆地数量
					dfs(grid, i, j);
					res = Math.max(res, count);// 记录最大值
				}
			}
		}
		return res;
	}

	private static void dfs(int[][] grid, int x, int y) {
		// 终止条件
		if (grid[x][y] == 0 || visited[x][y] == true) {
			return;
		}
		count++;
		visited[x][y] = true;
		// 统计连接该岛屿上下左右的陆地
		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			// 终止条件
			if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
				continue;
			}
			dfs(grid, nextX, nextY);
		}
	}

}
