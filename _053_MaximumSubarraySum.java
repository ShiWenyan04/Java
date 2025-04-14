package LeetCode;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
//示例 1：
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//示例 2：
//输入：nums = [1]
//输出：1
//示例 3：
//输入：nums = [5,4,-1,7,8]
//输出：23
public class _053_MaximumSubarraySum {//动态规划
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
            int pre[] = new int[nums.length], maxAns = nums[0];
            pre[0] = nums[0];//pre[i]是索引以i结尾时的连续子数组的最大和
            for (int i = 1; i < nums.length; i++) {
                pre [i] = Math.max(pre[i-1] + nums[i], nums[i]);//总是在 连续子数组之和 和 单个项数值 之中得出最大的一个
                maxAns = Math.max(pre[i],maxAns);
            }
            return maxAns;
    }
}
