import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    //选或者是不选

    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        int n=nums.length;
        if(n==0){
//            return List.of();
        }
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i==nums.length){
            ans.add(new ArrayList<>(path));
        return;
        }
        dfs(i+1);

        path.add(nums[i]);
        dfs(i+1);
        path.remove(path.size()-1);
    }


}
