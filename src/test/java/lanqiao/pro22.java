package lanqiao;

import java.util.Scanner;

public class pro22 {

	public static void main(String[] args) {
		// 模拟题 -- 打基础（据题意来写代码）
		// 1--n，中，获取包含 0，1，2，9数的和
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long res = 0;
		for (int i = 1; i <= n; i++) {
			//转成字符串来判断
			String s = i +"";
			if (s.contains("0") || s.contains("1") || s.contains("2") || s.contains("9")) {
				res += i;
			}
		}
		System.out.println(res);
		
	}

}
