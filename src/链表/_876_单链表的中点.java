package 链表;

// 给定一个头结点为head的非空单链表，返回链表的中间结点。
// 如果有两个中间结点，则返回第二个中间结点。

public class _876_单链表的中点 {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }

}
