package LeetCode;

import ShiYan6_2.Method;

public class _0377_combinationSum4 {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        int target = 4;
        System.out.println(Method(nums,target));
    }
    public static int Method(int [] nums,int target){
        int []f = new int[target+1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(num <= i){
                    f[i] += f[i-num];
                }
            }
        }
        return f[target];
    }
}
