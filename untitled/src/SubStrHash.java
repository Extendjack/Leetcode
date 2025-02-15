public class SubStrHash {
    public String subStrHash(String s, int power, int mod, int k, int hashValue) {
     int len=s.length();
     long hash=0;
     long pk=1;
     char[] nums=s.toCharArray();
     for(int i=len-1;i>=len-k;i--){
         hash=(hash*power+(nums[i]&31))%mod;
         pk=pk*power%mod;
     }
     int ans=hash==hashValue?len-k:0;
     for(int i=len-k-1;i>=0;i--){
         hash=(hash*power+(nums[i]&31)-pk*(nums[i+k]&31)%mod+mod)%mod;
         if(hash==hashValue){
             ans=i;
         }
     }
      return s.substring(ans,ans+k);


    }
}
