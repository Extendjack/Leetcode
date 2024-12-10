import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法的剪枝
 *
 *
 * **/
public class Combine {
    private int k;
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
          this.k=k;
          dfs(n);
          return ans;
    }

    private void dfs(int n) {
        int d=k-path.size();
        if(d==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j=n;j>=d;j--){
            path.add(j);
            dfs(j-1);
            path.remove(path.size()-1);
        }
    }


}
