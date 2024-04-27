package lanqiao;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class pro17 {

	public static void main(String[] args) {
		// 队列 基础
		//围圈问题
		// n:圈中人数   k:数数-出圈的次序
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		//数数出圈
		int count = 0;
		while(!queue.isEmpty()) {
			int i = queue.poll();
			count++;
			if (count == k) { //出圈
				System.out.println(i + " ");
				count = 0;
			}else {
				//还未到,添加回队尾中，继续数数
				queue.add(i);
			}
		}
		scanner.close();

	}

}
