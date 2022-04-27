package 二叉树;

// 给定一个不重复的整数数组nums 。
// 最大二叉树可以用下面的算法从nums 递归地构建:
// 创建一个根节点，其值为nums 中的最大值。
// 递归地在最大值左边的子数组前缀上构建左子树。
// 递归地在最大值右边的子数组后缀上构建右子树。
// 返回nums 构建的 最大二叉树 。

public class _654_最大二叉树 {
    public TreeNode cosntructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int low, int high) {
        // base case
        if (low > high) {
            return null;
        }
        // 找到数组中的最大值和对应的索引
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 递归构造左右子树
        root.left = build(nums, low, index);
        root.right = build(nums, index + 1, high);

        return root;
    }

}
