package 真题;

import java.math.BigInteger;

public class pro7 {

	public static void main(String[] args) {
		// Interger练习
		// 题目1；九进制转十进制
		// String string = "2022";
		// System.out.println(Integer.parseInt(string,9));

		// 题目2: 星期计算
//		double n = Math.pow(20, 22) % 7;
//		int i = (int) (6 + n);
//		System.out.println(i);

		// BigIngeger方法
		// 题目3: 求两个大数的 最大公约数 最小公倍数
		BigInteger a = new BigInteger("6");
		BigInteger b = new BigInteger("4");
		BigInteger gcd = a.gcd(b);

		//使用了 a.multiply(b).divide(gcd) 这一行代码来计算两个大整数的乘积，然后再除以它们的最大公约数，从而得到它们的最小公倍数。
		BigInteger divide = a.multiply(b).divide(gcd);
		System.out.println("最大公约数"+ gcd);
		System.out.println("最小公倍数"+ divide);
		
		//题目4：判断一个大数是不是素数
		//certainty 参数表示测试的确定性级别，它是一个介于 0 到 100 之间的整数，值越高，测试结果越可靠。
		//通常，确定性级别设为 0 是合适的，因为它会尽快返回结果，但对于严格的素性测试，可以选择更高的确定性级别。
		BigInteger c = new BigInteger("11");
		boolean isProabdleprime = c.isProbablePrime(100);
		System.out.println(isProabdleprime);
		
		//返回第一个大于this的素数
		BigInteger nextProbablePrime = c.nextProbablePrime();
		System.out.println(nextProbablePrime);
		
		//返回(this)a ^ b mod c
		BigInteger modPow = a.modPow(b, c);
		System.out.println(modPow);
		
		//返回n mod m 的乘法逆元
		//n.modInverse(BigInteger m) 方法是用来计算 a mod b 的乘法逆元的。
		//但是，这个方法要求 b 必须是一个正数，且与模数互质（即它们的最大公约数为 1）
		BigInteger n = new BigInteger("6");
		BigInteger m = new BigInteger("11");
		BigInteger modInverse = null;
		try {
			modInverse = n.modInverse(m);
		} catch (Exception e) {
			System.out.println("无法计算乘法逆元，因为 m 不是正数或者与模数不互质。");
		}
		System.out.println(modInverse);
		
		
	}

}
