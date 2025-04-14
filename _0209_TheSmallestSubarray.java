package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//找出该数组中满足其总和大于等于 target 的长度最小的
//子数组
// [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//示例 1：
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//示例 2：
//输入：target = 4, nums = [1,4,4]
//输出：1
//示例 3：
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
public class _0209_TheSmallestSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1,  4, 3,2};
        int target = 7;
        System.out.println(Method(nums, target));
    }

    public static int Method(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
             sum += nums[right];
             while(sum >= target){//如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）
                 min = Math.min(min,right-left+1);//窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
                 sum-=nums[left++];
             }
        }
        if (min == Integer.MAX_VALUE){
            min = 0;
        }
        return min;
    }
}
