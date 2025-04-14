package LeetCode;
//示例 1：
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
//示例 2：
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false
public class _081_SearchRotationSortArray_II {
    public static void main(String[] args) {
        int [] nums = {2,2,2,3,2,2,2};
        int target = 3;
        System.out.println(Method(nums,target));
    }
//第一类
//10111 和 11101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
//第二类
//2 3 4 5 6 7 1 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
//这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
//第三类
//6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
//这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
    public static boolean Method(int [] nums,int target){
        if(nums.length == 1 ){
            return nums[0] == target;
        } else if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        int mid ;
        while(left <= right){
            mid = (right+left)/2;
            if(nums[mid] == target)
                return true;
            if (nums[left] == nums[mid] ){//分不清到底是前面有序还是后面有序
                left++;
                continue;
            }
            //前半部分有序
            if (nums[left] < nums[mid] ){
                if (nums[left]<=target && nums[mid]>target){//在前半部分
                    right = mid-1;
                }else {//在后半部分
                    left = mid+1;
                }

            }else {//后半部分有序
                if( nums[right]>=target && nums[mid]<target){//在前半部分
                    left = mid+1;
                }else {//在后半部分
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
