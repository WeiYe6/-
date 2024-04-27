package lanqiao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class pro18 {

	public static void main(String[] args) {
		// 排序库的使用
//		Integer[] arr = { 1, 3, 5, 2 };
//		Arrays.sort(arr, (o1, o2) -> o1 - o2);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		//集合
//		ArrayList<Integer> arrayList = new ArrayList<>();
//		arrayList.add(1);
//		arrayList.add(3);
//		arrayList.add(2);
//		//Collections.sort(arrayList);
//		Collections.sort(arrayList, (o1,o2) -> o2 - o1);
//		for (int i = 0; i < arrayList.size(); i++) {
//			System.out.print(arrayList.get(i)+" ");
//		}
		
		
		//排序库 基础
		//题目: A < B < C
		//输入 1 4 2
		//  ABC      ---------- 输出 1 2 4
		//  CAB      ---------- 输出 4 1 2
		//数字和字母相绑定的感觉
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[3];
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		//对数组进行从小到达的排序
		Arrays.sort(a);
		
		char[] charArray = scanner.next().toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			//如果为A，时 A-A，为0，前面的就是最小的
			//如果为B，时 B-A, 为1，其次
			System.out.print(a[charArray[i] - 'A'] + " ");
		}
		
	}

}
