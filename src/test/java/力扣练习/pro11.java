package 力扣练习;


import java.util.HashSet;

/**
 * 寻找文件副本
 * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
 * <p>
 * 示例 1：
 * 输入：documents = [2, 5, 3, 0, 5, 0]
 * 输出：0 或 5
 */
public class pro11 {
}

class Solution11 {

    public static void main(String[] args) {
        int[] documents = {2, 5, 3, 0, 5, 0};
        int repeatDocument = findRepeatDocument2(documents);
        System.out.println(repeatDocument);
    }

    /**
     * 方法一：暴力解法
     * 思路:
     * 1.循环原数组，依次获取原数组中的每一个元素
     * 2.继续内层循环原数组，但添加一个条件，去除外层循环中的索引(不能和自己进行判断)
     * 3.在内层循环中，和除了自己以外的其它元素，进行一一的比较判断，如果有遇到和外层循环相同的元素，直接返回该元素，否则，进行下个元素的判断。
     */
    public static int findRepeatDocument1(int[] documents) {
        for (int i = 0; i < documents.length; i++) {
            for (int j = 0; j != i && j < documents.length; j++) {
                if (documents[j] == documents[i]) {
                    return documents[j];
                }
            }
        }
        return -1;
    }

    /**
     * 方法二：哈希表法
     * 1.定义一个HashSet (特征:元素不能重复)
     * 2.依次遍历原数组，并进行判断，如果该元素已经在hashset中，直接返回该元素，否则添加进hashset中
     */
    public static int findRepeatDocument2(int[] documents) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int document : documents) {
            if (hashSet.contains(document)) return document;
            hashSet.add(document);
        }
        return -1;
    }
}
