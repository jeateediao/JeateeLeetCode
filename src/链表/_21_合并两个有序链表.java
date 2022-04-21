package 链表;

public class _21_合并两个有序链表 {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        // l2遍历完了，但是l1还没完
        if (p1 != null) {
            p.next = p1;
        }
        // l1遍历完了，但是l2还没完
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
