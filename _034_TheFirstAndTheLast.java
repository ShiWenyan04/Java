package LeetCode;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回 [-1, -1]。
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]

//示例 2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]

import java.util.Arrays;

//示例 3：
//输入：nums = [], target = 0
//输出：[-1,-1]
public class _034_TheFirstAndTheLast {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int target = 1;
        //利用二分法查找
        System.out.println(Arrays.toString(Method(nums,target)));
    }
    public static int[] Method(int [] nums, int target){
        int low = 0, height = nums.length-1;//左，右边界
        int min , max  ;//目标值开始位置和结束位置
        int[] index;
        while(low <= height){
            int mid=(low+height)/2;//中间值的索引
            if (target > nums [mid] ){//目标值大于中间值时
                low = mid + 1 ;
            }else if(target == nums[mid]){//目标值等于中间值时
                    int temp = mid;
                    max = mid;
                    min = mid;//倘若列表中的target只有 mid 符合，结束位置和开始位置都为mid
                    while (++mid < nums.length && nums[mid] == target){//右边的数字是否是target
                        max = mid;
                    }
                    mid = temp;
                    while(--mid >= 0 && nums[mid] == target){//左边数字是否是target
                        min = mid;
                    }
                    index = new int[]{min,max};
                    return index;
            } else if (target < nums[mid]) {//目标值小于mid对应的值
                height = mid - 1 ;
            }
        }
        return new int[]{-1,-1};
    }
}
