package 真题;

import java.util.Scanner;

public class pro10 {

	public static void main(String[] args) {
		// 纸张尺寸 - 模拟
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();// 传的A0、A1.....A9
		// 获取后面的数字，根据数字的大小来进行遍历的次数即可
		char a = s.charAt(1);
		int h = 1189;
		int w = 841;
		for (char i = '0'; i < a; i++) {
			h = h / 2; // 看传来的是A几，就遍历几次
			if (h < w) { // 一直取最长的
				int temp = w;
				w = h;
				h = temp;
			}
		}
		System.out.println(h);
		System.out.println(w);
		scan.close();
	}

}
