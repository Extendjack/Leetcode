import java.util.Arrays;

/**
 *你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 * ***/

public class Rob {
    int[] meo,nums;
    public int rob(int[] nums) {
        this.nums=nums;
        int n=nums.length;
        meo =new int[n];
        Arrays.fill(meo,-1);
        return dfs(n-1);
    }

    private int dfs(int i) {
        if(i==0){
            return 0;
        }
        if(meo[i]!=-1){
            return meo[i];
        }
        int res=Math.max(dfs(i-1),dfs(i-2)+nums[i]);
        meo[i]=res;
        return res;
    }

}
