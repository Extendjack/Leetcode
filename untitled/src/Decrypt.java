public class Decrypt {
    /**
     * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
     *
     * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
     *
     * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
     * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
     * 如果 k == 0 ，将第 i 个数字用 0 替换。
     * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
     *
     * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
     *
     **/
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
       int[] res=new int[n];
       int count=0;
       int sum=0;
       int r=k>0?k+1:n;
       k=Math.abs(k);


       for(int i=r-k;i<r;i++){
          sum+=code[i];
       }
       for(int i=0;i<n;i++){
           res[i]=sum;
           sum=sum-code[(r-k)%n]+code[r%n];
           r++;

       }
       return res;

    }
}
