public class SearchLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x=root.val;
        if(p.val>x&&q.val>x){
         return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<x&&q.val<x){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
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
