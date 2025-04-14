package LeetCode;

import java.util.Arrays;

public class _0416_canPartition {
    public static void main(String[] args) {
        int []nums = {1, 5, 11, 5};
        System.out.println(Method(nums));
    }
    public static boolean Method(int [] nums){
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = 0;
        for (int num : nums) {
            sum +=num;
        }
        int half = sum/2;
        if(sum%2!=0 || max > half || n < 2) return false;
        boolean [][]f = new boolean[n][half+1];
        for (int i = 0; i < n; i++) {
            f[i][0] = true;
        }
        f[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j <= half; j++) {
                if(j >= num){
                    f[i][j] = f[i][num]|f[i-1][j-num];
                }else {
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[n-1][half];
    }
}
