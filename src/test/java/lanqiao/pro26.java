package lanqiao;

public class pro26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//动态规划
		//核心：找规律、大化小
		//求 1-2021的最短路径
		//例子： 1-23
		// 1-23 == 1-2-21 = 48
		// 2 + 2-21(的路径) = 前面的路径 + 当前数 和 (当前数+21)的路径
		//1-2021  === 前面的路径 + 2020 - 2021
		//       ==== 前面的路径 + 2019 - 2020
		//问题: 我们要求的是 1 - 2021的最短路径，那不一定都是相差21，的就是最短路径
		// 错误原因: 思想狭窄的认为 相差 21 那个就一定是最短的（两边之和大于第三边的误导）
		//我们需要进行判断（1--22），获取1和 2、3、4、5....到22之间最短的路径来进行判断，判断那个才是
		//最短路径-- 动态规划
		int sum = 0;
		int n = 1;
		for(int i = 22; i<= 2021; i+=21) {
			//求两数的最小公倍数
			sum += dp(n, i);
			n = i;
			
		}
		System.out.println(sum);
	}
	
	//求两数的最小公倍数   m一直大于n
	public static int dp(int n, int m) {
		int x = n, y = m;
		int temp = 0;
		while(m % n != 0) {
			temp = m % n;
			m = n;
			n = temp;
		}
		return x*y/n;
	}

}
