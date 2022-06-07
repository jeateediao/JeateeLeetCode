package 二叉搜索树;


// 思路：BST的中序遍历是升序打印节点，还是中序遍历，只需要先遍历右子树，就可以变为降序访问节点
// 降序打印 BST 节点的值，如果维护一个外部累加变量 sum，然后把 sum 赋值给 BST 中的每一个节点，就将 BST 转化成累加树了

public class _538_把二叉搜索树转换为累加树 {

    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化为累加树
        root.val = sum;
        traverse(root.left);
    }
}
