package lanqiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class pro12 {

	public static void main(String[] args) {
		// HashMap 基础练习
		// 题目: 输入两行 N(第二行的个数) C(第二行 两数的差值)
		// 4 1
		// 1 1 2 3
		// 问有多少个对 A - B = C (1)
		// 由于C的范围大，转换成 A - C = B
		// 求A - C = B 的个数
//		Scanner scanner = new Scanner(System.in);
//		HashMap<Integer, Integer> hashMap = new HashMap<>();
//		int n = scanner.nextInt();
//		int c = scanner.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = scanner.nextInt();
//			//put进集合中，k: 当前元素 v: 该元素出现的次数
//			hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
//		}
//		
//		// A - C = B
//		//求Map中有多少个B的元素个数累加
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			int b = arr[i] - 1;
//			count += hashMap.getOrDefault(b, 0);
//		}
//		System.out.println(count);
//		
		
		System.out.println("-------------------------------------");
		//方式二: 滑动窗口（解决对数 问题的好方法）
		//滑动窗口应用场景
		//1. 最大连续子数组和
		//2. 最小大小的子数组和
		//解决 A - B = C（1）
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		//对数组进行从小到大的排序
		Arrays.sort(arr);
		//初始化左右指针、计数器
		int left = 0;
		int right = 0;
		int count = 0;
		while(right < n) {//到达边界
			//差值小于 C, 扩大边界 右指针右移
			int res = arr[right] - arr[left];
			if (res < c) {
				right++;
			}
			//差值大于 C, 缩小边界 左指针右移
			if (res > c) {
				left++;
			}
			//相等
			if (res == c) {
				//没重复元素时
				//扩大边界 移动指针继续找下一个
				//count++;
				//right++;
				
				//这题我们是有重复元素的，且要算入结果中
				count += eqElem(arr, left, right);
				right++;
				
			}
		}
		
		System.out.println(count);
		scanner.close();
	}

	//重复元素--判断在窗口中，还有哪些元素是和左边界相等的元素的个数 ---(找和左索引相等元素的个数)
	private static int eqElem(int[] arr, int left, int right) {
		// 此时 left 和 right 是满足结果的，但是我们有重复的元素时
		//比如 1 1 2 3 ,1 - 2时是满足的，但是不能直接rigth++,不然会丢失第二个1的判断
		//我们应该判断，有多少个和左边界相等的元素
		int count = 0;
		for (int i = left; i <= right; i++) {
			if (arr[i] == arr[left]) {//判断在窗口中，还有哪些元素是和左边界相等的
				count++; 
			}
		}
		return count;
	}
}
