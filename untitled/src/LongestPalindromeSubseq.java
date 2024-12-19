import java.util.Arrays;

/**
 *给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 **/
public class LongestPalindromeSubseq {

    /**
     *  dp
     *
     *
     **/
    public int longestPalindromeSubseq(String s) {
        char[] S=s.toCharArray();
        int n=S.length;
        int[][] memo=new int[n][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dfs(0,n-1,S,memo);

    }

    private int dfs(int i, int j, char[] s, int[][] memo) {
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s[i]==s[j]){
            return memo[i][j]=dfs(i+1,j-1,s,memo)+2;
        }
        return memo[i][j]= Math.max(dfs(i+1,j,s,memo),dfs(i,j-1,s,memo));


    }
    /**
     * 递推
     *
     **/
    public int longestPalindromeSubseq2(String S) {
        char[] s=S.toCharArray();
        int n=s.length;
        int[][] f=new int[n][n];
        for(int i=n-1;i>=0;i--){
            f[i][i]=1;
            for (int j=i+1;j<n;j++){
                f[i][j]=s[i]==s[j]?f[i+1][j-1]+2:Math.max(f[i+1][j],f[i][j-1]);
            }
        }
        return f[0][n-1];


    }



}
