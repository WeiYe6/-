package 卡码网;

import java.util.Scanner;

/**
 * 6. A+B问题VIII
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 你的任务是计算若干整数的和。
 * 输入描述
 * 输入的第一行为一个整数N，接下来N行每行先输入一个整数M，然后在同一行内输入M个整数。
 * <p>
 * 输出描述
 * 对于每组输入，输出M个数的和，每组输出之间输出一个空行。
 * 输入示例
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 输出示例
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 提示信息
 * 注意以上样例为一组测试数据，后端判题会有很多组测试数据，也就是会有多个N的输入
 * 例如输入可以是：
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 输出则是
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 只保证每组数据间是有空行的。但两组数据并没有空行
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) { //保证能输入多个组
            int size = sc.nextInt();
            for (int i = 0; i < size; i++) {
                int len = sc.nextInt();
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    sum = sum + sc.nextInt();
                }
//                if (i == size - 1) {
//                    System.out.println(sum);//注意，最后一行不需要添加换行符，但是还是要在下一行输入，所以必须加上ln，不然就是不换行输入了。
//                } else {
//                    System.out.println(sum + "\n");
//                }
                System.out.println(i < (size -1) ? sum + "\n": sum);
            }
        }
        sc.close();
    }
}
