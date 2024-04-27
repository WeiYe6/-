package lanqiao;

import java.util.Scanner;

public class pro38 {

	public static void main(String[] args) {
		// 成绩统计 —- 模拟 暴力
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ge = 0;
		int yu = 0;
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			if (a >= 60) {
				ge++;
				if (a >= 85) {
					yu++;
				}
			}
		}
		//int特点: 向下取整，这里加0.5的作用。如果是  0.5 - 0.9 我们是要四舍五入进一的
		//但是 int 只会向下取整，所以我们加 0.5 就保证在 0.5 - 0.9时 进一了。
		//注意: 取百分数是要乘以100的，我们除以100.0的目的就是把int转成 double
		int res1 = (int) ( yu*100.0 / n + 0.5);
		int res2 = (int) ( ge*100.0 / n + 0.5);
		System.out.println(res2+"%");
		System.out.println(res1+"%");
		scanner.close();
	}

}
