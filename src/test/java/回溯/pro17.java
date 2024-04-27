package 回溯;

public class pro17 {

	public static void main(String[] args) {
		// 解数独
//		编写一个程序，通过填充空格来解决数独问题。
//
//		数独的解法需 遵循如下规则：
//		数字 1-9 在每一行只能出现一次。
//		数字 1-9 在每一列只能出现一次。
//		数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//		数独部分空格内已填入了数字，空白格用 '.' 表示
		
	}

	public static void solveSudoku(char[][] board) {
		dfs(board);
	}

	private static boolean dfs(char[][] board) {
		// 该题不需要终止条件，找到一个答案后直接返回
		// 一个for循环遍历棋盘的行，一个for循环遍历棋盘的列
		// 一行一列确定下来之后，递归遍历这个位置方1-9个数字的可能性
		for (int i = 0; i < 9; i++) {// 遍历行
			for (int j = 0; j < 9; j++) {// 遍历列
				if (board[i][j] != '.') {// 非空，跳过
					continue;
				}
				for (char k = '1'; k <= '9'; k++) {// 放置数字
					// 检查合法性
					if (check(i, j, k, board)) {
						// 能放置
						board[i][j] = k;
						// 递归
						boolean result = dfs(board);
						if (result) {// 如果找到一组符合就立刻返回
							return true;
						}
						// 回溯
						board[i][j] = '.';
					}

				}
				// 9个数都试完了，还是不行，直接返回false（无答案）
				return false;
			}
		}
		// 遍历结束，一直没有进入到false，那我们直接返回true
		return true;

	}

	// 检查合法性
	// 1.同行是否重复
	// 2.同列是否重复
	// 3.9宫格是否重复
	private static boolean check(int row, int col, int val, char[][] board) {
		// 1.同行是否重复
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val) {
				return false;
			}
		}
		// 2.同列是否重复
		for (int j = 0; j < 9; j++) {
			if (board[j][col] == val) {
				return false;
			}
		}
		// 3.9宫格是否重复
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (board[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}

}
