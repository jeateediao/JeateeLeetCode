package 链表;

// 输入一个链表，输出该链表中倒数第k个节点，为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
// 返回链表 4->5.

public class _22_链表中倒数第k个节点 {
    // 返回链表的倒数第 k 个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while(p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
