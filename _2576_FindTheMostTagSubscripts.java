package LeetCode;

import java.util.Arrays;

//给你一个下标从 0 开始的整数数组 nums 。
//一开始，所有下标都没有被标记。你可以执行以下操作任意次：
//选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
//请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
//示例 1：
//输入：nums = [3,5,2,4]
//输出：2
//解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
//没有其他更多可执行的操作，所以答案为 2 。
//示例 2
//输入：nums = [9,2,5,4]
//输出：4
//解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
//第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
//没有其他更多可执行的操作，所以答案为 4 。
//示例 3：
//输入：nums = [7,6,8]
//输出：0
//解释：没有任何可以执行的操作，所以答案为 0 。
public class _2576_FindTheMostTagSubscripts {
    public static void main(String[] args) {
        int[] nums = {9,2,5,4};
        System.out.println(Method(nums));
    }
    public static int Method(int[]nums){
        int ans = 0;
        Arrays.sort(nums);//排序
        int right = nums.length/2,left = 0;//左指针0~nums.length/2,右指针nums.length/2~nums.length，谨防重复
        while (left<nums.length/2 && right<nums.length)//双指针
            if (2*nums[left] <= nums[right]){//满足条件，双指针一起移动，ans+2
                ans+=2;
                right++;
                left++;
            }else {//不满足条件，仅右指针移动，使得nums【right】变大
                right++;
            }
        return ans;
    }
}
