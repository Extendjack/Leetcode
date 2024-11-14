public class Water {
    public static void main(String[] args) {

    }
   /**
    * 双指针方法，得出面积最大的区域
    *
    * **/
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
         int area=(right-left)*Math.min(height[left],height[right]);
         ans=Math.max(area,ans);
         if(height[left]<height[right]){
             left++;
         }else {
             right--;
         }

        }
        return ans;
    }
}