package 动态规划;

public class pro57 {

	public static void main(String[] args) {
		// 一和零: - 动态规划
		// 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
		// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
		// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
		// 示例:
//		输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//		输出：4
//		解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//		其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
		String[] strs = {"10", "0001", "111001", "1", "0"};
		int m = 5;
		int n = 3;
		int findMaxForm = findMaxForm(strs, m, n);
		System.out.println(findMaxForm);

	}

	public static int findMaxForm(String[] strs, int m, int n) {
		//1.dp数组含义: dp[m][n]： 在容量为m 和 n的背包下，最多装的物品个数
		int[][] dp = new int[m+1][n+1];
		//2.递推公式:  常规: dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i])
		//因为此题我们要求的是物品的个数
		//dp[i][j]：讨论: 第i个物品能装下？ i 的 x = 0, y = 1,是否满足 x <= m 且 y<=n, 
		//取最大值，max里面为什么是 dp[i][j]呢？因为这里我们使用的是滚动数组来解决的，
		//dp[i][j]： 就是上一个状态值，且在该轮中又不断更新覆盖，我们要的就是 本轮 最大值即可。
		//满足则装得下 dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y] + 1)  
		//3.初始化: dp[0][0] 容量背包为0，那么装的物品个数就是0了
		dp[0][0] = 0;
		//4.遍历顺序，先遍历物品 后逆序遍历背包
		for (int i = 0; i < strs.length; i++) {
			int x = 0;//0的个数
			int y = 0;//1的个数
			for(char c: strs[i].toCharArray()) {
				if(c == '0') x++;
				if(c == '1') y++;
			}
			for(int j = m; j >= x; j--) {
				for (int k = n; k >= y; k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j-x][k-y] + 1);
				}
			}
		}
		
		//5.打印数组 验证
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[m][n];
	}

}
