package lanqiao;

import java.util.Scanner;
import java.util.Stack;

public class pro16 {

	public static void main(String[] args) {
		// 栈 基础
		// 表达式括号的正确校验，左右括号相匹配
		Scanner scanner = new Scanner(System.in);
		char[] charArray = scanner.next().toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '@') {
				break;
			}
			if (charArray[i] == '(') {
				stack.push(charArray[i]);
			}
			if (charArray[i] == ')') {
				if (!stack.isEmpty()) {
					stack.pop(); // 弹出左括号
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
