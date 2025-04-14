package LeetCode;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//示例 1：
//
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。
//示例 2：
//
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。
//示例 3：
//
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。
public class _041_TheLackOfFirstPositiveInteger {
    public static void main(String[] args) {
        int [] nums = {3,4,-1,1};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
//遍历的目的是让数字（大于0，且小于等于数组长度）从1开始排序，且对应的下标是从0开始，即x的位置为x-1，倘若对应不上那就是缺失的正整数，若都对应的上，那就是数组长度减一
            while ((0 < nums[i]&& nums[i] <= nums.length) && nums[i] != nums[nums[i]-1]){
//不用if，而用while，因为有两个数换完位置，其中一个可能到不了正确的位置
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i] ;
                nums[i] = temp;
            }
        }
        for (int i = 0 , target = 1; i < len; i++,target++) {//缺失最小正整数
            if (nums[i] != target){
               return target;
            }
        }
        return len + 1;
    }
}