package LeetCode;

public class _0643_findMaxAverage {
    public static void main(String[] args) {
        int [] nums = {6,8,6,4,1,2,9,9};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static double Method(int[] nums,int k){
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = 0; i < n-k; i++) {
            if(i+k < n){
                sum -= nums[i];
                sum += nums[i+k];
            }
            max = Math.max(max,sum);
        }
        return max/k;
    }
}
