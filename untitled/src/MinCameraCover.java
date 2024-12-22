public class MinCameraCover {
    public int minCameraCover(TreeNode root) {
        int[] res=dfs(root);
        return Math.min(res[0],res[2]);
    }

    private int[] dfs(TreeNode root) {
        if (root==null){
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int ch=Math.min(left[0],left[1])+Math.min(right[0],right[1])+1;
        int fa=Math.min(left[0],left[2])+Math.min(right[0],right[2]);
        int hong=Math.min(Math.min(left[0]+right[2],left[2]+right[0]),left[0]+right[0]);
        return new int[]{ch,fa,hong};
    }
}
