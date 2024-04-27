package 力扣练习;

import java.util.Arrays;

/**
 * 螺旋遍历二维数组
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
 * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
 * <p>
 * 示例 1：
 * 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
 * 输出：[1,2,3,4,5,6,7,8,9]
 * 示例 2：
 * 输入：array = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
 * 输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 */
public class pro12 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println(Arrays.toString(spiralArray(array)));
    }

    public static int[] spiralArray(int[][] array) {
        //按照要求 从右->下->左->上 （不断收缩），难点:考虑边界问题
        //二维数组为空时
        if (array.length == 0) {
            return new int[0];
        }
        //初始化边界（索引） l:左 r:右 t:上 b:下
        int l = 0;
        int r = array[0].length - 1;
        int t = 0;
        int b = array.length - 1;
        //初始化数组，用来存放结果，大小为二维数组的最长值即可(长 * 宽)
        int[] res = new int[(r + 1) * (b + 1)];
        int x = 0;
        //循环走起来
        while (true) {
            //从左 --> 右； 上边界下移一行
            for (int i = l; i <= r; i++) {
                res[x++] = array[t][i];
            }
            //上边界下移
            t++;
            if (t > b) {
                break;
            }

            //从上 --> 下，右边界左移动一列
            for (int i = t; i <= b; i++) {
                res[x++] = array[i][r];
            }
            //右边界左移
            r--;
            if (r < l) {
                break;
            }

            //从左 --> 右，下边界上移动一行
            for (int i = r; i >= l; i--) {
                res[x++] = array[b][i];
            }
            //下边界上移
            b--;
            if (b < t) {
                break;
            }

            //从上 --> 下，左边界右移动一列
            for (int i = b; i >= t; i--) {
                res[x++] = array[i][l];
            }
            //左边界右移
            l++;
            if (l > r) {
                break;
            }
        }
        return res;
    }
}
