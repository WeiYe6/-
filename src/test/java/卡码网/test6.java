package 卡码网;
import java.util.Scanner;

/**
 * 7. 平均绩点
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
 * 输入描述
 * 有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。
 * 输出描述
 * 每组输出结果占一行。如果输入的大写字母都在集合｛A,B,C,D,F｝中，则输出对应的平均绩点，结果保留两位小数。否则，输出“Unknown”。
 * 输入示例
 * A B C D F
 * B F F C C A
 * D C E F
 * 输出示例
 * 2.00
 * 1.83
 * Unknown
 */
public class test6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){//有多组测试样例,需要加上这个
            String[] gradeArr = sc.nextLine().split(" ");//获取输入的每个字母
            double sum = 0;
            boolean flag = true;
            for (String grade : gradeArr) {
                switch (grade){
                    case "A":
                        sum = sum + 4;
                        continue;
                    case "B":
                        sum = sum + 3;
                        continue;
                    case "C":
                        sum = sum + 2;
                        continue;
                    case "D":
                        sum = sum + 1;
                        continue;
                    case "F":
                        sum = sum + 0;
                        continue;
                    default:
                        flag = false; //输入的字母不在等级范
                        break;
                }
            }
            System.out.println(flag ? String.format("%.2f",sum / gradeArr.length): "Unknown");
        }
        sc.close();
    }
}
