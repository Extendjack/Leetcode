import java.util.ArrayList;
import java.util.List;

public class Partition {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;
    public List<List<String>> partition(String s) {
        if(s.length()==0){
//            return List.of();
        }
        this.s=s;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int start, int i) {
        if (i==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i<s.length()-1){
            dfs(start,i+1);
        }
        if(isPalindrome(start,i)){
            path.add(s.substring(start,i+1));
           // dfs(start,i+1);
            dfs(i+1,i+1);
            path.remove(path.size()-1);

        }
    }

    private boolean isPalindrome(int left, int right) {
        char[] c=s.toCharArray();
        while (left<right){
            if (c[left++]!=c[right--]){
                return false;
            }
        }
        return true;
    }


}
