package 力扣练习;

import java.util.Arrays;

/**
 * 按规则计算统计结果
 * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，
 * 其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，
 * 其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的 其他数量的乘积。
 * <p>
 * 示例 1：
 * 输入：arrayA = [2, 4, 6, 8, 10]
 * 输出：[1920, 960, 640, 480, 384]
 */
public class pro10 {
}

class Solution10 {

    public static void main(String[] args) {
        int[] arrayA = {2, 4, 0, 8, 10};
        int[] arr = constructArr(arrayA);
        int[] result = statisticalResult(arrayA);
        System.out.println(Arrays.toString(arr));
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * 计算数组中该索引值下的数值，除了自己以外的其它索引下的值的乘积，(难点: 考虑0，分母不能除以0)，所以不能使用除法【获取所有乘积 / 当前值 X】。
     * 然后把该值 添加进新的数组中。
     * 1.获取该数组 索引值之前（不包括自己）的所有元素的乘积(循环获取)
     * 2.获取该数组 索引值之后（不包括自己）的所有元素的乘积(循环获取)，并与之前的值(该索引值之前的所有乘积)相乘，
     * 就是该索引 统计结果的结果了，并添加新新数组中。
     */
    public static int[] statisticalResult(int[] arrayA) {
        //创建新数组，用于保存统计的结果集
        int[] arr = new int[arrayA.length];
        //1.循环获取该索引值之前的数值的所有乘积
        for (int i = 0, p = 1; i < arrayA.length; i++) {
            //第一个数值，前面没有值，所以记为1
            arr[i] = p;
            p = p * arrayA[i]; //累乘
        }
        //2.循环获取该索引值之后的数值的所有乘积，并和该索引值 之前的乘积相乘,添加进数组中
        for (int i = arrayA.length -1, p = 1; i >=0 ; i--) {
            //最后一个数值，后面没有值，所以记为1
            arr[i] = arr[i] * p; //该数值之前的乘积 * 该数值之后的乘积
            p = p * arrayA[i];
        }
        return arr;
    }


    /**
     * 思路:
     * 该方法使用两个循环来计算结果数组。
     * 首先，第一个循环从左到右遍历原始数组 a，计算当前元素之前（不包括当前元素）所有元素的乘积，并将结果存储到结果数组 ans 中。
     * 具体而言，变量 p 初始化为1，然后对于每个索引 i，将 p 赋值给 ans[i]，并将 p 乘以 a[i]，以便在下一次迭代中使用更新的值。
     * <p>
     * 接下来，第二个循环从右到左遍历原始数组 a，计算当前元素之后（不包括当前元素）所有元素的乘积，
     * 并将结果乘以结果数组 ans 中相应位置的值。与第一个循环类似，变量 p 初始化为1，然后对于每个索引 i，将 p 乘以 a[i]，
     * 并将乘积赋值给 ans[i]，最终得到正确的结果。
     */
    public static int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        //第一个循环：计算当前元素之前所有元素的乘积
        for (int i = 0, p = 1; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }
        //第二个循环：计算当前元素之后所有元素的乘积，并与之前的结果相乘
        for (int i = a.length - 1, p = 1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }
        return ans;
    }
}
