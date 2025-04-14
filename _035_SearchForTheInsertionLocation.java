package LeetCode;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//请必须使用时间复杂度为 O(log n) 的算法。
//示例 1:
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//示例 2:
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//示例 3:
//输入: nums = [1,3,5,6], target = 7
//输出: 4
public class _035_SearchForTheInsertionLocation {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 7;
        int mid = 0, left = 0,right = nums.length-1;
        if (nums[nums.length-1] < target){//最后一个值小于target
            System.out.println(nums.length);
        }else {
            while(left <= right){
                mid = (right + left)/2;
                if (nums[mid] == target || (nums[mid] > target && nums[mid-1] < target) ) {
                    break;//mid对应值等于target，或者有mid对应值大于target且mid-1对应值小于target
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target){
                    right = mid;
                }
            }
            System.out.println(mid);
        }


    }
}
