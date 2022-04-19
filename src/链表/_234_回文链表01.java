package 链表;

// 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false

public class _234_回文链表01 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转后半部分（中间节点的右边部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;

        // 从rHead、lHead出发，判断是否为回文链表
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                return false;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {

        return null;
    }

    private ListNode reverseList(ListNode head) {
        return null;
    }

}
