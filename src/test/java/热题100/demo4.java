package 热题100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class demo4 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 0, 1, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 反向思维：
     * (把非0的数往前搬，然后从搬运点结束开始，把后面的全部置为0)
     * 1.把非0的数，全部收集起来 -> temp，按照数组本来的相对顺序，从0索引开始放，遇到0跳过，继续寻找非0的数，反复操作，直至非0数全部放置好。
     * 2.那么此时，原数组中剩下的就全都是0了，直接把该数组从temp开始 --- 至数组长度都置为0即可
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp] = nums[i];
                temp++;
            }
        }
        //到这里，nums数组非0的数组就排序好了，只需要把后面的空位全部补0即可
        for (int i = temp; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 指针法，一个指向0，一个指向非0，然后，判断0是否在非0的左边，如果满足，交换位置(把非0往前移动，后面的置为0，直至后面的全为0 )
     * <p>
     * 注意：任何时候都不能忽略索引越界的发生。！！！！！
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int zero = 0;
        while (zero < nums.length && nums[zero] != 0) {
            zero++;
        }
        //zero指针，已经指向了第一个0的位置
        for (int unZero = 0; unZero < nums.length; unZero++) {
            if (zero < unZero && nums[unZero] != 0) {//满足：0在非0的左边，交换位置
                nums[zero] = nums[unZero];//把非0数字往前移
                nums[unZero] = 0;
                zero++;
            }

        }
    }
}
