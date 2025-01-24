import java.util.ArrayList;
import java.util.List;

public class MaxScore2 {
    public static void main(String[] args){
        int[] test=new int[]{11,49,100,20,86,29,72};
        int k=4;
        int re=maxScore(test,k);
        System.out.println("答案:"+re);
    }

    /**
     *
     *
     * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
     *
     * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
     *
     * 你的点数就是你拿到手中的所有卡牌的点数之和。
     *
     * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     *
     *
     * **/
    /**
     *
     *拿走 k 张，剩下 n−k 张。这里 n 是 cardPoints 的长度。
     *
     * 由于拿走的点数和 + 剩下的点数和 = 所有点数和 = 常数，所以为了最大化拿走的点数和，应当最小化剩下的点数和。
     *
     * 由于只能从开头或末尾拿牌，所以最后剩下的牌必然是连续的。
     *
     * 至此，问题变成：
     *
     * 计算长为 n−k 的连续子数组和的最小值。
     * 这可以用滑动窗口解决。
     *
     * 算法
     * 设 m=n−k，计算第一个长为 m 的子数组元素和，即 s=cardPoints[0]+cardPoints[1]+⋯+cardPoints[m−1]。初始化 minS=s。
     * 计算下一个子数组的元素和，即 s
     * ′
     *  =cardPoints[1]+cardPoints[2]+⋯+cardPoints[m]。由于 s
     * ′
     *  −s=cardPoints[m]−cardPoints[0]，所以只需要把 s 增加 cardPoints[m]−cardPoints[0]，就可以 O(1) 算出下一个子数组的元素和。
     * 依照这个方法，从 i=m 开始向后枚举，每次把 s 增加 cardPoints[i]−cardPoints[i−m]，然后用 s 更新 minS 的最小值。
     * 最后，用 cardPoints 的元素和，减去 minS，就得到了答案。
     *
     *
     *
     * **/
    public static int maxScore(int[] cardPoints, int k) {
        int allSum=0;
        for (int a:cardPoints){
            allSum+=a;
        }
        int sum=0;
        int n=cardPoints.length;
        int m=n-k;

        for (int i=0;i<m;i++){
            sum+=cardPoints[i];
        }
        int minSum=sum;
        for(int i=m;i<n;i++){
            sum+=cardPoints[i]-cardPoints[i-m];
            minSum=Math.min(sum,minSum);
        }
        return allSum-minSum;
    }
}
