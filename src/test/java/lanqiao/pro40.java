package lanqiao;


public class pro40 {

	public static void main(String[] args) {
		// 数列求值
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 0;
		for (int i = 4; i <= 20190324; i++) {
			d = (a + b + c) % 10000; //每次结果都取后四位，对我们的最终结果不影响
			a = b;
			b = c;
			c = d;
		}
		System.out.println(d);
		//如果结果不足三位，那么就会原数输入，
		//如果结果大于三位就会输出后面的四位数
		//但是：如果类似这样呢？ 10456，那么就输出456咯，因为已经进位了，对后面的四位数不影响
		//答案要求我们输出结果的四位数，那么最终结果一定不会是0开头的，不然何来4位数。
		System.out.println(10456 % 10000);
	}

}
