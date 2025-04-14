package LeetCode;

import ShiYan6_2.Method;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//示例 1:
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//示例 2:
//输入: nums = [0]
//输出: [0]
public class _0283_MoveZero {
    public static void main(String[] args) {
        int []nums = {0,1,0,3,12} ;
        System.out.println(Method(nums));
    }
    public static int[] Method(int[] nums) {
       int i = 0, j = 0;
       if (nums.length == 1){//个数为1直接返回
           return nums;
       }
       while(i<nums.length && j<nums.length){//双指针，一个依次保存非0数，一个向后遍历
           if (nums[j] != 0 ){
               nums[i] = nums[j];
               i++;
               j++;
           }else {//是0，j向后遍历
               j++;
           }
       }
       while(i < nums.length){//将后面已经保存过的非0数，全部更新为0
           nums[i] = 0;
           i++;
       }
       return nums;
    }
}
