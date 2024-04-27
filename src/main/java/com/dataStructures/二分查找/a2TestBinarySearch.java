//package com.dataStructures.二分查找;
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//
//
//public class a2TestBinarySearch {
//    @Test
//    //找到
//    public void test1(){
//        int[] a = {7,13,21,30,38,44,52,53};
//        System.out.println(a1BinarySearch.binarySearchBasic(a, 7));
//        System.out.println(a1BinarySearch.binarySearchBasic(a, 30));
//        System.out.println(a1BinarySearch.binarySearchBasic(a, 53));
//    }
//
//    @Test
//    //找不到
//    public void test2(){
//        int[] a = {7,13,21,30,38,44,52,53};
//        System.out.println(a1BinarySearch.binarySearchBasic(a, 0));
//        System.out.println(a1BinarySearch.binarySearchBasic(a, 55));
//    }
//
//    @Test
//    public void test3(){
//        int[] a = {7,13,21,30,38,44,52,53};
//        System.out.println(a1BinarySearch.binarySearchBasic3(a, 7));
//        System.out.println(a1BinarySearch.binarySearchBasic3(a, 30));
//        System.out.println(a1BinarySearch.binarySearchBasic3(a, 53));
//    }
//
//    @Test
//    @DisplayName("测试 binarySearchLeftmost1： 找重复元素最左的元素索引值")
//    public void TestLeftmost1(){
//        int[] arr = {1,2,3,4,5,5,6,7};
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost1(arr, 1));//0
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost1(arr, 5));//4
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost1(arr, 6));//6
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost1(arr, 8));//-1
//
//    }
//
//    @Test
//    @DisplayName("测试 binarySearchLeftmost2： 找重复元素最左的元素以及待插入点的索引值")
//    public void TestLeftmost2(){
//        int[] arr = {1,2,3,4,5,5,6,7};
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost2(arr, 1));//0
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost2(arr, 5));//4
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost2(arr, 6));//6
//        System.out.println(a3BinarySearchJava.binarySearchLeftmost2(arr, 8));//8
//
//    }
//
//
//}
