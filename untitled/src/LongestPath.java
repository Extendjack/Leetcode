import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPath {
    //用于存储图的邻接表表示。
    private List<Integer>[] g;
    private char[] s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        this.s = s.toCharArray();
        int n=parent.length;
        g=new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        //构建图的邻接表，parent[i] 表示节点 i 的父节点，将节点 i 添加到其父节点的子节点列表中。
        for (int i=1;i<n;i++){
          g[parent[i]].add(i);
        }
        dfs(0);
        //由于 dfs 方法返回的是路径长度减1，所以这里需要加1。
        return ans+1;

    }

    private int dfs(int x) {
        int maxLen=0;
        //遍历当前节点 x 的所有子节点。
        for (int y : g[x]) {
            //对于每个子节点 y，递归调用 dfs 方法计算从 y 到叶节点的最长路径长度，并加1（因为包括当前节点）
            int len=dfs(y)+1;
            if(s[x]!=s[y]){
                //更新全局最长路径 ans 和局部最长路径 maxLen。
                ans=Math.max(ans,maxLen+len);
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }


}
