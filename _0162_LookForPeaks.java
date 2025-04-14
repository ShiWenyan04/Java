package LeetCode;
//峰值元素是指其值严格大于左右相邻值的元素。
//给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//你可以假设 nums[-1] = nums[n] = -∞ 。
//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
//示例 1：
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。
//示例 2：
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6
public class _0162_LookForPeaks {
    public static void main(String[] args) {
        int []nums = {3,1,2};
        System.out.println(Method(nums));
    }

    public static int Method(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if ((nums.length == 2 || nums.length == 1) && (nums[0]>=nums[nums.length-1])){//当数组长度为1，2时，可以直接找最大值的索引
            return 0;
        } else if ((nums.length == 2 || nums.length == 1) && (nums[0]<nums[nums.length-1])) {
            return nums.length-1;
        }
        while(left<=right){
             mid = (left+right)/2;
            if ((mid != 0 && mid != nums.length-1 && nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid])//峰值在中间
                    || (mid == 0&& nums[mid]>nums[mid+1])//峰值在开头
                    ||(mid == nums.length-1&&nums[mid-1]<nums[mid])){//峰值在末尾
                return mid;
            }
            if (nums[mid] > nums[mid-1] ||nums[mid] < nums[mid+1] ){//峰值呈现 ↗ 趋势
                left ++ ;
            }else if (nums[mid] > nums[mid+1] ||nums[mid] < nums[mid-1]){//峰值呈现 ↖ 趋势
                right --;
            }
        }
        return mid;
    }
}
