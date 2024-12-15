import java.util.Arrays;

public class MinDistance {
    private char[] s, t;
    private int[][] memo;
    public int minDistance(String word1, String word2) {

        s=word1.toCharArray();
        t=word2.toCharArray();
        int m=s.length;
        int n=t.length;
        memo=new int[m][n];
        for (int[] row :memo){
            Arrays.fill(row,-1);
        }
        return dfs(m-1,n-1);



    }

    private int dfs(int i, int j) {

        //如果word1比较完毕，需要计算word2的剩余字符量,进行添加
        if(i<0){
            return j+1;
        }
        // //如果word2比较完毕，需要计算word1的剩余字符量，进行删除
        if(j<0){
            return i+1;
        }

        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s[i]==t[j]){
            return memo[i][j]=dfs(i-1,j-1)+1;
        }
        // dfs(i-1,j) 代表word1删除 ,dfs(i,j-1)代表word1添加,dfs(i-1,j-1) 代表替换
        return memo[i][j]=Math.min(Math.min(dfs(i-1,j),dfs(i,j-1)),dfs(i-1,j-1))+1;
    }
}
