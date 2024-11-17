/**
 * 接雨水问题  （双指针解法）
 * 思路:如果左边left的值小于right的值,i的容量只跟left边最大值max_left有关
 * 右边反之一样
 * i筒能装的水=Math.min(max_left,max_right)-height[i]
 *
 * */
public class JieWater {
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        int num = train2(arr);
        System.out.println("num:"+num);
    }
 /**
  * 双指针解法
  * **/


    public static int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int max_left = 0;
        int max_right = 0;
        int sum = 0;
        for (int i = 0; i < height.length-1; i++) {
            if (height[left - 1] < height[right+1]) {
                max_left = Math.max(height[left - 1], max_left);
                int min = max_left;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;
            } else {
                max_right = Math.max(height[right + 1], max_right);
                int min = max_right;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;

            }
        }
        return sum;

    }
/**
 * 动态规划
 *
 **/
public  static int train2(int[] height){
    int sum=0;
    int[] max_left=new int[height.length];
    int[] max_right=new int[height.length];

    for (int i=1;i<height.length-1;i++){
        max_left[i]=Math.max(max_left[i-1],height[i-1]);
    }
    for (int i=height.length-2;i>=0;i--){
        max_right[i]=Math.max(max_right[i+1],height[i+1]);
    }
    for (int i=1;i<height.length-1;i++){
        int min=Math.min(max_left[i], max_right[i]);
        if(min>height[i]){
            sum+=(min-height[i]);
        }
    }
   return  sum;



}


}
