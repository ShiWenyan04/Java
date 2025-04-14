package LeetCode;
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
//示例 1：
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//示例 2：
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//示例 3：
//输入：nums = [1], target = 0
//输出：-1
public class _033_SearchForARotationallySortedArray {
    public static void main(String[] args) {
        int []nums = {5,1,3};
        int target = 3;
        System.out.println(Method(nums,target));
    }

    public static int Method(int [] nums,int target) {
        int start = 0;
        int end = nums.length-1;
        int mid ;
        while(start <= end){
            mid = (start+end)/2;
            if(nums[mid] == target){//找到target值
                return mid;
            }
            if(nums[start] == nums[mid]){//倘若出现多个相等的值，如11011111，找到正序开始即可
                start++;
                continue;
            }
            if (nums[start] < nums[mid]){//如果前面有序的个数大于后面有序的个数
                if (nums[start] <= target && target <= nums[mid]){//并且target在前面有序的范围内
                    end = mid-1;//就缩小范围，把范围规定在前面一段中
                }else {//否则就规定在后面
                    start = mid+1;
                }
            } else {//如果前面有序的个数小于后面有序的个数
                if (nums[mid] < target && nums[end] >= target){//并且target在后面的范围中
                    start = mid+1;//缩小范围在后面一段
                }else {//否则就在前面一段
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
