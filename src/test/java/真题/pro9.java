package 真题;

public class pro9 {

	public static void main(String[] args) {
		// 顺子日期
		// 从 20220101 --- 20221231判断有多少
		// 012 123 234 345 456 678 789的顺子
		int n = 20220101;
		int count = 0;// 统计个数
		// 顺子定义
		String[] sun = { "012", "123", "234", "345", "456", "567", "678", "789" };
		while (n <= 20221231) {
			if (check(n)) {// 日期的合法性判断
				if (isSun(n + "", sun)) {// 是否存在顺子的判断
					count++;
				}
			}
			n++;
		}
		System.out.println(count);

	}

	// 日期合法性校验
	private static boolean check(int n) {
		// 2022是平年 2月只有28天,从索引1开始表示1月份的天数
		int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 获取月份，并进行月份的校验
		int month = n % 10000 / 100;
		if (month <= 0 || month > 12) {
			return false;
		}
		// 获取天数, 且对月份天数的校验
		int nowDay = n % 100;
		if (nowDay <= 0 || nowDay > 31 || nowDay > day[month]) {
			return false;
		}
		return true;
	}

	// 顺子校验
	private static boolean isSun(String s, String[] sun) {
		for (int i = 0; i < sun.length; i++) {
			if (s.contains(sun[i])) {
				return true;
			}
		}
		return false;
	}

}
