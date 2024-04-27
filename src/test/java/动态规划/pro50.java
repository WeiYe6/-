package 动态规划;

public class pro50 {

	public static void main(String[] args) {
		// 使用最小花费爬楼梯 - 动态规划
		//cost = [1,100,1,1,1,100,1,1,100,1]
		//输出：6
		
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		int fn1 = fn1(cost);
		System.out.println(fn1);

	}
	
	//cost[i]: 从第i个台阶向上爬需要支付的费用，一旦你支付此费用，即可选择向上爬一个或者两个台阶
	//你可以选择从下标为0 或者 下标为1的台阶开始爬楼梯
	//计算到达楼梯顶部的最低花费
	public static int fn1(int cost[]) {
		//1.dp[i]的含义: 表示到达第i阶楼层所需要支付的最少费用
		int len = cost.length;
		int[] dp = new int[len+1];//需要到达 第i阶
		
		//2.确定递推公式
		//dp[i] = min(dp[i-1] + cost[i-1] + dp[i-2] + cost[i-2])
		
		//3.初始化dp[]
		//读题意； 可以选择从下标为0 或者下标为1的台阶开始，所以跳到0或者1是不需要花费的,向上才需要
		dp[0] = 0;
		dp[1] = 0;
		
		//遍历顺序: 正序，因为需要前面的状态
		for(int i =2; i<= len; i++) {
			dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
		}
		return dp[len];
	}

}
