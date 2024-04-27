package 卡码网;

import java.util.*;

/**
 * 11. 共同祖先
 * 时间限制：1.000S  空间限制：32MB
 * 题目描述
 * 小明发现和小宇有共同祖先！现在小明想知道小宇是他的长辈，晚辈，还是兄弟。
 * 输入描述
 * 输入包含多组测试数据。每组首先输入一个整数N（N<=10），接下来N行，每行输入两个整数a和b，表示a的父亲是b（1<=a,b<=20）。小明的编号为1，小宇的编号为2。
 * 输入数据保证每个人只有一个父亲。
 * 输出描述
 * 对于每组输入，如果小宇是小明的晚辈，则输出“You are my younger”，如果小宇是小明的长辈，则输出“You are my elder”，
 * 如果是同辈则输出“You are my brother”。
 * 输入示例
 * 5
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 6
 * 6
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 7
 * 6 7
 * 输出示例
 * You are my elder
 * You are my brother
 */
public class test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> maps = new HashMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                maps.put(sc.nextInt(), sc.nextInt());
            }
            int a = 1; //小明
            int b = 2;//小宇
            int mingCount = 0;
            int yuCount = 0;
            while (maps.get(a) != null) { //思路:根据遍历的次数来确定辈分
                a = maps.get(a); //根据键获取值
                mingCount++;
            }
            while (maps.get(b) != null) { //思路:根据遍历的次数来确定辈分
                b = maps.get(b); //根据键获取值
                yuCount++;
            }

            if (mingCount < yuCount){         //小明是长辈
                System.out.println("You are my younger");
            } else if (mingCount > yuCount) { //小明是晚辈
                System.out.println("You are my elder");
            }else {                           //同辈
                System.out.println("You are my brother");
            }
        }
        sc.close();
    }
}

