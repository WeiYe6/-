package lanqiao;

public class pro5 {

	public static void main(String[] args) {
		// 4.猜字母（字符处理问题）
//	       题目： 
//	        把abcd....s共19个字母组成的序列重复拼接106次，得到长度为2014的串。
//	        接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字符。
//	        得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
//abcdefghijklmnopqrs

		// 方法一: StringBuilder
		// 拼接
		StringBuilder a = new StringBuilder();
		for (int i = 1; i <= 106; i++) {
			a.append("abcdefghijklmnopqrs");
		}
		// 不断删除奇数位的字符,直至只剩下最后一个
		while (a.length() > 1) {
			int l = a.length() / 2;
			if (a.length() % 2 != 0) { // 如果长度为奇数时，上一步除以2会向上取整，我们此时应该还要删多一次的
				l++;
			}

			// 难点为什么是j++，而不是j+2，（StringBUilder）因为当我们删除第一个字符时，后面的字符就会往上移动，
			// 原来要删除的字符向前移动了一位，所以，我们只需要删除后一个即可
			// 举例： abcde------我们要删除的是a c e 下标为0, 2,4,但是删除第一个之后，向前移动了
			// c e的下标变成 1,3了
			for (int j = 0; j < l; j++) {
				a.deleteCharAt(j);
			}
		}
		System.out.println(a);

		// ---------------------------------------------------
		// 方法二: 数组的形式存放
		StringBuilder a1 = new StringBuilder();
		for (int i = 1; i <= 106; i++) {
			a1.append("abcdefghijklmnopqrs");
		}
		char[] array = a1.toString().toCharArray();
		// 让偶数位的字符全部向前挪
		int len = 2014;
		while (len != 1) {
			int k = 0; // 用来存放待向前挪动的字符
			for (int i = 1; i < len; i += 2) {// 注意，第一个偶数的下标位1
				array[k++] = array[i];
			}
			len = k; //记录挪动后的那段字符长度
		}
		//当 len = 1,即移动了最后一次时，那最前面那个就是还未删除的字符了
		System.out.println(array[0]);
	}

}
