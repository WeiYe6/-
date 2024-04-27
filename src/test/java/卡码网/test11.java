package 卡码网;
import java.util.*;
/**
 * 12. 打印数字图形
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 先要求你从键盘输入一个整数n（1<=n<=9），打印出指定的数字图形。
 * 输入描述
 * 输入包含多组测试数据。每组输入一个整数n（1<=n<=9）。
 * 输出描述
 * 对于每组输入，输出指定的数字图形。
 * 注意：每行最后一个数字后没有任何字符。
 * 输入示例
 * 5
 * 输出示例
 *     1
 *    121
 *   12321
 *  1234321
 * 123454321
 *  1234321
 *   12321
 *    121
 *     1
 */
// 学会拆解问题 （化繁为简）
public class test11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //思路:把每一行要输入的信息拆解如：空格 + n以及n的前半部分数字 + n的后半部分数字
            for (int i = 1; i <= n; i++){ //n的前半部分
                for (int j = 1; j <= n - i; j++){//输出前 n-i 个空格
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++){//输出前 i 个数字
                    System.out.print(j);
                }
                for (int j = i - 1; j >= 1; j--){//输出后 i 的数字
                    System.out.print(j);
                }
                System.out.println();
            }
            for (int i = n - 1; i >= 1; i--) { //n的后半部分
                for (int j = 1; j <= n - i; j++){//输出前 n-i 个空格
                    System.out.print(" ");
                }
                for(int j = 1; j <= i; j++){//输出前 i 个数字
                    System.out.print(j);
                }
                for (int j = i - 1; j >= 1; j--){//输出后 i 的数字
                    System.out.print(j);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
