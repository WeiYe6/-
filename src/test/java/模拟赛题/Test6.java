package 模拟赛题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 问题描述
 * 　　输入一个仅包含小写英文字母的字符串，请问这个字符串中的最后一元音是什么。
 * 　　在英文中，a, e, i, o, u 共 5 个字母是元音字母，其它字母不是元音字母。
 * 输入格式
 * 　　输入一行包含一个字符串，仅由小写英文字符组成，字符串中至少包含一个元音字母。
 * 输出格式
 * 　　输出一行包含一个字符，表示答案。
 * 样例输入
 * lanqiao
 * 样例输出
 * o
 * 样例输入
 * cup
 * 样例输出
 * u
 * 评测用例规模与约定
 * 　　对于所有评测用例，1 <= 字符数量 <= 10000 。
 * ------------------------------------------------
 * //机器人判分系统要求必须如下规则：
 * // 1： 不能有package关键字
 * // 2： 类名必须是Main
 * <p>
 * import java.util.Scanner;
 * public class Main {
 * public static void main(String[] args) {
 * <p>
 * }
 * }
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strCharArray = str.toCharArray();
        char[] ch = {'a','e','i','o','u'};
        for (int i = strCharArray.length - 1; i >= 0; i--) {
            for (char c : ch) {
                if (strCharArray[i] == c) {
                    System.out.println(strCharArray[i]);
                    return;
                }
            }
        }
    }
}
