package 真题;

public class pro11 {

	public static void main(String[] args) {
		// 山 -模拟

		int n = 2022;
		int count = 0;
		while (n <= 2022222022) {
			String s = String.valueOf(n);
			if (isPalindrome(s) && isNonDec(s)) {
				count++;
				//System.out.println(s);
			}
			n++;
		}
		System.out.println(count);
	}

	// 判断是否是单调不减 (只需判断一半即可) --举个例子就全懂了
	//eg: 偶个数 145541     len/2 = 3; 只需判断前三位即可,注意: 一定不能写等号，不然 判断 5 5相等时就不通过了
	//奇个数 1235321  len / 2 = 3;
	private static boolean isNonDec(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	// 判断是否是回文数
	private static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
