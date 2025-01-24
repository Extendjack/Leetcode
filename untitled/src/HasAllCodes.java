import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {
    public static  void main(String[] args){
        String test="0110";
        int k=2;
        boolean b=hasAllCodes(test,k);
        System.out.println("结果："+b);
    }
    public static  boolean hasAllCodes(String s, int k) {
        char[] n=s.toCharArray();
        Set<String> se=new HashSet<>();
        String ch;
        int left=0;
        int right=0;
        for (int i=0;i<n.length;i++){
            right++;
            if(i<k-1){
                continue;
            }
            ch=s.substring(left,right);
           // System.out.println("ch:"+ch+",left:"+left+",right:"+right);
            se.add(ch);
            left++;

        }
        System.out.println("se:"+se.size());
        if(se.size()>=Math.pow(2,k)){
            return  true;
        }
        return false;
    }


}
