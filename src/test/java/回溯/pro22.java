package 回溯;

import java.util.ArrayDeque;
import java.util.Queue;

public class pro22 {

	public static void main(String[] args) {
		// bfs - 飞地的数量（广搜）
		int[][] grid = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		int numEnclaves = numEnclaves(grid);
		System.out.println(numEnclaves);
		
	}
	// 移动方向 上下左右
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, };

	public static int numEnclaves(int[][] grid) {
		//标记数组靠近岸边的陆地 -true  飞地为-false
		int rowLen = grid.length;
		int colLen = grid[0].length;
		boolean[][] mark = new boolean[rowLen][colLen];
		//定义一个队列，用于记录满足条件的陆地坐标
		Queue<int[]> queue = new ArrayDeque<>();
		//获取 左右边界 为1 的并添加进queuq中
		for (int row = 0; row < rowLen; row++) {
			//左边界
			if (grid[row][0] == 1 && mark[row][0] == false) {
				mark[row][0] = true; //做标记
				queue.add(new int[] {row, 0});
			}
			//右边界
			if (grid[row][colLen - 1] == 1 && mark[row][colLen - 1] == false) {
				mark[row][colLen - 1] = true;
				queue.add(new int[] {row, colLen - 1});
			}
		}
		//获取 上下边界 为1 的并添加进queuq中
		//00 已经 查找过了 col - 1 也已经查找过了（就是四个角不用重复添加），考试不记得就全写
		for (int col = 0; col < colLen; col++) {
			//上边界
			if (grid[0][col] == 1 && mark[0][col] == false) {
				mark[0][col] = true; //做标记
				queue.add(new int[] {0, col});
			}
			//下边界
			if (grid[rowLen-1][col] == 1 && mark[rowLen-1][col] == false) {
				mark[rowLen-1][col] = true;
				queue.add(new int[] {rowLen-1, col});
			}
		}
		//bfs
		bfs(grid, queue, mark);
		//收集结果
		int res = 0;
		//收集为1 且 mark为false的
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (grid[i][j] == 1 && mark[i][j] == false) {
					res++;
				}
			}
		}
		return res;
	}
	//bfs (广度优先收索，把可以到达边缘的陆地标记为true)
	private static void bfs(int[][] grid, Queue<int[]> queue, boolean[][] mark) {
		//队列不为空，一个一个取，一个一个判断
		 while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			//移动方向
			for (int[] di: dir) {
				int nx = cur[0] + di[0];
				int ny = cur[1] + di[1];
				//边界判断，越界跳过
				if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
					continue;
				}
				//合法性判断，不满足 为1，且mark为false，跳过
				if (grid[nx][ny] == 0 || mark[nx][ny] == true) {
					continue;
				}
				//做标记
				mark[nx][ny] = true;
				//添加该节点进队列中
				queue.add(new int[] {nx, ny});
			}
		}
	}
}
