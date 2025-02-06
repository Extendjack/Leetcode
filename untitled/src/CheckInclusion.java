import java.util.Arrays;

public class CheckInclusion {
    public static void main(String[] args){
        String s1="ab";
        String s2="eidboaoo";

        boolean isCheck=checkInclusion(s1,s2);
        System.out.println("result:"+isCheck);

    }

    public static boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        if (m>n){
            return false;
        }

        int[] l1=new int[26];
        int[] l2=new int[26];

        for(int i=0;i<m;i++){
            ++l1[s1.charAt(i)-'a'];
            ++l2[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(l1,l2)){
            return true;
        }
        for (int i=m;i<n;i++){
            --l2[s2.charAt(i-m)-'a'];
            ++l2[s2.charAt(i)-'a'];
            if(Arrays.equals(l1,l2)){
                return true;
            }

        }
        return false;
    }


}
