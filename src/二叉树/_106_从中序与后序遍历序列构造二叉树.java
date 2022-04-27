package 二叉树;

import java.util.HashMap;

public class _106_从中序与后序遍历序列构造二叉树 {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(inorder[rootVal]);
        // 左子树 size
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        // 递归构建左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}
