package LeetCode;

import java.util.Arrays;

public class _2279_maximumBeauty {
    public static void main(String []arg){
        int []nums = {4, 6, 1, 2};
        int k = 2;
        System.out.println(Solution(nums,k));
    }
    public static int Solution(int [] nums,int k){
        int ans = 1;
        int left = 0;
        Arrays.sort(nums);
        // 滑动窗口
        for (int right = 0; right < nums.length; right++) {
            // 当窗口内最大值与最小值之差大于 2 * k 时，移动左指针 j
            while(left < right && nums[right] - nums[left] > 2*k){
                left++;
            }
            // 更新最大子数组长度
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
