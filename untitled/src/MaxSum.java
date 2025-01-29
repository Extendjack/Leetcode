import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MaxSum {
    public static void main(String[] args){
        List<Integer> test=new ArrayList<Integer>(){};
        int[] e=new int[]{1,1,1,3};
        for (int w:e){
            test.add(w);
        }
        int m=2;
        int k=2;
        long re=maxSum(test,m,k);
        System.out.println("结果为："+re);
    }
    public static long maxSum(List<Integer> nums, int m, int k) {
        Set<Integer> se=new HashSet<>();
        long maxSum=0;
        long sum=0;
        int left=0;
        int right=0;
        for (int i=0;i<nums.size();i++){
            right++;
            //sum+=nums.get(i);
            //se.add(nums.get(i));
            if(i<k-1){
                continue;
            }

//            System.out.println("se1111111:"+se.size());
//
//            int kk=nums.get(i-k+1);
//            if(kk!=nums.get(i)){
//                se.add(nums.get(i));
//            }
//
//            System.out.println("se22222222:"+se.size());

            List<Integer> cs=nums.subList(left,right);
            for (int a:cs){
                //System.out.println("cs:"+a+",left:"+left+",right:"+right);
                se.add(a);
                sum+=a;
            }

            if(se.size()>=m){
                System.out.println("se1111:"+se.size()+",sum:"+sum+",maxSum:"+maxSum);
                maxSum=Math.max(sum,maxSum);
                sum=0;
                se.clear();
            }else {
                sum=0;
                System.out.println("se2222:"+se.size()+",sum:"+sum+",maxSum:"+maxSum);
                maxSum=Math.max(sum,maxSum);
                se.clear();
            }
            left++;

        }
        return maxSum;
    }
}
