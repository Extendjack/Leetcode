public class PeakIndexInMountainArray {
    public static void main(String[] args){
        int[] arr={0,1,0};
        int l=peakIndexInMountainArray(arr);
        System.out.println("index："+l);
    }
    /**
     *
     * 寻找最大值
     *
     **/
    public static int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-2;
        while (left+1<right){
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[mid+1]){
                right=mid;
            }else {
                left=mid;
            }
        }
        return right;

    }

}
