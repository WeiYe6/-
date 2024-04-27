package lanqiao;

import java.time.LocalDate;

public class pro31 {

	public static void main(String[] args) {
//		// 暴力枚举
//		int count = 0;
//		// 保存月份对应的天数
//		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		for (int i = 1900; i <= 9999; i++) {
//			for (int j = 1; j <= 12; j++) {
//				if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {// 判断是否是闰年，是的话二月有29天
//					month[2] = 29;
//				} else {
//					month[2] = 28;
//				}
//				for (int k = 1; k <= month[j]; k++) {
//					if (sum(i) == (sum(j) + sum(k))) {
//						count++;
//					}
//				}
//			}
//		}
//		System.out.println(count);
		int count = 0;
		//方法二: 用日期api
		LocalDate localDate = LocalDate.of(1900, 1, 1);
		while(true) {
			if (localDate.getYear() == 9999 && localDate.getMonth().getValue() == 12 && localDate.getDayOfMonth() == 31) {
				break;
			}
			int year1 = localDate.getYear() % 10;
			int year2 = localDate.getYear() /10 % 10;
			int year3 = localDate.getYear() /100 % 10;
			int year4 = localDate.getYear() /1000 % 10;
			
			int month1 = localDate.getMonth().getValue() % 10;
			int month2 = localDate.getMonth().getValue() /10 %10;
			
			int day1 = localDate.getDayOfMonth() % 10;
			int day2 = localDate.getDayOfMonth() /10 % 10;
			if (year1 + year2 + year3 + year4 == month1 + month2 + day1 + day2) {
				count++;
			}
			localDate = localDate.plusDays(1); //加一天
		}
		System.out.println(count);

	}

	// 获取一个数 数位上的累加和
	public static int sum(int n) {
		if (n == 0) {
			return 0;
		}
		int sum = 0;
		int i = n;
		while (i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}

}
