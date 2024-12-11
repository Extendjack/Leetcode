import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * N皇后问题
 *
 **/
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n]; // 皇后放在 (r,queens[r])
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];

        dfs(0, queens, col, diag1, diag2, ans);
        return ans;
    }

    private void dfs(int i, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {

          int n= col.length;
          //用字符串表示放置的方法
          if(i==n){
              List<String> board=new ArrayList<>(n);
              for (int c:queens){
                  char[] row=new char[n];
                  Arrays.fill(row,'.');
                  row[c]='Q';
                  board.add(new String(row));
              }
              ans.add(board);
              return;
          }
          for (int c=0;c<n;c++){
              int ic=i-c+n-1;
              if(!col[c]&&!diag1[i+c]&&!diag2[ic]){ //两条斜线和列都没有放
                  queens[i]=c;
                  col[c]=diag1[i+c]=diag2[ic]=true;//两条斜线和列  i+c  i-c 代表两条斜线
                  dfs(i+1,queens,col,diag1,diag2,ans);
                  col[c]=diag1[i+c]=diag2[ic]=false;
              }
          }
    }
}
