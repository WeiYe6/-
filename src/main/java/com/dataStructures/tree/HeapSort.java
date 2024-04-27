package com.dataStructures.tree;

import java.util.Arrays;

/**
 * 堆排序: 条件(完全二叉树，从左至右，从下至上)，分为 大顶堆（用作升序） 和 小顶堆（用作降序）
 * 思路: 要求(升序)
 * 1.先把一颗无序的树，调整成一颗大顶堆
 * 1.1：首先获取最后一个非叶子节点下的索引: j = arr.length/2 -1 = 该索引值  ---->（ 从左至右,从下至上进行调整。）
 * 1.2：让该结点的左右子树（需要判断是否存在右子树），进行大小的判断(左子树：k = 2*j+1)、(右子树：k = 2*j+1)
 * 1.3，再让该结点和左右子树中最大的进行比较，如果结点大，则不用交换，反之把该结点和最大的哪个子树进行交换。
 * 局部的大顶堆就调整完毕了。继续调整下一个子树为大顶堆。---> 使用循环(改变最后一个非叶子节点下的索引: j--)，继续调整下一棵子树。直至整个树调整为大顶堆。
 * <p>
 * 2.调整为大顶堆后，此时顶堆的根节点就是最大的了，将根节点与末尾元素进行交换，把最大值放在数组的末端，然后数组长度减一。
 * 再重新调整剩下元素的结构为:大顶堆重复上面的操作，直至元素全部排序好。
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int[] arr) {
        //分步完成:第一步
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次调整"+ Arrays.toString(arr)); //4，9，8，5，6
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次调整"+ Arrays.toString(arr));//9，4，8，5，6

        //整体调整为大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //System.out.println(Arrays.toString(arr));

        int tem = 0;
        //将根节点与末尾元素进行交换，把最大值放在数组的末端，然后数组长度减一。
        //再重新调整剩下元素的结构为:大顶堆重复上面的操作，直至元素全部排序好。
        for (int i = arr.length - 1; i > 0; i--) {
            tem = arr[i];
            arr[i] = arr[0];
            arr[0] = tem;
            //这里填0，是因为除了根结点的元素发生了改变之外，其余的子树均没有发生变化(均为大顶堆)，所以不同调整其它的子树，只需要调整根节点即可。
            adjustHeap(arr, 0, i);
        }
        //System.out.println(Arrays.toString(arr));

    }


    /**
     * 调整为大顶堆：
     * 将完成以i对应的非叶子结点的子树局部调整为大顶堆
     * 举例int arr[]={4,6,8,5,9};=>i=1=> adjustHeap=>得到{4,9,8,5,6}
     * 如果我们再次调用adjustHeap 传入的是i=0=>得到{4,9,8,5,6}=> {9,6,8,5,4}
     *
     * @param arr    需要调整的数组
     * @param i      表示第几个非叶子结点的下标
     * @param length 需要调整数组的长度，这个长度是不断减少的 --
     */
//    public static void adjustHeap(int[] arr, int i, int length) {
//        int temp = arr[i];//对应非叶子结点的值
//        int k = i * 2 + 1;//该结点的左子结点
//        if (k + 1 < length && arr[k] < arr[k + 1]) {//比较左右结点
//            k++; //此时右结点大，记录右结点的索引即可。反之记录左结点索引
//        }
//        if (temp < arr[k]) {
//            //父节点小于子结点，进行交换
//            arr[i] = arr[k];
//            arr[k] = temp;
//        }
//    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int tem = arr[i];//表示对应的非叶子节点的值
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            //这里的k是对应非叶子节点的左子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//非叶子节点的左右节点进行比较如果右节点大于左节点，那么k就要向右移动一位
            }
            if (tem < arr[k]){
                arr[i] = arr[k];//如果非叶子节点的左右节点比他大，那么就将大的值与其互换
                i = k;//然后将k的值赋给i
            }else {
                break;
            }
        }
        arr[i] = tem;//这里就是进行交换
    }

}
