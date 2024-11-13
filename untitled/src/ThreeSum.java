import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组
 *
 * **/
public class ThreeSum {
   public static void main(String[] args){


   }

/**
 *
 * 转化为num[j]+num[k]=-num[i]
 *
 *
 * **/
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> arr = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len; i++) {
        if (nums[i] > 0) {
            break;
        }
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int cur = nums[i];
        int L = i + 1;
        int R = len - 1;
        while (L < R) {
            if (nums[L] + nums[R] == -cur) {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                list.add(nums[L]);
                list.add(nums[R]);
                arr.add(list);
                while (L < R && nums[L + 1] == nums[L]) ++L;
                while (L < R && nums[R - 1] == nums[R]) --R;
                ++L;
                ++R;
            } else if (nums[L] + nums[R] + cur > 0) {
                --R;
            } else {
                ++L;
            }

        }

    }
    return arr;
}

}
