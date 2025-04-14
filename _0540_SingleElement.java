package LeetCode;
//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//请你找出并返回只出现一次的那个数。
//你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//示例 1:
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
//示例 2:
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
public class _0540_SingleElement {
    public static void main(String[] args) {
        int []nums = {1,1,2} ;
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if (nums.length == 1){
            return nums[0];
        }
        while(left<right){
            mid = (left+right)/2;
            if ( nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]){
                return nums[mid];
            }else if ((mid-left+1)%2==0 && nums[mid]==nums[mid-1]){
                left=mid+1;
            }else if ((mid-left+1)%2!=0 && nums[mid]==nums[mid-1]){
                right = mid-2;
            }else if ((right-mid+1)%2==0 && nums[mid] == nums[mid+1]){
                right=mid-1;
            }else if ((right-mid+1)%2!=0 && nums[mid] == nums[mid+1]){
                left = mid+2;
            }
        }
        return nums[left];
    }
}
