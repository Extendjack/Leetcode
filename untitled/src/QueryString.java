public class QueryString
{
    public  static  boolean queryString(String s,int n){
        for(int i=1;i<n;i++){
            if(!s.contains(Integer.toHexString(i))){
                return false;
            }
        }
        return true;
    }
}
