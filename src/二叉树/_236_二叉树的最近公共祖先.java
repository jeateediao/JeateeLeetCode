package 二叉树;

import apple.laf.JRSUIUtils;

public class _236_二叉树的最近公共祖先 {


    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root, p.val, q.val);
    }

    TreeNode findLowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        // 前序位置
        if (root.val == val1 || root.val == val2) {
            // 如果遇到目标值，直接返回，目标值为LCA
            return root;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是LCA节点
            return root;
        }
        return left != null ? left : right;
    }

    // 定义：在以 root 为根的二叉树中寻找值为 val1 或 val2 的节点
    TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        // 前序位置，看看root是不是目标值
        if (root.val == val1 || root.val == val2) {
            return root;
        }

        // 去左右子树寻找
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // 后序位置，已经知道左右子树是否存在目标值
        return left != null ? left : right;
    }

    // 二叉树中寻找一个元素
    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        // 前序位置
        if (root.val == val) {
            return root;
        }

        // root不是目标节点，去左右子树寻找
        TreeNode left = find(root.left, val);
        TreeNode right = find(root.right, val);

        // 看看哪边找到了
        return left != null ? left : right;
    }

}
