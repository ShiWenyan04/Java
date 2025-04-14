package LeetCode;


public class _1004_longestOnes {
    public static void main(String[] args) {
        int []nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static int Method(int []nums,int k){
        int n = nums.length;
        int count = 0,max = 0;
        int left = 0,right = 0;
        while(right < n){
            if(nums[right] == 0){
                count ++;
            }
            right++;
            while(count > k){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
