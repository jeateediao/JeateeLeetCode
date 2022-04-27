package 二叉搜索树;

public class _230_二叉搜索树中第K小的元素 {

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;

    // 二叉搜索树中第K小的元素
    int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        // 中序遍历代码位置
        rank ++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
