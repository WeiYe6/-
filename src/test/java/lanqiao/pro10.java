package lanqiao;

import java.util.Scanner;

public class pro10 {

	public static void main(String[] args) {
		// 打基础2
		// int 范围 1e9
		// long 范围 1e18
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextInt();
		while (n > 0) {
			System.out.print(n + " ");
			n /= 2;
		}
		scanner.close();
	}
}
