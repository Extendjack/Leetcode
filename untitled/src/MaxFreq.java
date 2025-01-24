import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxFreq {

    public static void main(String[] args){
        String testS="aabcabcab";
        int maxL=2;
        int minS=2;
        int maxS=3;

        int re=maxFreq(testS,maxL,minS,maxS);
        System.out.println("结果："+re);
    }



    /**
     * @param maxLetters 不同字母的个数
     * @param  minSize 子串最小
     * @param maxSize 子串最大
     * return 最多子串
     **/

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//        Map<Character,Integer> count = new HashMap<>();
//        HashMap<String,Integer> count_s=new HashMap<>();
//        char[] str=s.toCharArray();
//        int left=0;
//        int right=0;
//        for(;right<minSize-1;right++){
//            count.merge(str[right],1,Integer::sum);
//        }
//       System.out.println("count111:"+count.size()+",left:"+left+",right:"+right);
//        if(count.size()<=maxLetters){
//            count_s.merge(s.substring(left,right),1,Integer::sum);
//        }
//        for(right=minSize;right<str.length;right++){
//            char out=str[left];
//            for (Map.Entry<Character, Integer> entry : count.entrySet()) {
//                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//            }
//
//            if(count.merge(out,-1,Integer::sum)==0){
//                System.out.println("out:"+out);
//                count.remove(out);
//            }
//            System.out.println("count22:"+count.size()+",left:"+str[left]+",right:"+str[right]);
//            count.merge(str[right],1,Integer::sum);
//            System.out.println("count33:"+count.size()+",left:"+str[left]+",right:"+str[right]);
//            if(count.size()<=maxLetters){
//                count_s.merge(s.substring(left,right),1,Integer::sum);
//            }
//            left++;
//        }
//        return Collections.max(count.values());
//
//
//
//
//
//    }
        HashMap<String, Integer> substringCount = new HashMap<>();
        int maxCount = 0;

        // 枚举所有长度为 minSize 的子串
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);

            // 判断子串中不同字母的数量
            if (countUniqueLetters(sub) <= maxLetters) {
                substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
                maxCount = Math.max(maxCount, substringCount.get(sub));
            }
        }

        return maxCount;
    }

    // 辅助方法：统计字符串中不同字母的数量
    private static int countUniqueLetters(String sub) {
        HashSet<Character> uniqueLetters = new HashSet<>();
        for (char c : sub.toCharArray()) {
            uniqueLetters.add(c);
        }
        return uniqueLetters.size();
    }
}
