package lanqiao;

import java.util.Scanner;
import java.util.Stack;

public class pro15 {
	public static void main(String[] args) {
		//栈 - 打基础
		//输入一串数字，以0结束
		//倒叙输出该数字，不输出0
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		while(scanner.hasNextInt()) {
			int n = scanner.nextInt();
			if (n == 0) {
				break;
			}
			stack.push(n);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+ " ");
		}
	}
}
