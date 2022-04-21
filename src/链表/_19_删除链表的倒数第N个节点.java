package 链表;

public class _19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        // 使用了虚拟头结点的技巧，也是为了防止出现空指针的情况,
        // 比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，
        // 那按照算法逻辑，应该首先找到倒数第 6 个节点,
        // 但第一个节点前面已经没有节点了，这就会出错。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findKFromEnd(dummy, n + 1);
        // 删除倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    private ListNode findKFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
