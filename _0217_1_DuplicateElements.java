package LeetCode;

import java.util.Arrays;

//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//示例 1：
//输入：nums = [1,2,3,1]
//输出：true
//示例 2：
//输入：nums = [1,2,3,4]
//输出：false
//示例 3：
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true
public class _0217_1_DuplicateElements {
    public static void main(String[] args) {
        int []nums = {1,1,1,3,3,4,3,2,4,2};
        Arrays.sort(nums);//排序
        boolean judge = false;
        for (int i = 0; i < nums.length; i++) {//遍历，有相等就返回true
            if (nums[i] == nums[i+1]) {
                judge = true;
            }
        }
        System.out.println(judge);
    }
}
