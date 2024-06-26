package 模拟赛题;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个整数，对这个整数的一次转换是指将这个整数变为这个整数的所有数位上的 非零数字 的乘积。
 * 　　例如，对 123456789 进行一次转换变为 1*2*3*4*5*6*7*8*9=362880，再进行一次转换变为 3*6*2*8*8=2304，
 * 再进行一次转换变为 2*3*4=24，再进行一次转换变为 8。
 * 　　给定一个整数，请依次将转换过程中经历的每个整数输出，直到小于 10 。
 * 输入格式
 * 　　输入一行包含一个整数 n 。
 * 输出格式
 * 　　输出多行，每行包含一个整数。
 * 样例输入
 * 123456789
 * 样例输出
 * 362880
 * 2304
 * 24
 * 8
 * 评测用例规模与约定
 * 　　对于 50% 的评测用例，1 <= n <= 10**9 （10的9次方）。
 * 　　对于所有评测用例，1 <= n <= 10**18 （10的18次方）
 * --------------------------------------------------------
 * //机器人判分系统要求必须如下规则：
 * // 1： 不能有package关键字
 * // 2： 类名必须是Main
 * import java.util.Scanner;
 * public class Main {
 * public static void main(String[] args) {
 * <p>
 * }
 * }
 */
public class Test7 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String strNum = sc.nextLine();
//        char[] charNumArray = strNum.toCharArray();
//        conversion(charNumArray);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        while (n >= 10) { //　给定一个整数，请依次将转换过程中经历的每个整数输出，直到小于 10 。
            String s = Integer.toString(n);
            int res = 1;

            for (int i = 0; i < s.length(); i++) {
                char digit = s.charAt(i);
                if (digit != '0') {
                    res *= Character.getNumericValue(digit);//将 字符数字 --转换--> 数值数字
                }
            }

            System.out.println(res);
            n = res;
        }

    }

    private static void conversion(char[] charNumArray) {
        for (int i = 0; i < charNumArray.length; i++) {
            long sum = 1;
            for (char c : charNumArray) {
                int numericValue = Character.getNumericValue(c);
                if (numericValue != 0) {//将 字符数字 ---> 数值数字
                    sum = sum * numericValue;
                }
            }
            System.out.println(sum);
        }
    }
}
