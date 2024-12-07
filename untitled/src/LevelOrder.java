import java.util.*;

public class LevelOrder {
    //两个队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return List.of();
        List<List<Integer>> ans=new ArrayList<>();
        List<TreeNode> cur=List.of(root);
        while (!cur.isEmpty()){
            List<Integer> vals=new ArrayList<>();
            List<TreeNode> nxt=new ArrayList<>();
            for (TreeNode node:cur){
                vals.add(node.val);
                if(node.left!=null)nxt.add(node.left);
                if(node.right!=null)nxt.add(node.right);
            }
            cur=nxt;
            ans.add(vals);
        }
        return ans;
    }
    //一个队列
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root==null) return  List.of();
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int n=q.size();
            List<Integer> vals=new ArrayList<>(n);
            while (n-->0){
                TreeNode node=q.poll();
                vals.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            ans.add(vals);
        }
        return ans;
    }

}
