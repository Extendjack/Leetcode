/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 *
 * 滑动窗口思想
 *
 * **/

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
       int left=0;
       int sum=0;
       int result=Integer.MAX_VALUE;
       for(int right=0;right<nums.length;right++){
           sum+=nums[++right];
           while (sum>=target){
               result=Math.min(result,right-left+1);
               sum-=nums[left++];
           }
       }
        return result==Integer.MAX_VALUE?0:result;



    }
}
