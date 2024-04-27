package 真题;

public class pro12 {

	public static void main(String[] args) {
		// 特殊日期 -模拟
		int count = 0;
		for (int year = 2000; year < 2000000; year++) {
			for (int month = 1; month <= 12; month++) {
				// 根据年 和 月份获取对应的天数
				for (int day = 1; day <= getDay(year, month); day++) {
					if (year % month == 0 && year % day == 0) {
						count++;
					}
				}
			}
		}
		// 因为 2000000 1月1日也是满足的，我们没有遍历到
		System.out.println(count + 1);
	}

	// 根据年 月获取该月份的天数
	private static int getDay(int year, int month) {
		int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 如果获取的是二月份，需要判断该年是不是闰年，如果是则为29
		if (month == 2 && isRunYear(year)) {
			return 29;
		}
		return day[month];
	}

	private static boolean isRunYear(int year) {
		// 判断该年份是不是闰年
		// 4年一闰 百年不闰 或 400年闰一闰
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

}
