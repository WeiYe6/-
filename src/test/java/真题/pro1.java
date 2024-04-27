package 真题;

import java.util.ArrayList;
import java.util.Scanner;

public class pro1 {
	// 定义全局变量
	static int n; // n*n方格
	static int[] bei;// 北边箭靶
	static int[] xi; // 西边箭靶
	static int[][] dir = { // 上下左右的移动方向
			{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] mark;// 标记数组
	static ArrayList<Integer> lujing = new ArrayList<>();

	public static void main(String[] args) {
		//题目 路径之谜 - dfs
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		bei = new int[n];
		xi = new int[n];
		mark = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			bei[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			xi[i] = scanner.nextInt();
		}
		scanner.close();

		// 从(0,0) 走到( n-1,n-1)
		// 做标记，且减少对应箭靶的数量
		// 因为(0,0)我们是必须要走的，先做标记
		mark[0][0] = true;
		bei[0] -= 1;
		xi[0] -= 1;
		lujing.add(0);
		dfs(0, 0); // 把(x,y)当前坐标传过去，并不断移动 和 判断坐标的合法性
	}

	private static void dfs(int x, int y) {
		// x - 向右边的（北箭靶）， y - 向下边的（西箭靶）
		// 终止条件 -走到终点了
		if (x == n - 1 && y == n - 1) {
			// 检查，西北箭靶是否全为空
			for (int i = 0; i < n; i++) {
				if (xi[i] != 0 || bei[i] != 0) {
					return;// 不满足，直接返回
				}
			}
			// 收集结果
			for (int lj : lujing) {
				System.out.print(lj + " ");
			}
		}

		// 移动方向（上下左右）
		for (int i = 0; i < 4; i++) {
			//保存当前坐标，用于回溯时不改变原来的坐标
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];
			// 处理节点
			// 检查 该方向的合理性
			if (check(nextX, nextY)) {
				// 合理
				bei[nextX] -= 1;
				xi[nextY] -= 1;
				mark[nextX][nextY] = true;
				lujing.add(nextX + nextY * n);//把路径加上去
				// 递归
				dfs(nextX, nextY);
				// 回溯
				lujing.remove(lujing.size() - 1);
				bei[nextX] += 1;
				xi[nextY] += 1;
				mark[nextX][nextY] = false;
			}
		}

	}

	// 检查(x,y)坐标的合理性
	private static boolean check(int x, int y) {
		// 1.边界检查 或者 走过的方格不能再次走
		if (x < 0 || y < 0 || x > n - 1 || y > n - 1 || mark[x][y] == true) {
			return false;
		}
		// 2.对应（x,y）北箭靶 - 西箭靶的检查
		// 如果走该位置，对应的箭靶数减1，判断箭靶数的数量是否合法，就是必须 大于等于0
		if (bei[x] - 1 < 0 || xi[y] - 1 < 0) {
			return false;
		}
		return true;
	}
}
