package 二叉树;

import java.util.LinkedList;

public class _297_二叉树的序列化与反序列化 {

    // 代表分隔符的字符
    String SEP = ",";
    // 代表 null 空指针的字符
    String NULL = "#";

    /*主函数， 将二叉树序列化为字符串*/
    public String serialize(TreeNode root) {
        // 用于拼接字符串
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序遍历位置
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /* 主函数：将字符串反序列化为二叉树结构 */
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树  */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
