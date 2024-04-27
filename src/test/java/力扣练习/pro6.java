package 力扣练习;

/**
 * 某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两
 * 套计划仅有前半部分热身项目不同，后续正式训练项目相同。请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
 * 在节点 c1 开始相交。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 解释：第一个正式训练项目编号为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，
 * 链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例2：
 * <p>
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 解释：第一个正式训练项目编号为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，
 * 链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：两套计划完全不同，返回 null。从各自的表头开始算起，
 * 链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 */
public class pro6 {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution6 {
    /**
     * 假设链表A（长度为:a） 和 链表B（长度为:b），第一个重叠的节点为node(重叠部分长度为：c)
     * 1.同时遍历链表A、和链表B，当链表A遍历完时，进入链表B进行遍历
     * 结果：遍历长度为: Al = a + (b - c)
     * <p>
     * 2.同时遍历链表B、和链表A，当链表B遍历完时，进入链表A进行遍历
     * 结果：遍历长度为: Bl = b + (a - c)
     * ------------------
     * 两结果相等 Al = Bl
     * 有两种情况：
     * 1.A、B链表有相同的节点，遍历到相同节点时，A==B = node　返回A（B随便一个）；
     * 1.A、B链表无相同的节点，遍历到相同节点时, A==B = null 返回A（B随便一个）；
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //定义链表A、B
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }

        return A;
    }


}
