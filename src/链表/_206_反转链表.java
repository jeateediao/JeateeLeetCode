package 链表;


/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * */

public class _206_反转链表 {

	// 解法一：递归
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList1(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	// 解法二：非递归
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;	
	}
	
}
