package 热题100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 这段代码是一个求两数之和的算法。它采用了一种常见的解法，使用哈希表来存储数组中每个元素的值和索引。首先创建一个临时数组temp
 * ，用于返回结果。然后检查输入数组nums是否为空或长度为0，如果是，则直接返回temp。
 * 接下来，创建一个HashMap对象map，用于存储数组元素的值和索引。然后遍历数组nums，对每个元素执行以下操作：
 * 1. 计算目标值与当前元素值的差值，即target - nums[i]，并将结果保存在keyTemp变量中。
 * 2. 检查哈希表map中是否包含keyTemp。如果存在，说明之前已经遍历过的某个元素的值与当前元素的值相加等于目标值。
 * 此时，将当前元素的索引i作为temp的第二个元素（temp[1] = i），将map中keyTemp对应的值作为temp的第一个元素（temp[0] = map.get(keyTemp)）。
 * 3. 将当前元素的值和索引存入哈希表map，以便后续查询。
 * 最后，返回temp数组作为结果。
 * 总的来说，这段代码利用哈希表的快速查找特性，在一次遍历中寻找满足条件的两个数的索引，并将其放入一个临时数组中返回。
 */
public class demo1 {

    public static void main(String[] args) {

        int[] nums = {2, 11, 0, 0, 7, 15};
        int[] result = twoSum(nums, 9);
        System.out.println("result = " + Arrays.toString(result));

    }


    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        if (nums == null || nums.length == 0) {
            return temp;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int keyTemp = target - nums[i]; //之前存有以这个结果为key的 那就是和这次组合的答案
            if (map.containsKey(keyTemp)){
                temp[1] = i;   //4
                temp[0] = map.get(keyTemp);//0,[2,0],以key获取value
            }
            map.put(nums[i],i);
        }
        return temp;
    }
   /* public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                   temp[0] = i;
                   temp[1] = j;
                }
            }
        }
        return temp;
    }*/
}
