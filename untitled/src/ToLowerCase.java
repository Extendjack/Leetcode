public class ToLowerCase {
    public String toLowerCase(String s) {
      char[] o=s.toCharArray();
      for (int i=0;i<o.length;i++){
           if((int)o[i]>=65&&(int)o[i]<=90) {
               o[i] |=32;
           }
       }
       return String.valueOf(o);
    }
}
