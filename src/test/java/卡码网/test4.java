package 卡码网;
import java.util.Scanner;

/**
 * 5. A+B问题VII
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 你的任务是计算两个整数的和。
 * 输入描述
 * 输入包含若干行，每行输入两个整数a和b，由空格分隔。
 * 输出描述
 * 对于每组输入，输出a和b的和，每行输出后接一个空行。
 * 输入示例
 * 2 4
 * 11 19
 * 输出示例
 * 6
 *
 * 30
 */
public class test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b + "\n");
            //System.out.println();
        }
        sc.close();
    }
}
