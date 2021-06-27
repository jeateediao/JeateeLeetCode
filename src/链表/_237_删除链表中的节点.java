package 链表;
/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 
 * */

public class _237_删除链表中的节点 {
	
	// 思路：用Node的下一个节点替换删除的节点
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
