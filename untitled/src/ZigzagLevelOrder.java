import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> vals=new ArrayList<>();
            int n=q.size();
            while (n-->0){
                TreeNode node=q.poll();
                vals.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            if(ans.size()%2>0) Collections.reverse(vals);
            ans.add(vals);
        }
        return ans;
    }
}
