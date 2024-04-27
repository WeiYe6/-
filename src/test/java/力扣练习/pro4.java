package 力扣练习;

/**
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 * <p>
 * 示例 1：
 * 输入：head = [2,4,7,8], cnt = 1
 * 输出：8
 */
public class pro4 {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //双指针 (快慢指针法)

    /**
     * @param head 链表头节点
     * @param cnt  返回倒数第几个数
     * @return 返回的节点
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head; //快指针，初始化时都指向头节点
        ListNode slow = head; //慢指针，初始化时都指向头节点
        for (int i = 0; i < cnt; i++) {
            //让快指针向前移动ctn步，那么此时 fast 和 slow就相差了cnt-1个节点 eg：链表为【1，2，3.4，5】，cnt = 2，那么我们要找的就是4，
            //fast  = 从head向前移动两步，和slow相差1个节点 fast = 3， slow = 1.
            fast = fast.next;
        }
        // 每次都让这两个指针向前移动，当fast = null时（出链表了），那么此时slow = 4，就是我们要的倒数第几个的数了
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
