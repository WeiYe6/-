package 动态规划;

public class pro63 {

	public static void main(String[] args) {
		// 完全平方数 - 完全背包问题(动态规划)
//		题目: 完全平方数
//			给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//			完全平方数 是一个整数，其值等于另一个整数的平方；
//			换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//		示例 1：
//		输入：n = 12
//		输出：3 
//		解释：12 = 4 + 4 + 4
//		
//		示例 2：
//		输入：n = 13
//		输出：2
//		解释：13 = 4 + 9
		
		int n = 1;
		int numSquares = numSquares(n);
		System.out.println(numSquares);
	}
	
	//完全平方数可以重复利用，所以想到这一题是完全背包的题目
    public static int numSquares(int n) {
    	//动规五部曲
    	//1.dp数组含义: dp[j] -装满容量为j的背包所需要的最少完全平方数的个数为dp[j]
    	int[] dp = new int[n + 1];
    	//2.递推公式：求个数的常规公式为: dp[j] = Math.max/min(dp[j], dp[j-nums[i]] + 1)
    	//这题要求的是最少完全平法数的个数： dp[j] = Math.min(dp[j], dp[j - 当前个数的完全平方数] + 1)
    	//3.初始化 dp[0] 和 非0下标的， 0表示容量为0的背包所能装的物品个数为0了
    	//非0下标：因为我们要求的是最小值，所以应该初始化为max
    	int max = Integer.MAX_VALUE;
    	dp[0] = 0;
    	for(int i = 1; i < dp.length; i++) dp[i] = max;
    	//4.遍历顺序 这是一道完全背包的问题，且求的是个数，和排列组合不相关
    	//我们采用 先遍历物品，再（正序）遍历背包
    	//注意我们的物品就是一个个的完全平方数
    	for (int i = 1; i <= n; i++) { //物品
			int temp = i * i;
			for (int j = temp; j <= n; j++) {//背包
				//选取满足我们dp数组 定义的，等于max表示未装任何物品不满足我们的dp数组定义
				if(dp[j - temp] != max) {
					dp[j] = Math.min(dp[j], dp[j - temp] + 1);
				}
			}
		}
    	//这里很巧妙: 如果没有任何满足的组合，我们就返回n，因为n可以由n个1相加等到
    	//但其实上面我们也考虑n了，所以一般不会等于max的
    	//但是如果 n = 1时，我如果写的 i < n，则不会进入该循环，所以有两种方式
    	//1. i <= n
    	//2. return dp[n] == max ? n : dp[n];
    	return dp[n] ;
    }

}
