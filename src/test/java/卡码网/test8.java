package 卡码网;

import java.util.Scanner;

/**
 * 9. 奇怪的信
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 有一天, 小明收到一张奇怪的信, 信上要小明计算出给定数各个位上数字为偶数的和。
 * 例如：5548，结果为12，等于 4 + 8 。
 * 小明很苦恼，想请你帮忙解决这个问题。
 * 输入描述
 * 输入数据有多组。每组占一行，只有一个整整数，保证数字在32位整型范围内。
 * 输出描述
 * 对于每组输入数据，输出一行，每组数据下方有一个空行。
 * 输入示例
 * 415326
 * 3262
 * 输出示例
 * 12
 * <p>
 * 10
 */
public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] numArr = sc.nextLine().split("");
            int sum = 0;
            for (String num : numArr) {
                if (Integer.parseInt(num) % 2 == 0){
                    sum = sum + Integer.parseInt(num);
                }
            }
            System.out.println(sum + "\n");
        }
        sc.close();
    }
}

