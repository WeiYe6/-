package 模拟赛题;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个正好六位的正整数 x，请将 x 循环左移一位后输出。
 * 　　所谓循环左移一位，是指将原来的十万位变为个位，原来的万位到个位向左移动依次变为十万位到十位。
 * 　　例如：194910 左移一位变为 949101 。
 * 　　又如：987123 左移一位变为 871239 。
 * 输入格式
 * 　　输入一行包含一个整数 x 。保证输入的 x 正好包含 6 个十进制数位，而且十万位和万位上的数字均不为 0 。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 194910
 * 样例输出
 * 949101
 * ----------------------------------
 * //机器人判分系统要求必须如下规则：
 * // 1： 不能有package关键字
 * // 2： 类名必须是Main
 * import java.util.Scanner;
 * public class Main {
 *     public static void main(String[] args) {
 *
 *     }
 * }
 */
public class Test5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strCharArray = str.toCharArray();
        char[] chars = new char[strCharArray.length];
        for (int i = 0; i < 6; i++) {
            if (i == 5){
                chars[i] = strCharArray[0];
            }else {
                chars[i] = strCharArray[i + 1];
            }
        }
        System.out.println(chars);
    }
}


