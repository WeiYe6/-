package 力扣练习;

/**
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，
 * 就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
 * 示例 1：
 * 输入：head = [3,6,4,1]
 * 输出：[1,4,6,3]
 */
public class pro1 {

    public static void main(String[] args) {
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution1 {
    public int[] reverseBookList(ListNode head) {
        //获取链表长度，用于定义数组的初始长度
        int size = 0;
        ListNode node = head;
        while (node != null){
            size++;
            node = node.next;
        }
        int[] arr = new int[size];
        node  = head;
        //获取链表的最后一个结点，(并赋值给数组的0索引) ---(此方法只能获取到最后一个结点，不能回到前结点，行不通！)
        //反向思维：依次获取链表的结点，并放置在数组的末端索引。
        //注意:size为链表的长度，所以最后一个索引为: size = size - 1;
        while (node != null){
            arr[--size] = node.val;
            node = node.next;
        }
        return arr;
    }
}
