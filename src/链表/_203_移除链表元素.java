package 链表;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
// 输入：head = [1,2,6,3,4,5,6], val = 6
// 输出：[1,2,3,4,5]

public class _203_移除链表元素 {
	
	public ListNode removeElements(ListNode head, int val) {

		if (head == null) {
			return null;
		}
		// 新链表的头节点
		ListNode newHead = new ListNode(0);
		// 新链表的尾节点
		ListNode newTail = newHead;
		
		while(head != null) {
			if (head.val != val) {
				newTail.next = head;
				newTail = head;
			}
			head = head.next;
		}
		newTail.next = null;
		return newHead.next;
    }
}
