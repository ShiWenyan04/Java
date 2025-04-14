package LeetCode;

import java.util.Arrays;
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//返回这三个数的和。
//假定每组输入只存在恰好一个解。
//示例 1：
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//示例 2：
//输入：nums = [0,0,0], target = 1
//输出：0
public class _016_TheNearestSumOfThreeNumbers {
    public static void main(String[] args) {
        int []nums = {0,0,0};
        int target = 1;
        System.out.println(Method(nums,target));
    }
    public static int Method(int [] nums,int target){
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];//首先前三位
        if (closestNum > target){//因为有序，所以前三位若是大于target，则直接返回
            return closestNum;
        }
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first-1]){//若第一个基数有重复的，跳过
                continue;
            }else {
                int second = first+1;//第二个基数，从前往后
                int third = nums.length-1;//第三个基数，从后往前
                while(second<third){
                    int sum = nums[first] + nums[second] + nums [third];//定义和
                    if (sum == target){//等于
                       return sum;
                    }else if (sum < target){//小于，说明需要 和 变大，故左边的索引（第二个基数）自加
                       second ++;
                    } else if (sum > target) {//大于，说明需要 和 变小，故右边的索引（第三个基数）自减
                       third--;
                    }
                    if (Math.abs(sum - target) < Math.abs(closestNum - target)) {//绝对值小的更接近target
                        closestNum = sum;
                    }
                }
            }
        }
        return closestNum;
    }
}
