package lanqiao;

import java.time.Year;
import java.util.Calendar;
import java.util.Iterator;

public class pro3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 跳格子-简单递归 dfs
		// 振兴中华
		int count = f(0, 0); // 从0.0 开始走
		System.out.println(count); // 35种

		// -----------------------
		// 简单动态规划
		// 动态规划最核心的思想，就在于拆分子问题，记住过往，减少重复计算。
		int[][] arr = new int[4][5];

		// 只能向下 或向右移动
		// 给左边界初始化为1，只要到达该边界就只有一种走法了
		for (int i = 0; i < 4; i++) {
			arr[i][0] = 1;
		}
		// 给上边界初始化为1，只要到达该边界就只有一种走法了
		for (int j = 0; j < 5; j++) {
			arr[0][j] = 1;
		}

		// 大问题拆解成小问题来解决
		// 除去边界---记录走到当前位置，一共有几种走法
		for (int y = 1; y < 5; y++) {
			for (int x = 1; x < 4; x++) {
				// 只能向下 或者向右走
				arr[x][y] = arr[x - 1][y] + arr[x][y - 1];
			}
		}

		System.out.println(arr[3][4]); //35种
	}

	// 递归
	// 1、出口
	// 2、找重复
	private static int f(int x, int y) {
		// 出口
		if (x == 3 || y == 4) {
			return 1; // 当走到最下边 或者 最右边时就只有一种走法了
		}
		return f(x + 1, y) + f(x, y + 1);// 只能向下 或者 向右移动，不能往回移动
	}

}
