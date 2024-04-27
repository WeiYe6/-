package 力扣练习;

/**
 * 删除链表节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class pro2 {
    public static void main(String[] args) {
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    /**
     * @param head
     * @param val
     * @return 删除一个节点后，返回该链表的头节点。(所以无论删除的节点是头结点还是其他节点，我们都需要返回链表的头结点head。)
     */
    public ListNode deleteNode(ListNode head, int val) {
        //如果要删除的结点为头结点
        if (head != null && head.val == val) {
            return head.next;
        }
        //找到要删除结点的前一个结点
        ListNode node = head;
        ListNode preNode = null;
        while (node.next != null) {
            if (node.next.val == val) {
                preNode = node;
                break;
            }
            node = node.next;
        }
        //出来之后,preNode即为待删除结点的前一个结点,或者为null(找不到)
        if (preNode != null) {
            if (preNode.next.next != null) {
                preNode.next = preNode.next.next;
            } else {
                preNode.next = null;
            }
        }
        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        //判断要删除的节点是否为头节点
        if (head != null && head.val == val) return head.next;
        //非头节点
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) { //不满足时，移动指针向下判断
            pre = cur;
            cur = cur.next;
        }
        if (cur != null){ //到这里，cur就是我们要删除的节点了
            pre.next = cur.next;
        }
        return head;
    }
}

