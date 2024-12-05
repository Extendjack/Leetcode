public class TreeMth {

    //前序遍历
    public boolean isValidBST(TreeNode root) {
       return isValidBST2(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST2(TreeNode node, long left, long right) {
        if (node==null){
            return false;
        }
        long x=node.val;
        return x>left&&x<right&&isValidBST(node,node.left.val,node.right.val);

    }
    //中序遍历
    public boolean isValidBST3(TreeNode root) {
        long pre=Long.MIN_VALUE;
      if (root==null){
          return false;
      }
      if(!isValidBST(root)&&root.val<=pre){
          return false;
      }
      pre=root.val;
      return isValidBST(root.right);


    }
    //后序遍历


    private long[] dfs(TreeNode node) {
      if (node==null){
          return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};
      }
      long[] left_v=dfs(node.left);
      long[] right_v=dfs(node.right);

      int x=node.val;
      if(left_v[1]>=x||right_v[0]<=x){
          return new long[]{Long.MIN_VALUE,Long.MAX_VALUE};
      }
      return new long[]{Math.min(left_v[0],x),Math.max(right_v[1],x)};











    }




    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
