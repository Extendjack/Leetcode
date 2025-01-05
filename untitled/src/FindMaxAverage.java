import java.util.Random;

public class FindMaxAverage {

    public static void main(String[] args) {
        //int[] test = generateRandomArray(6514,-9000,9000);
        int[] test=new int[]{1,12,-5,-6,50,3};

        int k = 4;
        double re = findMaxAverage(test, k);
        System.out.println("结果：" + re);
    }

    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 思路：
     *
     * 1：首先统计前k个元素的属性
     * 2：以后滑动是  第i-k+1滑进窗口  第i个滑进窗口 然后更新元素
     *
     *
     * 入：下标为 i 的元素进入窗口，更新相关统计量。如果 i<k−1 则重复第一步。
     * 更新：更新答案。一般是更新最大值/最小值。
     * 出：下标为 i−k+1 的元素离开窗口，更新相关统计量。
     *
     **/
    public static double findMaxAverage(int[] nums, int k) {
        double sum=0.0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double maxSum=sum;
        for(int i=k;i<n;i++){
            sum=sum-nums[i-k]+nums[i];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum /k;




    }

    //TODO 错误做法
//    public static double findMaxAverage(int[] nums, int k) {
//        double ans = 0;
//        double aver = 0;
//        int[] ks = new int[k];
//        int ki = 0;
//
//        System.out.println("nums.l:"+nums.length);
//
//        if(nums.length==1||nums.length==k){
//            return calculateAverage(nums);
//        }
//        for (int i = 0; i <=nums.length-k; i++) {
//            for (int j = i; j <= i + k; j++) {
//                if (ki < k) {
//                    System.out.println("ki:"+ki+",num:"+nums[j]+",j:"+j);
//                    ks[ki] = nums[j];
//                    ki++;
//                    continue;
//                } else {
//                    ki = 0;
//                }
//                aver = calculateAverage(ks);
//            }
//            ans = Math.max(ans, aver);
//
//        }
//        return ans;
//    }
//
//    public static double calculateAverage(int[] numbers) {
//        for (int a : numbers) {
//            System.out.println("int 数组：" + a);
//        }
//        if (numbers == null || numbers.length == 0) {
//            return 0.0; // 如果数组为空或null，返回0.0
//        }
//        double sum = 0.0;
//        for (int number : numbers) {
//            sum += number; // 累加数组中的所有元素
//        }
//        return sum / numbers.length; // 计算平均数
//    }
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min; // 生成[min, max]范围内的随机数
        }
        return array;
    }


}
