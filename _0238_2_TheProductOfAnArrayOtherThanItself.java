package LeetCode;
////给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
////题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
////请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
////示例 1:
////输入: nums = [1,2,3,4]
////输出: [24,12,8,6]
////示例 2:
////输入: nums = [-1,1,0,-3,3]
////输出: [0,0,9,0,0]
public class _0238_2_TheProductOfAnArrayOtherThanItself {
    public static void main(String[] args) {
        int []nums = {1,2,3,4};
        System.out.println(Method(nums));
    }

    public static int [] Method(int [] nums) {
        int n = nums.length;
        int []pre = new int[n];
        pre[0] = 1;
        int []suff = new int[n];
        suff[n-1] = 1;
        for (int i = 0; i < n-1;i++){//计算每一个元素的前缀和，首位的前缀和默认为1
            pre[i+1] = pre[i]*nums[i];
        }
        for (int j = n-1; j > 0 ; j--) {//计算每一个的后缀和，末位的后缀和默认为1
            suff[j-1] = suff[j] * nums[j];
        }
        for (int k = 0; k < n; k++) {//将前缀和与后缀和相乘
            nums[k] = pre[k] * suff[k];
        }
        return nums;
    }
}
