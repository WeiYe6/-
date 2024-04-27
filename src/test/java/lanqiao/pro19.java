package lanqiao;

import java.util.Scanner;

public class pro19 {

	public static void main(String[] args) {
		// String、StringBuild的基础使用
		//题1： 给你一串字符串，统计数字字符的个数
//		Scanner scanner = new Scanner(System.in);
//		String string = scanner.next();
//		int count = 0;
//		for(char c: string.toCharArray()) {
//			int b = c-'0'; //转换成 int
//			if (b >= 0 && b<=9) {
//				count++;
//			}
//		}
//		System.out.println(count);
//		scanner.close();
		
		//题2：判断是不是回文字符串
		//方法一: 
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
//		int left = 0;
//		int right = string.length() - 1;
//		boolean flag = true;
//		while(left < right) {
//			if (string.charAt(left) != string.charAt(right)) {
//				flag = false;
//			}
//			left++;
//			right--;
//		}
//		if (flag) {
//			System.out.println("yes");
//		}else {
//			System.out.println("no");
//		}
		
		//方法二：
		StringBuilder stringBuilder = new StringBuilder(string);
		stringBuilder.reverse();
		if (string.equals(stringBuilder.toString())) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
	}

}
