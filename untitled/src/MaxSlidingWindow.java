import java.util.ArrayDeque;
import java.util.Deque;
/**
 *给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 * 滑动窗口
 *
 * **/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int n=nums.length;
     int[] ans=new int[n-k+1];
     Deque<Integer> st=new ArrayDeque<>();
      for(int i=0;i<n;i++){
          while (!st.isEmpty()&&nums[i]>=nums[st.getLast()]){
              st.removeLast();
          }
          st.addLast(i);
          if(i-st.getFirst()>=k){
              st.removeFirst();
          }
          if(i>=k-1){
            ans[i-k+1]=nums[st.getFirst()];
          }
      }
      return ans;

    }

}
