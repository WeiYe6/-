package lanqiao;

public class pro23 {

	public static void main(String[] args) {
		// 前缀和 --- 打基础
		//比如 要求我们求 任意区间的数组和 [l, r]
		//我们原本是要for遍历来的，比如有n个，要相加m次
		//时间复杂度为: n * m
		//利用前缀和，sum[n+1] 保存每个前缀和
		int n = 10;
		int[] a1 = new int[n];
		long[] sum = new long[n+1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i -1] + a1[i - 1];
		}
		//比如要求 [5 - 9] 数组下标 -- 的区间和就是
		long res = sum[10] - sum[5];
	}

}
