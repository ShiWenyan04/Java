package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

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
//
//输入：nums = [1], k = 1
//输出：[1]

public class _0239_SlidingWindowMaximum_$ {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Method(nums,k));
    }

    public static int [] Method(int[] nums,int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        // 可以自己画一画 算一算答案数组的长度
        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 1. 入队时把比入队元素小的都拿出去
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 检查队首是不是已经出窗口了
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 如果符合窗口的长度 就更新答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[idx++] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}
