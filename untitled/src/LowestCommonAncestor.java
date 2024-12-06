public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null||root==p||root==q){
//            return null;
//        }
        if (root==null||root==p||root==q){
            return  root;
        }
        TreeNode leftN=lowestCommonAncestor(root.left,p,q);
        TreeNode rightN=lowestCommonAncestor(root.right,p,q);

//        if(leftN==p&rightN==q){
//            return root;
//        }
        if (leftN!=null||rightN!=null){
            return root;
        }
        return leftN!=null?leftN:rightN;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
