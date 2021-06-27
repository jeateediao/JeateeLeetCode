package 链表;

public class _2_两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		// 和链表头
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		ListNode p1 = l1;
		ListNode p2 = l2;
		// 进位
		int carry = 0;
		// 相加和
		int newVal = 0;
		while(p1 != null || p2 != null || carry != 0) {
			newVal = (p1 == null?0:p1.val ) + (p2 == null?0:p2.val) + carry;
			carry = newVal / 10;
			newVal = newVal % 10;
			p.next = new ListNode(newVal);
			p1 = (p1 == null ? null : p1.next);
			p2 = (p2 == null ? null : p2.next);
			p = p.next;
		}
		
		return dummy.next;
	}
}
