import java.util.Arrays;
/**
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * **/

public class FindTargetSumWays {

    private int[] nums;
    private int[][] memo;


    public int findTargetSumWays(int[] nums, int target) {
        int s=0;
        for (int nm:nums){
            s+=nm;
        }
        s-=Math.abs(target);
        if(s<0||s%2!=0){
            return 0;
        }
        int m=s/2;  //背包容量

        this.nums=nums;
        int n=nums.length;
        memo=new int[n][m+1];
        for (int[] row :memo){
            Arrays.fill(row,-1);
        }
       return dfs(n-1,m);
    }

    private int dfs(int i, int c) {
        if(i<0){
            return c==0?1:0;
        }
        if(memo[i][c]!=-1){
            return memo[i][c];
        }
        if(c<nums[i]){
            return memo[i][c]=dfs(i-1,c);
        }
        return memo[i][c]=dfs(i-1,c)+dfs(i-1,c-nums[i]);
    }
}
