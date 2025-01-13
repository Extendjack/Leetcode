import java.util.HashMap;

public class MaxSum {
    /**
     *给你一个整数数组 nums 和两个正整数 m 和 k 。
     *
     * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
     *
     * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
     *
     * 子数组指的是一个数组中一段连续 非空 的元素序列。
     *
     *
     **/

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> cnt=new HashMap<>();
        long ans=0;
        long sum=0;
        for(int i=0;i<k-1;i++){
            sum+=nums.get(i);
            cnt.merge(nums.get(i),1,Integer::sum);
        }
        for(int i=k-1;i<nums.size();i++){
            sum+=nums.get(i);
            cnt.merge(nums.get(i),1,Integer::sum);

            if(cnt.size()>=m){
                ans=Math.max(ans,sum);
            }
            int out=nums.get(i-k+1);
            sum-=out;
            if(cnt.merge(out,-1,Integer::sum)==0){
                cnt.remove(out);
            }
        }
        return ans;

    }

}
