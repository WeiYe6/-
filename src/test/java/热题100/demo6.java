package 热题100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * （三数求和）
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且 不重复 的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class demo6 {

    public static void main(String[] args) {
        int[] nums = {-1, -8, 16, -8, 4, 4, 0, 1, 2, -1, -4};
        int[] nums2 = {-2, 0, 0, 2, 2};

        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    /**
     * 三数求和：去重（难点）
     * 思路:
     * 1.首先定义一个大的集合，用于装符合要求的小集合
     * 2.先将该数组进行排序（从小到大）
     * 3.外循环 ，如果该索引下的值 > 0,那么结束，因为我们已经排序好了的，当前索引大于0，说明后面的值均大于0，不可能实现三数之和等于0
     * 3.1，去重：如果当前索引的值等于前一个索引的值，那么跳到下一次循环，因为以该值打头的结果均已判断完了
     * 4.首先固定数组的第一个元素，定义左:L 右:R 两个指针,让L 和 R ， cur + arr[L+1] + arr[R] = temp, 根据temp的结果来进行移动
     * 5.如果 temp == 0 创建一个集合，并把这三个数添加进这个集合中，然后把该集合添加进大集合中。移动L++，R--；
     * 5.1 并且，再次去重判断，如果下一个值等于当前值，移动指针 L | R,因为 a+b+c=0, a b已经确定，那么c就是唯一的了
     * 6.如果temp<0 ,移动 L++ ；
     * 7.如果 temp>0, 移动 R-- ；
     * 最后返回该大集合即可。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //如果该索引下的值 > 0,那么结束
            if (nums[i] > 0) return lists;
            //去重：如果当前索引的值等于前一个索引的值，那么跳到下一次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int cur = nums[i];
            int L = i + 1, R = length - 1;
            //固定第一个元素，循环移动判断 内部
            while (L < R) {
                //三数之和
                int temp = cur + nums[L] + nums[R];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    //继续下一轮判断 （先移动再判断，比较耗时，但是便于理解） 37ms -- 反之 29ms。
                    L++;
                    R--;
                    //再次去重判断，如果当前值等于 前一个值(刚刚判断过的那个值)，移动指针 L | R,因为 a+b+c=0, a b已经确定，那么c就是唯一的了
                    while (L < R && nums[L] == nums[L - 1]) L++;
                    while (L < R && nums[R] == nums[R + 1]) R--;
                } else if (temp < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return lists;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums); //排序，从小到大
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            //如果该索引下的值大于零，表示往后的数都是大于零了，不可能会再出现 nums[i] + nums[j] + nums[k] = 0的情况
            if (nums[i] > 0) return lists;

            //* 去重: 当前值和前一个值相同时，那么往后遍历获取的步骤是一样的，以 i 这个值打头 的结果已经确定完了
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {     //tmp ---> [=0  <0  >0]如何处理
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    //第一个数 i 是固定的---> 去重：因为 a = b + c ,有两个是相等的，那么第三个一定是唯一的
                    while (L < R && nums[L + 1] == nums[L]) ++L;
                    while (L < R && nums[R - 1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (tmp < 0) { //三数之和小于0，那么要该 tmp 往大走，所以增加L.（数组经过排序是从小到大），反之减小tmp
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
}
