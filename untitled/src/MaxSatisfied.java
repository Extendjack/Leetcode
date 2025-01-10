public class MaxSatisfied {
    public static void main(String[] args){
         int []customers=new int[]{1,0,1,2,1,1,7,5};
         int[] grumpy=new int[]{0,1,0,1,0,1,0,1};
         int minutes=3;
         int s=maxSatisfied(customers,grumpy,minutes);
         System.out.println("sum:"+s);
    }
    /**
     *有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
     * 在某些分钟内，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
     * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
     * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
     * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
     *
     *
     **/

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] sum = new int[2];
        int maxSum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            sum[grumpy[i]] += customers[i];
            if (i < minutes - 1) {
                continue;
            }
            maxSum = Math.max(sum[1], maxSum);

            int s = customers[i - minutes + 1];
            sum[1] -= grumpy[i - minutes + 1] == 1 ? customers[i - minutes + 1] : 0;

        }
        return maxSum + sum[0];

    }
}
