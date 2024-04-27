package lanqiao;

public class pro28 {

	public static void main(String[] args) {
		// 既约分数
		int count = 0;
		for(int i = 1; i<= 2020; i++) {
			for(int j = 1; j<= 2020; j++) {
				if(gcd(i, j) == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	
	
	//求两数的最大公约数
	public static int gcd(int a, int b) {
		return b != 0 ? gcd(b, a%b):a;
	}

}
