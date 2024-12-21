public class Rob2 {
    public int rob(TreeNode root) {
        int[] ans=dfs(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root==null){
            return new int[]{0,0};
        }
        int[] leftM=dfs(root.left);
        int[] rightM=dfs(root.right);
        int y=(leftM[1]+rightM[1]+root.val);
        int n=Math.max(leftM[0],leftM[1])+Math.max(rightM[1],rightM[0]);
        return new int[]{y,n};


    }

}
