package lanqiao;

import java.util.Scanner;

public class pro39 {

	public static void main(String[] args) {
		// 单词分析: 字符串 - 暴力
		Scanner scanner  = new Scanner(System.in);
		String str = scanner.next();
		int[] arr = new int[26];//用来存储26个字母出现的次数
		for(int i = 0; i<str.length(); i++) {
			arr[str.charAt(i) - 'a']++; //利用 ASCLL表 字母从小到大的顺序特征
		}
		char ch = 'a'; //出现次数最多的字母,假设为第一个
		int max = 0; //出现最多的次数
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char)(i + 'a');
			}
		}
		System.out.println(ch);
		System.out.println(max);
		scanner.close();
	}

}
