package 力扣练习;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 */
public class pro7 {
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution7 {
    /**
     * 利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，
     * 再遍历构建新链表各节点的 next 和 random 引用指向即可。
     * 思维:
     * 1.先把该链表的节点一一copy下来，存入map中[该节点，该节点的值]。
     * 2.然后把copy下来的新链表的next 和 random一一改为原链表的引用指向。
     * 3.最后返回该新链表的头节点
     */
    public Node copyRandomList(Node head) {
        //如果链表为空
        if (head == null){
            return null;
        }
        //定义一个哈希表(map[node,node.val])
        Map<Node,Node> map = new HashMap<>();
        //定义指针
        Node cur = head;
        //一一把原链表复制下来,并建立，【key 原节点： value 新节点（保存原节点的值）】
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //构建新链表的next 和 random指向
        cur = head;//重新获取头节点
        while (cur != null){
            map.get(cur).next = map.get(cur.next); //构建next指向
            map.get(cur).random = map.get(cur.random); //构建random指向
            cur = cur.next;
        }
        //返回链表头节点
        return map.get(head);
    }

    //方法二
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        // 第一步：在每个节点后面创建一个新节点，并将其插入到原节点的后面
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // 第二步：设置新节点的random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 第三步：将新节点从原链表中拆分出来，恢复原始链表和新链表
        cur = head;
        Node newHead = cur.next;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            cur = cur.next;
        }

        return newHead;
    }
}
