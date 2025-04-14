package LeetCode;

public class _1493_longestSubarray {
    public static void main(String[] args) {
        int []nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int n = nums.length;
        int right = 0,left = 0,maxLen = 0;
        int count = 0;
        int zeroCount = 0;
        while(right < n){
            if(nums[right] == 0){
                count++;
                zeroCount++;
            }
            right++;
            while (count > 1){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left-count);
        }
        if(zeroCount > 0){
            return maxLen;
        }
        return maxLen-1;
    }
}
