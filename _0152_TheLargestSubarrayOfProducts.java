package LeetCode;
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组(该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//测试用例的答案是一个 32-位 整数。
//示例 1:
//输入: nums = [2,3,-2,4]
//输出: 6     解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//输入: nums = [-2,0,-1]
//输出: 0     解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
public class _0152_TheLargestSubarrayOfProducts {
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        System.out.println(Method(nums));
    }
    public static int Method (int[] nums) {
        long [] maxF = new long[nums.length];
        long [] minF = new long[nums.length];
        int i = 0;
        for (int num : nums) {
            maxF[i] = num;
            minF[i] = num;
            i++;
        }
        for (int j = 1; j < nums.length; j++) {
            maxF[j] = Math.max(maxF[j-1]*nums[j],Math.max(minF[j-1]*nums[j],nums[j]));
            minF[j] = Math.min(maxF[j-1]*nums[j],Math.min(minF[j-1]*nums[j],nums[j]));
        }
        long ans = maxF[0];
        for (long l : maxF) {
            ans = Math.max(ans,l);
        }
        return (int)ans;
    }
}
