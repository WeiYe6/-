package lanqiao;

public class pro6 {

	public static void main(String[] args) {
		// 5.立方变自身（简单枚举）
//        题目：观察下面的现象，某个数字的立方，按位累加仍然等于自身
//        1^3=1
//        8^3=512        5+1+2=8
//        17^3=4913     4+9+1+3=17
//        ...
//        请你计算包括1，8，17在内，符合这个性质的正整数一共有多少个？  
		
		//先尝试100
		int count = 0;
		for(int n = 1; n <= 1000; n++) {
			if (sum(Math.pow(n, 3)) == n) {
				System.out.println(n);
				count++;
			}
		}
		System.out.println("--------------");
		System.out.println(count);
	}

	//计算该数的位数 累加和
	private static int sum(double n) {
		int res = 0;
		while(n > 0) {
			res = (int) (res + n % 10); //取该数值的末位并累加
			n = n / 10; //去除该数值的末位
		}
		return res;
	}

}
