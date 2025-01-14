import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySum {
    public static  void main(String[] args){
        int[] test=new int[]{1,5,4,2,9,9,9};
        int k=3;
        long re=maximumSubarraySum(test,k);
        System.out.println("结果："+re);
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        //TODO int 比long范围小  数组比较大的话，会报错
//        int sum=0;
//        int maxSum=0;
         long sum=0;
         long maxSum=0;

        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.merge(nums[i],1,Integer::sum);
            if(i<k-1){
                continue;
            }
            if(map.size()==k){
                maxSum=Math.max(sum,maxSum);
            }
            int out=nums[i-k+1];
            sum-=out;
            if(map.merge(out,-1,Integer::sum )==0){
                map.remove(out);
            }
        }
        return maxSum;

    }
}
