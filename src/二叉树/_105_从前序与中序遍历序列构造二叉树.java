package 二叉树;

import java.util.HashMap;

// 二叉树构造问题思路：构造整棵树 = 根节点 + 构造左子树 + 构造右子树
public class _105_从前序与中序遍历序列构造二叉树 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i< inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootVal) {
//                index = i;
//                break;
//            }
//        }
        int leftSize = index - inStart;
        // 构造根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左子树
        root.left =  build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        // 递归构造右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

}
