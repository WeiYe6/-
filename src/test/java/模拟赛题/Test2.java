package 模拟赛题;

/**
 * 如果一个正整数转化成二进制与转换成八进制后所有数位的数字之和相等，则称为数位和相等的数。
 * 　　前几个数位和相等的正整数为 1, 8, 9, 64, ……
 * 　　请问第 23 个数位和相等的正整数是多少？
 */
public class Test2 {
        public static void main(String[] args) {
            int cnt = 0;
            int n = 1;

            while (true) {
                String er = Integer.toBinaryString(n);//将整数n转换成二进制
                String ba = Integer.toOctalString(n);//将整数n转换成八进制
                int s1 = 0;
                int s2 = 0;

                //计算每个字符串中数字的和
                for (int i = 0; i < er.length(); i++) {
                    s1 += Character.getNumericValue(er.charAt(i)); //将字符串转换为对应的数值，并累加到s1中
                }
                for (int i = 0; i < ba.length(); i++) {
                    s2 += Character.getNumericValue(ba.charAt(i));
                }
                if (s1 == s2) {
                    cnt++;
                    System.out.println(n);
                }
                if (cnt == 23) {
                    break;
                }
                n++;
            }
        }
}
