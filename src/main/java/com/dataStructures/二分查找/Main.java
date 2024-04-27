package com.dataStructures.二分查找;
//public class Main {
//
//    /**
//     * 在主串中查找与子串相等的子串，并返回其位置
//     *
//     * @param S   主串
//     * @param T   子串
//     * @param pos 起始查找位置
//     * @return 子串在主串中的位置，若无匹配子串则返回0
//     */
//    public static int Index(String S, String T, int pos) {
//        int n = S.length(); // 主串长度
//        int m = T.length(); // 子串长度
//        int i = pos - 1; // 起始查找位置
//
//        while (i <= n - m) {
//            String sub = S.substring(i, i + m); // 获取主串中指定位置和长度的子串
//
//            if (sub.equals(T)) { // 判断子串是否与目标子串相等
//                return i; // 返回匹配子串的起始位置（从1开始）
//            }
//
//            i++;
//        }
//
//        return -1; // 若无匹配子串，则返回0
//    }
//
//    public static void main(String[] args) {
//        String S = "Hello, world!";
//        String T = "world";
//        int pos = 1;
//
//        int index = Index(S, T, pos);
//        System.out.println("Index: " + index);
//    }
//}

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);

//            String s = sc.nextLine();
//            int a = Integer.parseInt(s.split(" ")[0]);
//            int b = Integer.parseInt(s.split(" ")[1]);
//            System.out.println(a + b);
        }
    }
}