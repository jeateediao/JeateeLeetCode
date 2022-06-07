package 二叉搜索树;

public class _700_二叉搜索树中的搜索 {

    // 二叉搜索树中查找
    TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树寻找
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树寻找
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }


    // 普通二叉树中寻找
    TreeNode searchBinaryTree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode left = searchBinaryTree(root.left, target);
        TreeNode right = searchBinaryTree(root.right, target);
        return left != null ? left : right;
    }


    // 在BST中插入一个数
    TreeNode insertInfoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertInfoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertInfoBST(root.left, val);
        }
        return root;

    }


    /*
     * 情况1：node 恰好是末端节点，两个子节点都为空，那么就直接删除
     * 情况2：node 只有一个非空节点，那么它要让这个孩子接替自己
     * 情况3：node 有两个子节点，必须找到左子树中最大的节点，或者右子树中最小的那个节点来替换自己
     */

    // 在BST中删除一个数
    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 找到进行删除
        if (root.val == key) {
            // 两个 if 将 情况1和2 都处理了
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 处理情况3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;

        }else if(root.val > key) {
            // 去左子树找
            root.left = deleteNode(root.left, key);
        }else if(root.val < key) {
            // 去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
