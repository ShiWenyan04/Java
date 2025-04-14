package LeetCode;

import java.util.Arrays;

//整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
// 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中
// 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
// 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
//给你一个整数数组 nums ，找出 nums 的下一个排列。
//必须 原地 修改，只允许使用额外常数空间。
//示例 2：
//输入：nums = [3,2,1]
//输出：[1,2,3]
public class _031_NextPermutation {
    public static void main(String[] args) {
        int []arr = {2,3,1};
        System.out.println(Method(arr));
    }
    public  static int[] Method(int[] nums) {
        int i = nums.length-2;
        // 从倒数第二个元素开始，向前找到第一个非递增的元素
        while(i >= 0&& nums[i] >= nums[i+1]){
            i--;// 找到第一个 nums[i] < nums[i+1] 的位置
        }
        // 如果 i >= 0，说明有可能存在下一个排列
        if(i >= 0){
            // 从末尾开始，找到第一个大于 nums[i] 的元素
            int j = nums.length-1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--; // 找到第一个 nums[j] > nums[i] 的位置
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums,i,j);
        }
        // 反转从 i+1 到数组末尾的部分
        reverse(nums,i+1);
        return nums;
    }

    public static void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int[] nums,int start){
        int left = start,right = nums.length -1 ;
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}