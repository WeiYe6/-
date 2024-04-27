package 卡码网;

import java.util.Scanner;

/**
 * A+B问题II
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 计算a+b，但输入方式有所改变。
 * 输入描述
 * 第一行是一个整数N，表示后面会有N行a和b，通过空格隔开。
 * <p>
 * 输出描述
 * 对于输入的每对a和b，你需要在相应的行输出a、b的和。
 * 如第二对a和b，对应的和也输出在第二行。
 * 输入示例
 * 2
 * 2 4
 * 9 21
 * 输出示例
 * 6
 * 30
 * 提示信息
 * 注意，测试数据不仅仅一组。也就是说，会持续输入N以及后面的a和b
 */
public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            /*
               int len = sc.nextInt(); 错误用法，nextInt(),之后，会留下一个换行符，
               当我再次使用nextLine()方法时，他会读取刚刚留下的那个空行作为输入，就产生了错误。
               解决:可以在nextInt() 之后再调用一次 sc.nextLine()来读取剩余的空行，就可以清除输入流中的换行符，或者改为如下的方案。
             */
            int len = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < len; i++){
                String s = sc.nextLine();
                int a = Integer.parseInt(s.split(" ")[0]);
                int b = Integer.parseInt(s.split(" ")[1]);
                System.out.println(a + b);
            }
            sc.close();
        }
    }
}
