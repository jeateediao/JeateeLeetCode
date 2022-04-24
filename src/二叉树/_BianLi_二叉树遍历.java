package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _BianLi_二叉树遍历 {

    // 定义：输入一颗二叉树的根节点，返回这棵树的前序遍历结果
    // 一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果
    List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历结果，root.val在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse(root.left));
        // 利用函数定义，后面接着右子树的前序遍历结果
        res.addAll(preorderTraverse(root.right));
        return res;
    }


    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
    void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 从上到下遍历二叉树的每一层
        while(!q.isEmpty()) {
            int size = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // 将下一层的节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }

}
