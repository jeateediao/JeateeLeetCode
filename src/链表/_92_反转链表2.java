package 链表;

public class _92_反转链表2 {
	
	// 递归反转一个链表
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;	
		ListNode last = reverseList(head.next);
		// head.next成为了尾节点，断开和head的联系
		head.next.next = head;
		head.next = null;
		return last;	
	}
	
	// 反转链表的前n个节点
	public ListNode reverseListN(ListNode head, int n) {
		
		ListNode successor = null;
		if(n == 1) {
			// 记录第n+1个节点
			successor = head.next;
			return head;
		}
		// 以 head.next 为起点，需要反转前 n-1 个节点
		ListNode last = reverseListN(head.next, n-1);
		head.next.next = head;
		// 让反转之后的head节点和后面的节点连起来
		head.next = successor;
		return last;
	}
	
	
	// 反转链表的一部分
	public ListNode reverseListBetween(ListNode head, int m, int n) {
		// base case: 就相当于反转前n个
		if(m == 1) {
			return reverseListN(head, n);
		}
		head.next = reverseListBetween(head.next, m-1, n-1);
		return head;
	}
	
	
}


