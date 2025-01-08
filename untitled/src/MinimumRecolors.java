public class MinimumRecolors {
    public static void main(String[] args){
        String test="WBBWWBBWBW";
       int t=minimumRecolors(test,7);
       System.out.println("test:"+t);

    }
    /**
     *给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
     *
     * 给你一个整数 k ，表示想要 连续 黑色块的数目。
     *
     * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
     *
     * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
     *
     *
     **/
    public static int minimumRecolors(String blocks, int k) {
        char[] str=blocks.toCharArray();
        int n=str.length;
        int sum=0;
        int minSum=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if(str[i]=='W'){
                sum++;
                System.out.println("minimumRecolors111:"+sum+",i;"+i);
            }
            if(i<k-1){
                System.out.println("minimumRecolors222:"+sum+",i:"+i);
                continue;
            }
            minSum=Math.min(minSum,sum);

            System.out.println("minimumRecolors333:"+minSum+",i;"+i+",sum:"+sum);
            char st=str[i-k+1];
            System.out.println("minimumRecolors4444:"+st+",i:"+i+",str:"+str[i]);
            if(st=='W'){
                sum--;
            }
        }
        return minSum;
    }

}
