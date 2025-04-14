package LeetCode;

import java.util.Arrays;

public class _0324_wiggleSort {
    public static void main(String[] args) {
        int []nums = {1,5,1,1,6,4};
        System.out.println(Arrays.toString(Method(nums)));
    }
    public static int[] Method(int [] nums){
        int n = nums.length;
        int []arr = nums.clone();
        Arrays.sort(arr);
        int x= (n+1)/2;
        for (int i = 0,j = x-1,k = n-1; i < n; i+=2,j--,k--) {
            nums[i] = arr[j];
            if(i+1 < n){

                nums[i+1] = arr[k];
            }
        }
        return nums;
    }
}
