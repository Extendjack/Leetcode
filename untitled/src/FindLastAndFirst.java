/**
 * 二分查找
 * >=x  =====>
 * >x   =====>  >= x+1
 * <x  =======>  (>= x)-1
 * >=x =======>   (>x)-1
 *
 *
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 这个就是求 >= 和 <=
 *
 *
 * **/


public class FindLastAndFirst {
    public int[] searchRange(int[] nums, int target) {
      int start=leftM(nums,target);
      if(start==nums.length||nums[start]!=target){
          return new int[]{-1,-1};
      }
      int end=leftM(nums,target+1)-1;
      return new int[]{start,end};
    }

    public int leftM(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            } else  {
                right=mid-1;
            }
        }
        return left;
    }


}
