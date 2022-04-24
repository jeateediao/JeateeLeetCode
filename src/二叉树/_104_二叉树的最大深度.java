package 二叉树;

public class _104_二叉树的最大深度 {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 整理树的最大深度等于左右子树的最大深度取最大值
        // 然后加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }

    int traverseForMaxDepth(TreeNode root) {
        // 记录最大深度
        int res = 0;
        // 记录遍历到的节点的深度
        int depth = 0;
        if (root == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
            return res;
        }
        // 前序位置，访问节点之前
        depth ++;
        traverseForMaxDepth(root.left);
        traverseForMaxDepth(root.right);
        // 后序位置，访问节点之后
        depth --;

        return res;
    }


    // 二叉树的遍历（前中后序）
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置 - 添加逻辑代码...
        // 时机：访问一个节点之前
        traverse(root.left);
        // 中序位置 - 添加逻辑代码...
        // 时机：访问完一个节点的左子树之后，准备访问一个节点的右子树之前
        traverse(root.right);
        // 后序位置 - 添加逻辑代码...
        // 时机：访问一个节点之后
    }

}
