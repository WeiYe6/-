package 力扣练习;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
 * 传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 * 注意，返回时需遵循以下规则：
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 * <p>
 * 示例 1：
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
 * <p>
 * 示例 2：
 * 输入：target = 18
 * 输出：[[3,4,5,6],[5,6,7]]
 * 解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
 */
public class pro9 {
    public static void main(String[] args) {
        int[][] ints = Solution9.fileCombination(9);
        System.out.println(Arrays.deepToString(ints));
    }
}

class Solution9 {
    /**
     * 滑动窗口法
     * 思路:
     * 1.首先定义i = 1 ，j = 2，s = i + j;
     * 2.创建一个集合，用来存放每次的结果集 (数组)
     * 3.循环判断 while(i < j)---注意 s 大于等于 target时才移动 i++(缩小窗口个数)
     * 那么 当i==j时表示一个窗口， (连续的两个窗口都大于等于目标值了，那么可以结束了 【eg: 3 4 target = 6, 缩小窗口，i = j = 4】（题目要求: 至少含有两个文件）)。
     * 4.让 s 和 target 进行比较判断
     * 4.1 s = target 时，创建一个新的数组，把i至j,的值都添加进该数组中，然后把该数组添加进集合中。
     * 4.2 移动 i++，继续判断(缩小窗口个数继续判断)，由于 s > target时，也是需要缩小窗口的，所以这里合并了 i++ ,s = s-i。
     * 4.3 s < target时，增加窗口个数。 j++ ,s = s+j；
     */
    public static int[][] fileCombination(int target) {
        int i = 1, j = 2;
        int s = i + j;
        ArrayList<int[]> ints = new ArrayList<>();
        while (i < j) {
            if (s == target) {//循环 添加进数组中
                //定义数组长度： j - i + 1：表示j -- i有多少个元素
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {//把i--->j 包含i，j之间的所有元素都添加数组中
                    arr[k - i] = k;
                }
                ints.add(arr);//把该数组添加进集合
            }
            if (s >= target) { //缩小窗口个数，注意要先减去原先的i，再缩小窗口。
                s = s - i;
                i++;
            } else { //增加窗口个数 ,注意要先增加窗口，再把j添加进来。
                j++;
                s = s + j;
            }
        }
        return ints.toArray(new int[0][]); //把集合转化为一个二维数组。
    }
}
