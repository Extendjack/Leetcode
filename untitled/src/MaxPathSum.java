/**
 *二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 **/

public class MaxPathSum {
    private  int ans=Integer.MIN_VALUE;
    //当root=[-3]时，输出为0   ans=Math.max(ans,leftA+rightA+root.val) 因为节点有可能出现负数
    //private int ans;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int  dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftA=dfs(root.left);
        int rightA=dfs(root.right);
        ans=Math.max(ans,leftA+rightA+root.val);
        return Math.max(Math.max(leftA,rightA)+root.val,0);
    }


}
