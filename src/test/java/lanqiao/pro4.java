package lanqiao;

import java.util.Iterator;

public class pro4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 马虎的算式
// 题目：小明是个急性子，上小学的时候经常抄错题目。有一次老师出的36X495=？他却抄成了396X45？但结果却很戏剧性，
//他的答案是正确的！！因为36 * 495= 396 * 45=17280
// 类似这样的巧合可能还有很多，比如27 * 594=297 * 54。
//假设a b c d e代表1~9个不同的五个数字（注意是各不相同的数字，且不含0），能满足
//这样的格式的式子总共有多少种？
		int count = 0;

		// 暴力遍历
		for (int a = 1; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {
				if (a != b)
					for (int c = 1; c <= 9; c++) {
						if (a != c && b != c)
							for (int d = 1; d <= 9; d++) {
								if (a != d && b != d && c != d)
									for (int e = 1; e <= 9; e++) {
										if (a != e && b != e && c != e && d != e) {
											if ((a * 10 + b)* (c*100+d*10+e) == (a * 100+d*10 + b)* (c*10+e)) {
												//System.out.println((a * 10 + b)* (c*100+d*10+e) == (a * 100+d*10 + b)* (c*10+e));
												count++;
											}
											
										}
									}
							}
					}
			}
		}
		System.out.println(count); //142
	}
}
