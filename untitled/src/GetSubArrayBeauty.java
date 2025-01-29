import java.util.Arrays;

public class GetSubArrayBeauty {


    public static void main(String[] args){
        int[] result;
        int[] test=new int[]{1,-1,-3,-2,3};
        int k=3;
        int x=2;
        result=getSubarrayBeauty(test,k,x);
        System.out.println("result:"+Arrays.toString(result));

    }
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
//        int n = nums.length;
//        int[] sort = new int[k];
//        int[] result = new int[n-k+1];
//        int index = 0;
//        int left = 0;
//        int right = 0;
//        for (int h = 0; h < k; h++) {
//            sort[h] = nums[h];
//            right++;
//        }
//        Arrays.sort(sort);
//        result[index] = sort[x - 1]<0?sort[x-1] :0;
//        index++;
//        for (int l = left + 1; l <= n - k; l++) {
//            right++;
//            left++;
//            System.out.println("sort1:"+",left:"+left+",right:"+right);
//            sort = Arrays.copyOfRange(nums, left, right);
//            System.out.println("sort2:"+Arrays.toString(sort));
//            Arrays.sort(sort);
//            System.out.println("sort3:"+Arrays.toString(sort));
//            result[index] = sort[x - 1]<0?sort[x-1] :0 ;
//            index++;
//        }
//        return result;


        //计数方法
        int BIT=50;
        int[] cnt=new int[2*BIT+1];
        int n=nums.length;

        for(int i=0;i<k-1;i++){
            cnt[nums[i]+BIT]++;
        }
        int[] ans=new int[n-k+1];
        for(int i=k-1;i<n;i++){
            cnt[nums[i]+BIT]++;
            int left=x;
            for(int j=0;j<BIT;j++){
                left-=cnt[j];
                System.out.println("left:"+left+",cnt:"+cnt[j]+",j:"+j+",ans:"+Arrays.toString(ans));
                if(left<=0){
                    ans[i-k+1]=j-BIT;
                    break;
                }
            }
            cnt[nums[i-k+1]+BIT]--;
        }
        return ans;
    }
}

