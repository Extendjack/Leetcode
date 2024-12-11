import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 * **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[nums.length]); // 所有排列的长度都是一样的 n
        boolean[] onPath = new boolean[nums.length];
        dfs(0,nums,ans,path,onPath);
        return ans;


    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if(i==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!onPath[j]){
                path.set(i,nums[j]);
                onPath[j]=true;
                dfs(i+1,nums,ans,path,onPath);
                onPath[j]=false;
            }
        }
    }
}
