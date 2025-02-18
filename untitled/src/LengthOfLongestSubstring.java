import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> re=new HashMap<>();
        int i=-1;int r=0;
        for(int j=0;j<s.length();j++){
            if(re.containsKey(s.charAt(j))){
                i=Math.max(i,re.get(s.charAt(j)));
            }
            re.put(s.charAt(j),j);
            r=Math.max(r,(j-i));
        }
        return r;


    }
}
