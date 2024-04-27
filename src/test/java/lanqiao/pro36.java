package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class pro36 {

	public static void main(String[] args) {
		// 题目:平均 - 考察 （排序 和 贪心）
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); 
		int[][] arr = new int[10][n];// 二维数组长度，以及一位数组的最大长度
		int k = n / 10; //每个数需要出现的次数：比如 n = 10,则（0-9）每个数需要出现一次
		int[] index  = new int[10]; //作用1：充当指针，作用2：记录（0-9）每个数出现的次数
		for(int i = 0; i < n; i++) {//将输入的值，存储进对应的二维数组中
			int a = scanner.nextInt();//应该存储进二维数组中的那个一位数组
			//巧妙: 每个二维数组中对应的一维数组，存储的是每个数值的代价，
			//index[a]:即充当了指针，还记录了每个数出现的次数
			arr[a][index[a]++] = scanner.nextInt();
		}
		int sum = 0;//累积代价和
		//贪心: 局部最优解，是不是修改同一个数字中代价最小的 前几个啊，保留需要出现的次数即可
		for(int i = 0; i < 10; i++) {
			//对二维数组中的每个一维数组进行 从小到大 的排序，
			//0：从第几个索引开始排序，index[i]: 需要排序到多长结束
			Arrays.sort(arr[i], 0, index[i]);
			//index[i] - k: 如果出现的次数 大于 需要出现的次数，则把大于的前几个数字的代价和 累加起来。
			for(int j = 0; j < index[i] - k; j++) {
				sum += arr[i][j];
			}
		}
		
		System.out.println(sum);
		scanner.close();
	}

}
