package 力扣练习;

/**
 * 给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
 * 注意：新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class pro5 {
    public static void main(String[] args) {

    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution5 {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        //创建一个新链表，用于存储l1 l2链表合并后的节点
        ListNode newListNode = new ListNode(0);//给头节点赋值为0
        ListNode temp = newListNode;//创建指针（用于遍历和连接节点）
        while (l1 != null && l2 != null){//因为l1,l2为有序链表，当有一条链表放置完时，另一链表的值直接按顺序放置进新链表即可。
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        //精华：注意！这里，当有其中一条链表放置完时，那么，新链表继续放置未放置完的那条链表的下一个节点即可（不用循环放置，因为该节点之后的节点未断，
        // 是连接在放置那个节点之后的！！！）
        temp.next = l1 != null ? l1 : l2;

        return newListNode.next; //头节点不需要返回
    }
}
