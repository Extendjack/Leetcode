import java.util.ArrayList;
import java.util.List;

/***
 *
 *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 ***/

public class GenerateParenthesis {
    private int n;
    private final List<String> ans = new ArrayList<>();
    private char[] path;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2]; // 所有括号长度都是一样的 n*2
        dfs(0, 0);
        return ans;
    }

    // i = 目前填了多少个括号
    // open = 左括号个数，i-open = 右括号个数
    private void dfs(int i, int open) {
        if (i == n * 2) { // 括号构造完毕
            ans.add(new String(path)); // 加入答案
            return;
        }
        if (open < n) { // 可以填左括号
            path[i] = '('; // 直接覆盖
            dfs(i + 1, open + 1); // 多了一个左括号
        }
        if (i - open < open) { // 可以填右括号
            path[i] = ')'; // 直接覆盖
            dfs(i + 1, open);
        }
    }


}
