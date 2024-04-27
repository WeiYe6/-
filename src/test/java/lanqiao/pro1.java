package lanqiao;

import java.util.Calendar;
import java.util.Iterator;

/**
 * 1.世纪末的星期
 */
public class pro1 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Calendar calendar = Calendar.getInstance();
//		for(int year = 1999; year < 10000; year+=100) {
//			calendar.set(Calendar.YEAR, year);
//			calendar.set(Calendar.MONTH, 11); //其实是12月
//			calendar.set(Calendar.DAY_OF_MONTH, 31);
//			//验证1999 12.31 是否是星期五，正确
////			int i = calendar.get(Calendar.DAY_OF_WEEK);
////			System.out.println(i); //6 星期五
//			
//			if (calendar.get(Calendar.DAY_OF_WEEK)==1) {
//				//sunday是第一天，所以为1时是星期日
//				System.out.println(year);
//				break;
//			}
//		}
		//1999 12.31 星期五
		//题目: xx99 12.31 为星期日的
		Calendar calendar = Calendar.getInstance();
		for(int year = 1999; year <= 9999; year+=100) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, 11); //12月
			calendar.set(Calendar.DAY_OF_MONTH, 31);
			//1999 12.31 星期五-对应的为6
			int i = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println(year+"------"+i);
			if (i == 1) { //sunday是第一天，所以为1时是星期日
				break;
			}
		}

	}

}
