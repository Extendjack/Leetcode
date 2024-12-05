import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        getDepth(root,ans,0);
        return  ans;
    }

    private void getDepth(TreeNode root, List<Integer> ans, int depth) {
      if(root==null){
          return;
      }
      if(depth==ans.size()){
          ans.add(root.val);
      }
      getDepth(root.right,ans,depth+1);
      getDepth(root.left,ans,depth+1);

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

