package LeetCode;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。
//示例 1：
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//示例 2：
//输入：nums = [1], k = 1
//输出：[1]
public class _0237_SlidingWindowMaximum_$ {
    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Method(nums,k));
    }

    public static int[] Method(int[] nums,int k) {
        int len = nums.length;
        int[] nums2 = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {//确定滑动窗口的起始点
            int max = nums[i];
            for (int j = i; j < i + k - 1; j++) {//划分好滑动窗口的终点，然后进行大小比较
                max = Math.max(max, nums[j + 1]);
            }
            nums2[i] = max;
        }
        return nums2;
    }
}
