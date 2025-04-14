package LeetCode;

import java.util.Arrays;

public class _3255_resultsArray {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,3,2,5};
        int k = 3;
        System.out.println(Arrays.toString(Method(nums,k)));
    }
    public static int[] Method(int []nums,int k){
        int n = nums.length;
        int [] ans = new int[n-k+1];
        Arrays.fill(ans,-1);
        int count= 0;
        for (int i = 0; i < n; i++) {
            count = i == 0 || nums[i]-nums[i-1]!=1?1:count+1;
            if(count >= k){
                ans[i-k+1] = nums[i];
            }
        }
        return ans;
    }
}
