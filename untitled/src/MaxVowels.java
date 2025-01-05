public class MaxVowels {
    public static void main(String[] args){
        maxVowels("abciiidef",3);
    }



    public static int maxVowels(String s, int k) {
       int sum=0;
       int ans=0;
       char[] str=s.toCharArray();
       for(int i=0;i<str.length;i++){

           System.out.println("ss :"+i+",ch:"+str[i]);

           if(str[i]=='a'||str[i]=='e'||str[i]=='i'||str[i]=='o'||str[i]=='u'){
               System.out.println("进 :"+i+",ch:"+str[i]);
               sum++;
           }
           if(i<k-1){
               System.out.println("i<k-1 :"+i+",ch:"+str[i]);
               continue;
           }
           ans=Math.max(ans,sum);

           char a=str[i-k+1];
           System.out.println("出:"+a+",i:"+(i-k+1)+",ch:"+str[i-k+1 ]);
           if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u'){
               sum--;
           }

       }
       return ans;

    }




}
