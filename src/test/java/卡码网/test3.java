package 卡码网;
import java.util.Scanner;
/**
 * 4. A+B问题IV
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 你的任务是计算若干整数的和。
 * <p>
 * 输入描述
 * 每行的第一个数N，表示本行后面有N个数。
 * <p>
 * 如果N=0时，表示输入结束，且这一行不要计算。
 * <p>
 * 输出描述
 * 对于每一行数据需要在相应的行输出和。
 * <p>
 * 输入示例
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 0
 * 输出示例
 * 10
 * 15
 */
public class test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            int len = sc.nextInt();
            int sum = 0;
            for(int i = 0; i < len; i++){
                sum = sum + sc.nextInt();
            }
            if (len == 0){
                sc.close();
                break;
            }
            System.out.println(sum);
        }
    }
}
