package 链表;


// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
// 图示两个链表在节点 c1 开始相交：

public class _160_相交链表 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
			return null;
		}
		
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
			curA = (curA == null) ? headB : curA.next; 
			curB = (curB == null) ? headA : curB.next;
			
			// 这段代码在两个链表不相交的时候会死循环
			// curA = (curA.next == null) ? headB : curA.next; 
			// curB = (curB.next == null) ? headA : curB.next;
		}
		return curA;
    }

}
