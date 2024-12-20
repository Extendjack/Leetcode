

/**
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 *
 * 链：从子树中的叶子节点到当前节点的路径。把最长链的长度，作为 dfs 的返回值。根据这一定义，空节点的链长是 −1，叶子节点的链长是 0。
 * 直径：等价于由两条（或者一条）链拼成的路径。我们枚举每个 node，假设直径在这里「拐弯」，也就是计算由左右两条从下面的叶子节点到 node 的链的节点值之和，去更新答案的最大值。
 *
 *
 *
 **/

public class DiameterOfBinaryTree {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root) {
        if (root==null){
            return -1;
        }
        int leftLen=dfs(root.left)+1;//左子树的最长链
        int rightLen=dfs(root.right)+1;//右子树的最长链
        ans=Math.max(ans,rightLen+leftLen);
        return Math.max(leftLen,rightLen);//当前子树的最长链长

    }

}
