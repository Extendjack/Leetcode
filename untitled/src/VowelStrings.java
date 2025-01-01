public class VowelStrings {
    /**
     *
     * 统计范围内的元音字符串数
     *
     **/
    public int vowelStrings(String[] words, int left, int right) {
        int sum=0;
        for (int i=left;i<=right;i++){
            String world=words[i];
            int l=world.length();
            char[] fl=world.toCharArray();
            if((fl[0]=='a'||fl[0]=='e'||fl[0]=='i'||fl[0]=='o'||fl[0]=='u')&&(fl[l-1]=='a'||fl[l-1]=='e'||fl[l-1]=='i'||fl[l-1]=='o'||fl[l-1]=='u')){
                sum++;
            }
        }
        return sum;
    }
}
