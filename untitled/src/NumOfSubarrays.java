public class NumOfSubarrays {
    public static void main(String[] args) {
        //int[] test = generateRandomArray(6514,-9000,9000);
        int[] test=new int[]{11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        double re = numOfSubarrays(test, k,5);
        System.out.println("结果：" + re);
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
       int count=0;
       int sum=0;

       //前k个
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if (sum/k>=threshold){
            count++;
           // System.out.println("sum>=th11111 count：" + count+",sum:"+sum);
        }

        for(int i=k;i<arr.length;i++){
           // System.out.println(",sum:"+sum+",i:"+i+",arr:"+arr[i-k]+",arr i:"+arr[i]);
            sum=sum-arr[i-k]+arr[i];
            if (sum/k>=threshold){
                count++;
               // System.out.println("sum>=th22222 count：" + count+",sum:"+sum);
            }
        }
        return count;

    }

}
