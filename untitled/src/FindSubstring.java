import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        //先确定窗口大小
        int len=words[0].length();
        int wordNum=words.length;

        Map<String,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //滑动窗口len,所以取值范围为0-len
        for(int i=0;i<len;i++){
            int left = i,right=i;
            //命中次数
            int hit=0;
            Map<String,Integer> temp=new HashMap<>();
            while (right+len<=s.length()){
                String word=s.substring(right,right+len);
                right+=len;
                //如果map含有word
                if(map.containsKey(word)){
                    int num=temp.getOrDefault(word,0)+1;
                    temp.put(word,num);
                    hit++;
                    //temp 单词的数量多了
                    if(map.get(word)<num){
                        while (map.get(word) < temp.get(word)) {
                            String delteWord=s.substring(left,left+len);
                            temp.merge(delteWord,-1,Integer::sum);
                            hit--;
                            left+=len;
                        }
                    }

                }else {
                 temp.clear();;
                 left=right;
                 hit=0;

                }
                if(hit==wordNum){
                    res.add(left);
                    String firstWord=s.substring(left,left+len);
                    temp.merge(firstWord,-1,Integer::sum);
                    left+=len;
                    hit--;
                }
            }

        }

        return res ;
    }


}
