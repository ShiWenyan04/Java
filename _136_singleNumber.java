package LeetCode;

public class _136_singleNumber {
    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }
}
