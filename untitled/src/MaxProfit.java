import java.util.Arrays;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 **/
public class MaxProfit {
    private int[] prices;
    private int[][] memo;


    public int maxProfit(int[] prices) {
        this.prices=prices;
        int n=prices.length;
        memo=new int[n][2];
        for (int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dfs(n-1,0);

    }

    private int dfs(int i, int has) {
        if(i<0){
            return has==1?Integer.MIN_VALUE:0;
        }
        if (memo[i][has]!=-1){
            return memo[i][has];
        }
        if(has==1){
            return memo[i][has]=Math.max(dfs(i-1,1),dfs(i-1,0)-prices[i]);
        }
        return memo[i][has]=Math.max(dfs(i-1,0),dfs(i-1,1)+prices[i]);
    }
}
