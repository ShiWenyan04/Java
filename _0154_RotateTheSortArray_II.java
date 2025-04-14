package LeetCode;
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
//若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
//若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//你必须尽可能减少整个过程的操作步骤。
//示例 1：
//输入：nums = [1,3,5]
//输出：1
//示例 2：
//输入：nums = [2,2,2,0,1]
//输出：0
public class _0154_RotateTheSortArray_II {
    public static void main(String[] args) {
        int []nums = {1,3,5};
        System.out.println(Method(nums));
    }
    public static int Method(int[] nums){
        if (nums.length == 1){//长度为一直接返回
            return nums[0];
        }
        if (nums.length == 2){//长度为2，返回最小
            return Math.min(nums[0],nums[1]);
        }
        int left = 0,right = nums.length-1;
        int mid;
        while(left <= right){//二分
            mid = (left + right)/2;
            if (nums[mid] == nums[right]){//如果最右边的值等于nums【mid】，right减小
                right--;
            }else if (nums[mid] < nums[right]){//如果最右边的值小于nums【mid】，说明最小值在左边区域
                right = mid;
            }else if (nums[mid] > nums[right]){//如果最右边的值大于nums【mid】，说明最小值在右边区域
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
