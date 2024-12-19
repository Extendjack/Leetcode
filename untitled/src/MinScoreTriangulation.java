import java.util.Arrays;
/**
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 *
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 *
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 *
 * 解题思路：区间dp
 *
 *
 * **/
public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
         int n=values.length;
         int[][] memo=new int[n][n];
         for (int[] row:memo){
             Arrays.fill(row,-1);
         }
         return dfs(0,n-1,values,memo);
    }

    private int dfs(int i, int j, int[] values, int[][] memo) {
        if(i+1==j){
            return 0;
        }
        if (memo[i][j]!=-1){
            return memo[i][j];
        }
        int res=Integer.MAX_VALUE;
        for (int k=i+1;k<j;k++){
            res=Math.min(res,dfs(i,k,values,memo)+dfs(k,j,values,memo)+values[i]*values[k]*values[j]);
        }
        return memo[i][j]=res;
    }
}
