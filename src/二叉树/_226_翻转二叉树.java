package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {

	// 递归
	TreeNode invertTreeNode(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		
		invertTreeNode(root.left);
		invertTreeNode(root.right);
		
		return root;
	}
	
	
	// 层序遍历
	TreeNode invertTreeNode2(TreeNode root) {
		if (root == null) return root;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmpNode = node.left;
			node.left = node.right;
			node.right = tmpNode;
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
	
	
}
