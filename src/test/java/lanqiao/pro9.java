package lanqiao;

import java.util.Scanner;

public class pro9 {

	public static void main(String[] args) {
		// 打基础1
		Scanner scanner = new Scanner(System.in);
		int min = 0;//最小值
		int max = 100; //最大值
		int n = scanner.nextInt();
		double sum = 0;
		for (int i = 0; i < n; i++) {
			int m = scanner.nextInt();
			max = Math.max(m, min);
			min = Math.min(m, max);
			sum +=m;
		}
		sum /= n;
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f", sum);

	}

}
