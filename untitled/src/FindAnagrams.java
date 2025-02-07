import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args){
        String s1="baa";
        String s2="aa";

        List<Integer>re=findAnagrams(s1,s2);
        System.out.println("re:"+Arrays.toString(re.toArray()));
    }

    public static List<Integer> findAnagrams(String s, String p) {
     int m=s.length();
     int n=p.length();
     List<Integer> re=new ArrayList<>();
     int[] l1=new int[26];
     int[] l2=new int[26];
     if(m<n){
         return re;
     }
     for (int i=0;i<n;i++){
         ++l1[s.charAt(i)-'a'];
         ++l2[p.charAt(i)-'a'];
     }
     if (Arrays.equals(l1,l2)){
         re.add(0);
     }
     for(int i=n;i<m;i++){
         System.out.println("d:"+s.charAt(m-n)+",a:"+s.charAt(i)+",m:"+m+",i:"+i);
         --l1[s.charAt(i-n)-'a'];
         ++l1[s.charAt(i)-'a'];
         if(Arrays.equals(l1,l2)){
             re.add(i-n+1);
         }
     }
     return re;



    }



}
