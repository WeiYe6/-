package 卡码网;

import java.util.Scanner;

/**
 * 3. A+B问题III
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 你的任务依然是计算a+b。
 * <p>
 * 输入描述
 * 输入中每行是一对a和b。其中会有一对是0和0标志着输入结束，且这一对不要计算。
 * <p>
 * 输出描述
 * 对于输入的每对a和b，你需要在相应的行输出a、b的和。
 * 如第二对a和b，他们的和也输出在第二行。
 * 输入示例
 * 2 4
 * 11 19
 * 0 0
 * 输出示例
 * 6
 * 30
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
        sc.close();
    }
}
