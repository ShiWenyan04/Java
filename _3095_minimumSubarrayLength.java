package LeetCode;

public class _3095_minimumSubarrayLength {
    public static void main(String [] arg){
        int []nums = {1, 2, 3};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static int Method(int [] nums,int k){
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = i; j < nums.length; j++) {
                num |= nums[j];
                if(num >= k){
                    count = Math.min(count,j-i+1);
                }
            }
        }
        return count == Integer.MAX_VALUE?-1:count;
    }
}
