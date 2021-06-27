package 链表;

public class _25_k个一组反转链表 {
	//反转链表，迭代
	public ListNode reverseList(ListNode head) {
		ListNode pre, cur, nxt;
		pre = null;
		cur = head;
		nxt = head;
		while(cur != null) {
			nxt = cur.next;
			// 逐个节点反转
			cur.next = pre;
			// 更新指针位置
			pre = cur;
			cur = nxt;
		}
		// 返回反转后的头节点
		return pre;	
	}
	
	// 反转区间[a, b)的元素，注意是左闭右开
	public ListNode reverse(ListNode a, ListNode b) {
		ListNode pre, cur, nxt;
		pre = null;
		cur = a;
		nxt = a;
		
		while(cur != b) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
	
	// k个一组反转链表
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) return head;
		// 区间[a, b)包含k个元素待反转元素
		ListNode a, b;
		a = b = head;
		for (int i = 0; i < k; i++) {
			// 不足k个，不需要反转，base case
			if(b == null) return head;
			b = b.next;
		}
		// 反转前k个元素
		ListNode newHead = reverse(a, b);
		// 递归反转后续链表并链接起来
		a.next = reverseKGroup(b, k);
		return newHead;
	}
	
}
