/**
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 **/
public class LengthOfLIS {

    private int[] nums;
    private int[] memo;
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        int n=nums.length;
        memo=new int[n];
        int ans=0;
        for (int i=0;i<n;i++){
            ans=Math.max(ans,dfs(i));
        }
        return ans;

    }

    private int dfs(int i) {
        if (memo[i]>0){
            return memo[i];
        }
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]) {
                memo[i] = Math.max(memo[i], dfs(j));
            }
        }
        return ++memo[i];
    }
}
