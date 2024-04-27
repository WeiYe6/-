package com.dataStructures.sort;

import java.util.Arrays;

/**
 * 基数排序 - 基数排序就是典型的空间换时间的算法。
 * 桶排序的扩展
 * 思想步骤如下：
 * 1.我们暂考虑正数的排序，有0-9 共10位数，所以需要准备10个桶
 * 2.用一个二位数组来表示10个桶，int[][] bucket = new int[10][查询的数组长度];
 * 3.获取每一个数的个位数 数值%10， 获取每一位数在十位数 数值 /10 %10  , 获取百位数 数值/100 %10
 * 4.按照各个位数的大小依次存放入对应的桶中，int[位数][] = 该数值
 * 5.如何知道该桶存放了多个个数值？ 我们定义一个int[10]的一维数组，int[0] 表示第0个桶，int[1] 表示第一个桶，int[1] = ? ,该问号就是该桶存的个数。
 * 6.依次从桶中取出数值，放回原数组中，注意取出完后，把该桶清空，进行下一轮的桶排序(下一个位数)。
 * 不断重复 3 - 6 ，步骤即可完成。
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        //System.out.println(Arrays.toString(arr));

    }


    private static void radixSort(int[] arr) {

        //----------完整代码--------------
        //1.用一个二位数组来表示10个桶，int[][] bucket = new int[10][查询的数组长度];
        int[][] bucket = new int[10][arr.length];
        //2.定义一个一维数组，来表示某个桶中存放的个数
        int[] elementCount = new int[10];

        //判断要排序的数组中最大的哪个数，有多少位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //获取位数
        int length = (max + "").length();
        for (int m = 0, n = 1; m < length; m++, n *= 10) {
            //3.取出每个数据的十位数，按照该十位数的大小，存入对应的桶中
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;
                bucket[digit][elementCount[digit]] = arr[i];
                elementCount[digit]++; //int[1][1],表示:第一个桶中存放了一个数值，int[1][2],存放了2个数值，每存入一个就要++。
            }
            //依次将桶中的元素取出后放回原数组中
            int index = 0;
            for (int k = 0; k < elementCount.length; k++) {
                //遍历每一个桶，先判断该桶中是否存放了数据，如果没有存放，默认就是0
                if (elementCount[k] != 0) {
                    //elementCount[k] 就是该桶中存放的数据的个数，只需要遍历该长度：获取完某个桶中所有的数据即可
                    for (int j = 0; j < elementCount[k]; j++) {
                        //存入原数组
                        arr[index] = bucket[k][j];
                        index++;
                    }
                    //取出该桶的数值后，将该桶清空
                    elementCount[k] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }







       /* //我们分步来进行
        // -----------第一轮--------------
        //1.用一个二位数组来表示10个桶，int[][] bucket = new int[10][查询的数组长度];
        int[][] bucket = new int[10][arr.length];
        //2.定义一个一维数组，来表示某个桶中存放的个数
        int[] elementCount = new int[10];
        //3.取出每个数据的个位数，按照该个位数的大小，存入对应的桶中
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / 1 % 10;
            //digit：取出该数值的个位数的数是多少
            //bucket[digit] ,就是第几个桶：比如，我取的个位数为1，那么bucket[1],就表示第一个桶
            //elementCount[digit]:1.表示要存入该桶的索引位置。2.表示在某个桶，该桶存放的个数 ，没有存入任何数值时，默认就是0，所以每存入一个数值就要++
            bucket[digit][elementCount[digit]] = arr[i];
            elementCount[digit]++; //int[1][1],表示:第一个桶中存放了一个数值，int[1][2],存放了2个数值，每存入一个就要++。
        }
        //依次将桶中的元素取出后放回原数组中
        int index = 0;
        for (int k = 0; k < elementCount.length; k++) {
            //遍历每一个桶，先判断该桶中是否存放了数据，如果没有存放，默认就是0
            if (elementCount[k] != 0) {
                //elementCount[k] 就是该桶中存放的数据的个数，只需要遍历该长度：获取完某个桶中所有的数据即可
                for (int j = 0; j < elementCount[k]; j++){
                    //存入原数组
                    arr[index] = bucket[k][j];
                    index++;
                }
                //取出该桶的数值后，将该桶清空
                elementCount[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));



        // -----------第二轮--------------
        //3.取出每个数据的十位数，按照该十位数的大小，存入对应的桶中
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / 10 % 10;
            bucket[digit][elementCount[digit]] = arr[i];
            elementCount[digit]++; //int[1][1],表示:第一个桶中存放了一个数值，int[1][2],存放了2个数值，每存入一个就要++。
        }
        //依次将桶中的元素取出后放回原数组中
        index = 0;
        for (int k = 0; k < elementCount.length; k++) {
            //遍历每一个桶，先判断该桶中是否存放了数据，如果没有存放，默认就是0
            if (elementCount[k] != 0) {
                //elementCount[k] 就是该桶中存放的数据的个数，只需要遍历该长度：获取完某个桶中所有的数据即可
                for (int j = 0; j < elementCount[k]; j++){
                    //存入原数组
                    arr[index] = bucket[k][j];
                    index++;
                }
                //取出该桶的数值后，将该桶清空
                elementCount[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

        // -----------第三轮--------------
        //3.取出每个数据的十位数，按照该百位数的大小，存入对应的桶中
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / 100 % 10;
            bucket[digit][elementCount[digit]] = arr[i];
            elementCount[digit]++; //int[1][1],表示:第一个桶中存放了一个数值，int[1][2],存放了2个数值，每存入一个就要++。
        }
        //依次将桶中的元素取出后放回原数组中
        index = 0;
        for (int k = 0; k < elementCount.length; k++) {
            //遍历每一个桶，先判断该桶中是否存放了数据，如果没有存放，默认就是0
            if (elementCount[k] != 0) {
                //elementCount[k] 就是该桶中存放的数据的个数，只需要遍历该长度：获取完某个桶中所有的数据即可
                for (int j = 0; j < elementCount[k]; j++){
                    //存入原数组
                    arr[index] = bucket[k][j];
                    index++;
                }
                //取出该桶的数值后，将该桶清空
                elementCount[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));*/
    }
}
