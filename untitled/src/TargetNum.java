public class TargetNum {
    /**
     *
     * 从一个数组中找出第一个两数之和等于目标数的两个数组
     * 先从尾部和头部开始找，与目标数相比较，然后根据情况移动头部或者尾部指针
     ***/
    public static void main(String[] args) {
        int target=6;

        int[] arr={1,2,2,4,5,6,7};
        int first_point=0;
        int end_point=arr.length-1;
        int[] count=getTarget(arr,0,arr.length-1,target);
        System.out.println("point1:"+count[0]+",point2:"+count[1]);


    }
    public static int[] getTarget(int[] arr,int first_point,int end_point,int target ) {
        while (first_point <= end_point) {
            if (arr[first_point] + arr[end_point] > target) {
                end_point--;
            } else if (arr[first_point] + arr[end_point] < target) {
                first_point++;
            } else {
                return new int[]{first_point,end_point};
            }
        }
        return new int[]{-1,-1};
    }
}
