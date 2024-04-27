package lanqiao;

import java.util.Scanner;

public class pro11 {

	public static void main(String[] args) {
		// 打基础3
		Scanner scanner = new Scanner(System.in);
		char[] charArray = scanner.next().toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= '1' && charArray[i] <= '9') { //为数字时
				int n =charArray[i] - '0'; //转换成数字
				for (int j = 0; j < n - 1; j++) {//重复添加前一个字符 n-1 次
					stringBuilder.append(charArray[i -1]);
				}
			}else {
				stringBuilder.append(charArray[i]);
			}
		}
		System.out.println(stringBuilder.toString());
	}

}
