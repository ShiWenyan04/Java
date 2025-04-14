package LeetCode;


public class _2270_TheNumberOfSplittingArray {
    public static void main(String[] args) {
        int []nums = {2,3,1,0};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        boolean []judge = new boolean[nums.length];
        long [] preSum = new long[nums.length];
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i < nums.length-1){
                judge[i] = true;
            }
            if(i == 0){
                preSum[i]=nums[i];
            }else {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            total += nums[i];
        }
        int ans= 0;
        for (int i = 0; i < nums.length; i++) {
            if(judge[i] && total-preSum[i] <= preSum[i]){
                ans++;
            }
        }
        return ans;
    }
}
