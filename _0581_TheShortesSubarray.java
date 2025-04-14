package LeetCode;
//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//请你找出符合题意的 最短 子数组，并输出它的长度。
//示例 1：
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//示例 2：
//输入：nums = [1,2,3,4]
//输出：0
//示例3：
//输入：nums = [1]
//输出：0
public class _0581_TheShortesSubarray {
    public static void main(String[] args) {
        int []nums = {2,6,4,8,10,9,15};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        int rightIndex = -1,leftIndex = -1;
        for (int i = 0;i < nums.length;i++){//遍历数组
            if(max <= nums[i]){//从左到右，应该升序，遇见比前一个大的数，就更新max，倘若遇见比前一个小的数，那就记录
                max =  nums[i];
            }else {
                leftIndex = i;
            }
            if(min >= nums[n-1-i]){//从右到左，应该降序，遇见比后一个小的数，更新min，倘若遇见比前一个大的数，那就记录
                min = nums [n-1-i];
            }else {
                rightIndex = n-1-i;
            }
        }
        return rightIndex != -1 ? leftIndex-rightIndex+1:0;
    }
}
