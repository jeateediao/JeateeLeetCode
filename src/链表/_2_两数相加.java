package 链表;

// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头

public class _2_两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		// 和链表头
		ListNode dummy = new ListNode(-1);
		ListNode last = dummy;
		// 进位
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int v1 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			int v2 = 0;
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}

			int sum = v1 + v2 + carry;
	
			// 设置进位值
			carry = sum / 10;
			// sum的个位数作为新节点的值
			last.next = new ListNode(sum % 10);
			last = last.next;
		}
		
		// 检查最后的进位
		if (carry > 0) {
			// carry == 1
			last.next = new ListNode(carry);
		}
		
		return dummy.next;
	}
}
