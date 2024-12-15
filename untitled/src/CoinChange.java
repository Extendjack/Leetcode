import java.util.Arrays;

/**
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * **/
public class CoinChange {
    private int[] coins;
    private int[][] memo;
    public int coinChange(int[] coins, int amount) {
        this.coins=coins;
        int n=coins.length;
        memo=new int[n][amount+1];
        for (int[] row:memo){
            Arrays.fill(row,-1);
        }
        int ans=dfs(n-1,amount);
        return ans<Integer.MAX_VALUE/2?ans:-1;


    }

    private int dfs(int i, int amount) {
        if(i<0){
            return amount==0?0:Integer.MAX_VALUE/2;
        }
        if(memo[i][amount]!=-1){
            return memo[i][amount];
        }
        if(amount<coins[i]){
            return dfs(i-1,amount);
        }
        return memo[i][amount]=Math.min(dfs(i-1,amount),dfs(i,amount-coins[i])+1);
    }
}
