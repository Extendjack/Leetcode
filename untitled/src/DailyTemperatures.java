import java.util.ArrayDeque;

/**
 * 每日温度
 * 单调栈
 *
 **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i=n-1;i>=0;i--){
            int v=temperatures[i];
            while (!st.isEmpty()&&v>=temperatures[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ans;


    }


}
