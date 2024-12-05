public class IsBalanced {

    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        //用-1代表不平衡
        int leftH=getHeight(root.left);
        if(leftH==-1)return -1;
        int rightH=getHeight(root.right);
        if(rightH==-1||Math.abs(leftH-rightH)>1)return -1;
        return Math.max(rightH,leftH)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return  getHeight(root)!=-1;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
