package 二叉树;

// 给你二叉树的根节点root, 请你将它展开为一个单链表
// - 展开后的单链表应该同样使用TreeNode, 其中right子指针指向链表中下一个节点，而left子指针始终为null;
// - 展开后的单链表应该与二叉树先序遍历顺序相同;
public class _114_二叉树展开为链表 {

    // 定义：将以root为根的树拉平为链表
    void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);
        // 后序遍历位置
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;
        // 3、将原来的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
