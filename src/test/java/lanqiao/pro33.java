package lanqiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pro33 {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		// 在此输入您的代码...
//		int n = scan.nextInt();
//		int[] a = new int[n]; // 事件对x的影响
//		int[] b = new int[n]; // 事件对y的影响
//		int[] c = new int[n]; // 事件对z的影响
//		for (int i = 0; i < n; i++) {
//			a[i] = scan.nextInt(); // 赋值 xi
//		}
//		for (int i = 0; i < n; i++) {// 赋值 yi
//			b[i] = scan.nextInt();
//		}
//		for (int i = 0; i < n; i++) {// 赋值 zi
//			c[i] = scan.nextInt();
//		}
//		scan.close();
//
//		for (int i = 0; i < n; i++) {
//			int x = a[i];
//			int y = b[i];
//			int z = c[i];
//			a[i] = x - y - z; // 对x国的优劣势
//			b[i] = y - x - z; // 对y国的优劣势
//			c[i] = z - y - x; // 对z国的优劣势
//		}
//		// 对优劣势进行排序，从小到大（从大到小不行 - 因为我们的是 int 基本类型,需要自定义比较器 麻烦）
//		Arrays.sort(a);
//		Arrays.sort(b);
//		Arrays.sort(c);
//		int count = -1; // 存储最大事件数，因为没有任何国家获胜时返回-1
//		long sum1 = 0;
//		long sum2 = 0;
//		long sum3 = 0;
//		for (int i = n - 1; i >= 0; i--) { // 因为是从小到大，所以需要反序遍历，先从优势最大的开始
//			sum1 += a[i];
//			sum2 += b[i];
//			sum3 += c[i];
//			if (sum1 > 0 || sum2 > 0 || sum3 > 0) {//如果某个国家的优势大于0 ---即大于另外两个国家的优势和
//				//更新事件数
//				count = n - i; //执行了多少次循环，表示执行了多少事件数
//				
//			}
//		}
//		System.out.println(count);
		test2();
	}

	// 贪心算法的理解 以及例题
	public static void test2() {
		// 贪心算法: 局部最优解
		// 题目； 移动最少方块，使得不重叠 eg ； [1,2] [1,3] [2,4] ，答案: 1 (移除 [1,3]方块)
		int[][] move = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		// 这题核心: 按照木块的末端进行 从小到大 排序， 移除掉后一个木块的首端 大于 前一个木块末端的模块
		Arrays.sort(move, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; // 按照末端从小到大进行排序
			}
		});
		// 默认第一块是满足条件的
		int count = 1;
		int pre = move[0][1]; //保存第一个木块的 末端
		for (int i = 1; i < move.length; i++) {
			if (pre <= move[i][0]) {
				count++;// 满足不覆盖的木块数
				pre = move[i][1]; //更新木块的末端
			}
		}
		// 移除最小的木块数等于
		System.out.println(move.length - count);
	}

}
