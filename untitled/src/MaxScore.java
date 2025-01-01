import java.util.Arrays;

public class MaxScore {

    public static void main(String[] args){
        String s="01001";
        int ans=maxScore(s);
        System.out.println("ans:"+ans);
    }
    public static int maxScore(String s) {
        String s1,s2;
        int n=s.length();
        int[] ans=new int[n];
        int sum=0;
        int index=0;

        System.out.println("n:"+n);
        if (n==2){
            int um=0;

            if(s.charAt(0)=='0'){
                System.out.println("1111:");
                um++;
            }
            if(s.charAt(1)=='1'){
                System.out.println("222222:");
                um++;
            }
            return um;
        }
        for(int i=1;i<n;i++){
            s1=s.substring(0,i);
            s2=s.substring(i,n);
            System.out.println("s1:"+s1+",s2:"+s2);
            char[] c1=s1.toCharArray();
            char[] c2=s2.toCharArray();
            for (char c:c1){
                if(c=='0'){
                    sum++;
                }
            }
            for (char c:c2){
                if(c=='1'){
                    sum++;
                }
            }
            ans[index]=sum;
            index++;
            sum=0;
        }
        Arrays.sort(ans);
        return ans[ans.length-1];

    }
}
