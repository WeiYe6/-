package 卡码网;

import java.util.Scanner;

/**
 * 8. 摆平积木
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 小明很喜欢玩积木。一天，他把许多积木块组成了好多高度不同的堆，每一堆都是一个摞一个的形式。
 * 然而此时，他又想把这些积木堆变成高度相同的。但是他很懒，他想移动最少的积木块来实现这一目标，你能帮助他吗？
 * <p>
 * 输入描述
 * 输入包含多组测试样例。每组测试样例包含一个正整数n，表示小明已经堆好的积木堆的个数。
 * 接着下一行是n个正整数，表示每一个积木堆的高度h，每块积木高度为1。其中1<=n<=50,1<=h<=100。
 * 测试数据保证积木总数能被积木堆数整除。
 * 当n=0时，输入结束。
 * 输出描述
 * 对于每一组数据，输出将积木堆变成相同高度需要移动的最少积木块的数量。
 * 在每组输出结果的下面都输出一个空行。
 * 输入示例
 * 6
 * 5 2 4 1 7 5
 * 0
 * 输出示例
 * 5
 */
/*
思路分析: 获取所有积木堆的平均值，然后分别与每个堆进行比较，如果该堆大于平均值，大于的积木块数 就是需要移动的 积木块
 */
public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
//            int size = sc.nextInt();//积木的列数
//            sc.nextLine();//消除读取空行
            int size = Integer.parseInt(sc.nextLine());//列数
            if (size == 0) {
                return; //如果列数为0，结束
            }
            int sum = 0;
            String[] jiSum = sc.nextLine().split(" ");
            for (String ji : jiSum) {
                //获取积木块的总数
                sum = sum + Integer.parseInt(ji);
            }
            //获取平均值
            int avg = sum / size;
            int moveCount = 0; //需要移动积木块的个数。
            for (String ji : jiSum){
                if (Integer.parseInt(ji) > avg){//分别获取 每个堆中大于平均数的积木块数
                    moveCount = moveCount + (Integer.parseInt(ji) - avg);
                }
            }
            System.out.println(moveCount + "\n");
        }
        sc.close();
    }
}
