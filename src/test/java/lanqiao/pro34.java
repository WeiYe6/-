package lanqiao;

import java.util.Scanner;

public class pro34 {

	public static void main(String[] args) {
		//填充 - 考查 贪心和 动态规划
		//暴力搜索
		Scanner scanner = new Scanner(System.in);
//		char[] array = scanner.next().toCharArray();
//		int sum = 0;
//		for (int i = 0; i < array.length - 1; i++) {//注意遍历范围，不用索引越界了
//			if (array[i] == array[i + 1] || array[i] == '?' || array[i+1] == '?') {
//				sum++; //00 或者11  子串加1
//				i++; //跳到i+2的位置上继续判断
//			}
//		}
//		System.out.println(sum);
		
		
		
		
		//二维数组
		// 2： 二维数组的长度
		// 3： 一维数组的长度
		int[][] a = new int[2][3];
		int[][] b = {{1,1,1,},{2,2,2}};
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		scanner.close();
	}

}
