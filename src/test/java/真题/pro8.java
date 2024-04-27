package 真题;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class pro8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 在此输入您的代码...
		int n = scan.nextInt(); // n行
		int m = scan.nextInt(); // m列
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		// 方位移动 -上下左右 左上 右上 左下 右下
		int[][] dir = { { -1, 0 }, // 上
				{ 1, 0 }, // 下
				{ 0, -1 }, // 左
				{ 0, 1 }, // 右
				{ -1, -1 }, // 左上
				{ -1, 1 }, // 右上
				{ 1, -1 }, // 左下
				{ 1, 1 } // 右下
		};

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 1) {// 不是地雷，便统计周围的地雷数，并打印出来
					int count = 0;
					for (int[] di : dir) {
						int nx = i + di[0];
						int ny = j + di[1];
						// 边界判断,以及统计炸弹
						if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) {
							count++;
						}
					}
					System.out.print(count + " ");
				} else {
					System.out.print(9 + " ");
				}
			}
			System.out.println();
		}
		scan.close();
	}
}