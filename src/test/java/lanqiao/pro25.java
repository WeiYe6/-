package lanqiao;

import java.util.Scanner;

public class pro25 {
	//求两个数的最大公约数 和 最小公倍数
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		//保存n和m
		int x = n, y = m;
		int temp = 0;
		//始终保持 m > n
		if (m < n) {
			temp = n;
			n = m;
			m = temp;
		}
		while(m % n != 0) { //辗转相除法
			temp = m % n;
			m = n;
			n = temp;
		}
		System.out.println("最大公约数:" + n);
		System.out.println("最小公倍数:" + x*y/n);
	}
	
	
	//方法二:
	//先求最大公约数
	public static int gcd(int a, int b) {
		return b != 0 ? gcd(b, a%b):a;
	}
	//再求最小公倍数
	public static int gl(int a, int b) {
		return a*b / gcd(a, b);
	}
}
