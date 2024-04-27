package 力扣练习;

import java.util.Arrays;

/**
 * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。
 * 请将调整后的训练项目编号以 数组 形式返回。
 * <p>
 * 示例 1：
 * 输入：actions = [1,2,3,4,5]
 * 输出：[1,3,5,2,4]
 * 解释：为正确答案之一
 */
public class pro8 {
    public static void main(String[] args) {
        int[] actions = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(trainingPlan2(actions)));
    }

    /**
     * 方法一： 要求 偶数之间的次序不稳定
     * 思路:
     * 1.定义一个新的数组 和 两个变量，表示新数组的左 右索引，
     * 2.依次遍历原数组，并对每一个元素，%2 | &1（这种写法速度提升了一倍） 判断奇偶性
     * 3.如果为奇数，就把该值，从新数组的左边依次添加
     * 4.如果为偶数，就把该值，从新数组的右边->左边依次添加
     */
    public static int[] trainingPlan(int[] actions) {
        int[] arr = new int[actions.length];
        int l = 0, r = arr.length - 1;
        for (int action : actions) {
            int temp = action & 1;
            if (temp != 0) {//奇数
                arr[l] = action;
                l++;
            } else {
                arr[r] = action;
                r--;
            }
        }
        return arr;
    }

    /**
     * 方法二：双指针法
     * 思路:
     * 1.定义两个指针，表示原数组的 左:i 右:j 索引
     * 2.循环 while(i < j)
     * 3.从左边依次获取偶数的，
     * 4.从右边依次获取奇数的，
     * 5.然后交换这两个值，继续判断 直到i == j，说明奇数的全放在了左边，偶数的全放在了右边
     */

    public static int[] trainingPlan2(int[] actions) {
        int i = 0;
        int j = actions.length - 1;
        //循环交换
        while (i < j) {
            //左边依次获取偶数，非偶数时，继续移动获取
            while (i < j && (actions[i] & 1) != 0) i++;
            //右边依次获取奇数，非奇数时，继续移动获取
            while (i < j && (actions[j] & 1) == 0) j--;
            //出来时，说明 i索引下的值为偶数，j索引下的值为奇数了，进行交换
            int temp = actions[i];
            actions[i] = actions[j];
            actions[j] = temp;
        }
        return actions;
    }

}

