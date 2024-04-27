package 真题;

import java.util.Scanner;

public class pro4 {
    public static void main(String[] args) {
    	//刷题统计 - 模拟题
    	//学会了 向上取整的技巧
        Scanner scan = new Scanner(System.in);

        long a = scan.nextLong(); //周一到周五每天的题数
        long b = scan.nextLong(); //周六到周日每天的题数
        long n = scan.nextLong(); //总题数

        long week = a * 5 + b * 2;  //一周要做的题数
        long day = 7 * (n / week); //多少周*7 转换成天数
        long shengyu = n % week; //剩余的题数

        if (shengyu > 0) { //前提是剩余的题数大于0
            if (shengyu <= a * 5) {//剩余的题数小于等于5天
                //为了实现向上取整，我们可以将 shengyu 先加上 a - 1，这样偏移量 a - 1 能够确保在整除的情况下不会影响结果，
                //但在非整除的情况下，会使得商向上取整到下一个整数。然后再除以 a，就能够得到向上取整后的结果。
                day += (shengyu + a - 1) / a; //不足一周的工作日，向上取整
            } else {//剩余的题数大于5天
                day += 5;
                shengyu -= 5 * a;

                if (shengyu > b) {
                    day += 2;
                } else {
                    day += 1;
                }
            }
        }

        System.out.println(day);
        scan.close();
    }
}
