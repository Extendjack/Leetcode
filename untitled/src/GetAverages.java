public class GetAverages {
    /**
     *
     * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
     *
     * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
     *
     * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
     *
     * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
     *
     * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
     *
     *
     *
     * **/
    public static void main(String[] args) {
        //int[] test = generateRandomArray(6514,-9000,9000);
        int[] test=new int[]{7,4,3,9,1,8,5,2,6};
        int k = 3;
        int[] re = getAverages(test, k);
        for (int a:re){
            System.out.println("结果：" + a);
        }

    }
    public static int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        long sum=0;
        int[] avg=new int[n];
        //7,4,3,9,1,8,5,2,6
        for(int i=0;i<n;i++){
            avg[i]=-1;
            if(i<2*k){
                sum+=nums[i];
                //System.out.println("test1111 i:"+i+",sum:"+sum);
                continue;
            }
            if(i==2*k){
                sum=sum+nums[i];
                //System.out.println("test222 i:"+i+",sum:"+sum);
            }else{
                sum=sum+nums[i]-nums[i-2*k-1];
                //System.out.println("test333 i:"+i+",sum:"+sum);
            }
           // System.out.println("test44 i:"+i+",sum:"+sum);
            avg[i-k]= (int) (sum/(2*k+1));

        }
        return avg;
    }

}
