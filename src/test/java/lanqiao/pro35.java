package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class pro35 {

	public static void main(String[] args) {
		// 平均 - 排序 和 贪心
		//打草稿 - 对一、二维数组的概念以及 排序加深熟练
		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int[][] arr = new int[n][n];
//		for(int i = 0; i<n; i++) {
//			int a = scanner.nextInt();
//			int b = scanner.nextInt();
//		}
//		int[][] arr2 = new int[3][2];
//		System.out.println(arr2[0]++); //前++: 先算再加 、后++ : 先加在算
									  //未初始化时，数组默认等于0。
//		System.out.println(arr2[0]);
//		System.out.println(++arr2[1]);
		
        int[][] arr2 = new int[3][2];
        arr2[0][0] = 9;
        arr2[0][1] = 1;
        arr2[1][0] = 2;
        arr2[1][1] = 3;
        arr2[2][0] = 4;
        arr2[2][1] = 5;
        for(int i = 0; i < 3; i++) {
            Arrays.sort(arr2[i], 0, 2); //对二维数组中的每个一位数组进行排序（从小到大）
        }
        for(int i = 0; i < 3; i++){
            for (int j =0; j < 2; j++){
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
		scanner.close();
	}

}
