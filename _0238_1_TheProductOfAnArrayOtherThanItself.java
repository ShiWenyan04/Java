package LeetCode;
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
//示例 1:
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
//示例 2:
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
public class _0238_1_TheProductOfAnArrayOtherThanItself {
    public static void main(String[] args) {
        int []nums = {0,0};
        System.out.println(Method(nums));
    }

    public static int [] Method(int [] nums) {
        int [] nums2 = new int[nums.length];
         for (int i = 0; i < nums.length;i++){
             int multiplication = 1;
             for (int j = 0;j< nums.length;j++){
                 if (nums[i] == nums[j] && i==j){
                     continue;
                 }else {
                     multiplication *= nums[j];

                 }
             }
             nums2[i] = multiplication;
         }
         return nums2;
    }
}
