public class MinSwaps {
    /**
     * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
     *
     * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
     *
     * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
     *
     *
     *
     **/

    public int minSwaps(int[] nums) {
        int  n=nums.length;
        //先统计nums里面1的个数
        int len=0;
        for(int i=0;i<nums.length;i++)
        {
            len+=nums[i];
        }

        //把len作为一个窗口的长度,计算第一个窗口的1的个个数
        int  cnt=0;
        for(int i=0;i<len;i++){
            cnt+=nums[i];
        }
        int time=len-cnt;

        //len-cnt就是窗口交换的次数
        for (int i=len;i<n+len-1;i++){
            cnt+=nums[i%n]-nums[i-len];
            time=Math.min(time,len-cnt);
        }
        return time;

    }


}
