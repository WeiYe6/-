package 力扣练习;

/**
 * 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class pro3 {
    public static void main(String[] args) {

    }


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
class Solution3 {

    //迭代法  （双指针）
    //在访问各节点时修改 next 引用指向
    public ListNode trainningPlan1(ListNode head) {
        ListNode cur = head; //当前节点
        ListNode pre = null; //下一个节点的引用指向
        while (cur != null) {
            ListNode temp = cur.next; //用于记录当前节点的下一个节点
            cur.next = pre; //用于改变当前节点的引用指向
            pre = cur;     //改变引用指向
            cur = temp;  //当前节点移向下一个节点
        }
        return pre;//pre为反转之后链表的头节点
    }

    //递归法

    /**
     * 考虑使用递归遍历链表，当越过尾节点后终止递归，在回溯时修改各节点的 next 引用指向。
     * recur(cur, pre) 递归函数：
     * 终止条件：当 cur 为空，则返回尾节点 pre （即反转链表的头节点）；
     * 递归后继节点，记录返回值（即反转链表的头节点）为 res ；
     * 修改当前节点 cur 引用指向前驱节点 pre ；
     * 返回反转链表的头节点 res ；
     */
    public ListNode trainningPlan2(ListNode head) {
        return recur(head, null);
    }
    /**
     * 递归反转链表，回溯阶段时并修改节点引用指向
     * @param cur
     * @param pre
     * @return
     */
    public ListNode recur(ListNode cur, ListNode pre) {
        //递归结束条件
        if (cur == null) {
            return pre; //结束时，pre为链表的最后一个节点，所以从最后一个节点开始回溯
        }
        //不断递归,并且记录本次递归的节点
        ListNode  res = recur(cur.next, cur);
        //修改节点指向引用
        cur.next = pre;//   把当前节点的next指向回溯阶段的pre（即为上一个节点）
        return res; //返回每次递归后的哪个节点 cur最后一个结点

    }


}
