import java.util.Arrays;

public class MinimumDifference {
    public static int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int ans=Integer.MAX_VALUE;
            int n=nums.length;
            for (int i=0;i+k-1<n;i++){
                ans=Math.min(ans,nums[i-k+1]-nums[i]);
            }
            return ans;
    }
}
