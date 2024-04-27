package 动态规划;

public class pro51 {

	public static void main(String[] args) {

		// 示例
		// 输入： m = 2 n = 3
		// 输出：3
		// 1. 右 -> 右 ->下
		// 2.右 -> 下 ->右
		// 3.下 -> 右 ->右
		int m = 2, n = 3;
		int fn1 = fn1(m, n);
		System.out.println(fn1);

		
		
		// 示例:
		// 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//		输出：2 
		// 解释：
//		3x3 网格的正中间有一个障碍物。
//		从左上角到右下角一共有 2 条不同的路径：
//		向右 -> 向右 -> 向下 -> 向下
//		向下 -> 向下 -> 向右 -> 向右
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int fn2 = fn2(obstacleGrid);
		System.out.println(fn2);
		

	}

	// 2.不同路径2 - 动态规划
//	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//	现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	public static int fn2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// dp[i][j] : 在有障碍的情况下 从(0,0)到(i,j)有几种不同的路径
		int[][] dp = new int[m][n];
		// 递推公式: 现在多了障碍物,如果我们要到达的该位置就是障碍物，dp[i][j]置为0
		// dp[i][j] = obstacleGrid[i][j] == 0? dp[i-1][j] + dp[i][j-1]:0;

		// 如果，开始和结束位置有障碍物，则结果返回0
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}

	//初始化，还是初始第一行 和 第一列，但是如果第一行在某个位置上有障碍物，那么该位置和后面的都置为0，列同理。
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
			dp[i][0] = 1;
		for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++)
			dp[0][j] = 1;

		// 遍历顺序，依靠前面的状态值，正序
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
			}
		}
		return dp[m - 1][n - 1];

	}

	// 1.不同路径1 - 动态规划
//	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//	问总共有多少条不同的路径？
	public static int fn1(int m, int n) {
		// 1.dp数组含义: dp[i][j]是从(0,0) 来到 (i,j)这个位置时有几种路径
		int[][] dp = new int[m][n];
		// 2.确定递推公式，只能向右和向下
		// dp[i][j] = dp[i-1][j] + dp[i][j-1]

		// 3.dp[][]初始化, 在第一行时，只能向右，所以 dp[0][j] = 1;
		// 在第一列时，只能向下,所以 dp[i][0] =1;
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int j = 0; j < n; j++)
			dp[0][j] = 1;

		// 4.确定遍历顺序，因为当前位置是需要它的左边状态 和 上边状态的所以 正序遍历
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

}
