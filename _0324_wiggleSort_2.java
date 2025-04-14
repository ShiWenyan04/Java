package LeetCode;

import java.util.Arrays;

public class _0324_wiggleSort_2 {
    public static void main(String[] args) {
        int []nums = {1,5,1,1,6,4};
        System.out.println(Arrays.toString(Method(nums)));
    }
    public static int[] Method(int []nums){
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int [] count = new int[max+1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < n; i+=2) {
            while(count[max] == 0){
                max--;
            }
            count[max]--;
            nums[i] = max;
        }
        for (int i = 0; i < n; i+=2) {
            while(count[max] == 0){
                max--;
            }
            count[max]--;
            nums[i] = max;
        }
        return nums;
    }
}
