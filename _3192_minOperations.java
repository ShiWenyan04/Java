package LeetCode;

public class _3192_minOperations {
    public static void main(String[] args) {
        int []nums = {0,1,1,0,1};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        int n = nums.length;
        int ans = 1-nums[0];
        for (int i = 0; i < n-1; i++) {
            if(nums[i] != nums[1+i]){
                ans++;
            }
        }
        return ans;
    }
}
