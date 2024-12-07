import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)return -1;
        TreeNode node=root;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()){
             node=q.poll();
            if(node.right!=null)q.add(node.right);
            if(node.left!=null)q.add(node.left);
        }
        return node.val;

    }
}
