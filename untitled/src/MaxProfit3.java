import java.util.Arrays;

/**
 *
 *给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 **/

public class MaxProfit3 {
    private int[] prices;
    private int[][][] memo;
    public int maxProfit(int k, int[] prices) {

        this.prices=prices;
        int n=prices.length;
        memo=new int[n][k+1][2];
        for (int[][] m1:memo){
            for (int[] row:m1){
                Arrays.fill(row,-1);
            }
        }
        return dfs(n-1,k,0);

    }

    private int dfs(int i, int k, int has) {
        if (k<0){
            return Integer.MIN_VALUE/2;
        }
        if (i<0){
            return has==1?Integer.MIN_VALUE/2:0;
        }
        if(memo[i][k][has]!=-1){
            return memo[i][k][has];
        }
        if(has==1){
        return memo[i][k][has]=Math.max(dfs(i-1,k,1),dfs(i-1,k-1,0)-prices[i]);
        }
        return memo[i][k][has]=Math.max(dfs(i-1,k,0),dfs(i-1,k,1)+prices[i]);
    }



}
