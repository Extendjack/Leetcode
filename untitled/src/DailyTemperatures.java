import java.util.ArrayDeque;

/**
 * 每日温度
 * 单调栈
 *
 **/
public class DailyTemperatures {
    /**
     *从右到左
     *
     **/
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();

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
    /**
     * 从左到右
     **/

    public int[] dailyTemperatures2(int[] temperatures) {
     int n=temperatures.length;
     int[] ans=new int[n];
     ArrayDeque<Integer> st=new ArrayDeque<>();
     for(int i=0;i<n;i++){
         int v=temperatures[i];
         while (!st.isEmpty()&&v>=temperatures[st.peek()]){
             int j=st.pop();
             ans[i]=i-j;
         }
         st.push(i);
     }
     return ans;

    }




}
