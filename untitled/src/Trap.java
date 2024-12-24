import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 接雨水问题 单调栈
 *
 **/
public class Trap {
    public int trap(int[] height) {
        int n=height.length;
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (!st.isEmpty()&&height[i]>=height[st.peek()]){
                int bootoomH=height[st.pop()];
                if (st.isEmpty()){
                    break;
                }
                int left=st.peek();
                int ma=Math.min(height[left],height[i])-bootoomH;
                ans+=(i-left-1)*ma;
            }
            st.push(i);
        }
        return ans;
    }
}
