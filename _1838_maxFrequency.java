package LeetCode;

import java.util.Arrays;

public class _1838_maxFrequency {
    public static void main(String[] args) {
        int [] nums = {1,2,4};
        int k = 5;
        System.out.println(Method(nums,k));
    }
    public static int Method(int [] nums,int k ){
        Arrays.sort(nums);
        int n = nums.length;
        int res = 1;
        long window = 0;// 创造当前滑窗所需要的步数
        int left = 0, right = 1;
        while (right < n) {
            int count = right - left;
            window += (long)(nums[right]-nums[right-1])*count;
            while (window > k) {
                window -=(long)nums[right]- nums[left];
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
