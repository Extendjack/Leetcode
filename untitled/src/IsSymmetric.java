public class IsSymmetric {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return p==q;
        }
        return (p.val==q.val)&&(isSameTree(p.left,q.right))&&(isSameTree(p.right,q.left));
    }
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left,root.right);
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