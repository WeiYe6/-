package 真题;

public class pro2 {

	// 定义全局变量 - 用于收集结果集
	static int count = 0;

	public static void main(String[] args) {
		// 题目： 与 或 异或 - dfs
		int[][] ans = new int[5][5];
		// 初始化
		ans[0][0] = 1;
		ans[0][1] = 0;
		ans[0][2] = 1;
		ans[0][3] = 0;
		ans[0][4] = 1;
		// 递归 - 把 and 和 当前位置传过去
		// 从第二行第一列开始放即可
		dfs(ans, 1, 0);
		System.out.println(count);
	}

	private static void dfs(int[][] ans, int i, int j) {
		//终止条件: 放置到最后一行
		if (i > 4) {
			if (ans[4][0] == 1) {//记录合法方式
				count++;
			}
			return;
		}
		
		//横向遍历（当前位置  | & ^  挨个尝试遍历）
		for (int n = 0; n < 3; n++) {
			if (n == 0) {       // 或
				ans[i][j] = ans[i-1][j] | ans[i-1][j+1];
			}else if (n == 1) { //与
				ans[i][j] = ans[i-1][j] & ans[i-1][j+1];
			}else {            //异或
				ans[i][j] = ans[i-1][j] ^ ans[i-1][j+1];
			}
			
			//递归：纵向遍历（把该行放满之后，移动到下一行）
			if (j == 4 - i) { //这个判断该行放满没
				//放置下一行
				dfs(ans, i+1, 0);
			}else {
				//本行继续放置
				dfs(ans, i, j + 1);
			}
		}
		
	}

}
