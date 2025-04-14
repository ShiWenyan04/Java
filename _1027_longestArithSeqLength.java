package LeetCode;

import java.util.Arrays;

public class _1027_longestArithSeqLength {
    public static void main(String[] args) {
        int [] nums = {20,1,15,3,10,5,8};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int minv = Arrays.stream(nums).min().getAsInt();
        int maxv = Arrays.stream(nums).max().getAsInt();
        int diff = maxv-minv;
        int maxLen = 1;

        for (int d = -diff; d <= diff; d++) {
            int []f = new int[maxv+1];
            Arrays.fill(f,-1);
            for (int j = 0; j < nums.length; j++) {
                int pre = nums[j] - d;
                if(pre <= maxv && pre >= minv && f[pre]!=-1){
                    f[nums[j]] = Math.max(f[pre]+1,f[nums[j]]);
                    maxLen = Math.max(maxLen,f[nums[j]]);
                }
                f[nums[j]] = Math.max(1,f[nums[j]]);
            }
        }
        return maxLen;
    }
}
