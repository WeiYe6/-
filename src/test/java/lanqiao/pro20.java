package lanqiao;

import java.util.Scanner;

public class pro20 {

	public static void main(String[] args) {
		// 题目:
		// 输入: we choose TO go 2 the 123 moon
		// 输出: MOON 321 THE 2 GO to CHOOSE WE

		Scanner scanner = new Scanner(System.in);
		char[] charArray = scanner.nextLine().toCharArray();
		StringBuilder str = new StringBuilder(); // 存放结果集
		StringBuilder temp = new StringBuilder();// 存放每一块单词集，并添加进结果集中
		// 倒着遍历
		for (int i = charArray.length - 1; i >= 0; i--) {
			// 判断是否遍历完一块单词
			if (charArray[i] == ' ') {
				if (temp.length() != 0) {
					// 遍历完一块单词
					// 判断是否是自然数
					int k = temp.charAt(0) - '0';
					if (k >= 0 && k <= 9) {
						// 把自然数倒叙过来
						temp.reverse();
					}
				}
				// 添加进结果集中
				str.append(temp + " ");
				// 重置临时集
				temp = new StringBuilder();
			} else {
				// 还未遍历完一块单词
				// 如果是单词，应该大小写转换
				char c = charArray[i];
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					// 大小写转换
					c ^= 32;
				}
				// 并添加进临时集中
				temp.insert(0, c);// 一直往头部插入，举个例子就明白了
			}
		}
		
		//最后一个词后面没有空格，所以需要再添加一次
		if (temp.length() != 0) {
			// 遍历完一块单词
			// 判断是否是自然数
			int k = temp.charAt(0) - '0';
			if (k >= 0 && k <= 9) {
				// 把自然数倒叙过来
				temp.reverse();
			}
		}
		// 添加进结果集中
		str.append(temp + " ");
		
		System.out.println(str);
		scanner.close();
	}

}
