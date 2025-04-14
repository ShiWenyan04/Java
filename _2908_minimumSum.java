package LeetCode;

public class _2908_minimumSum {
    public static void main(String[] args) {
        int []nums = {8,6,1,5,3};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        int n = nums.length;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if(nums[i]<nums[j] && nums[k] < nums[j]){
                        sum = Math.min(sum,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
        }
        return sum == Integer.MAX_VALUE?-1:sum;
    }
}
