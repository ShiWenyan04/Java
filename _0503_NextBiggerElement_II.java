package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
//数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
//示例 1:
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数；
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
//示例 2:
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
public class _0503_NextBiggerElement_II {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,3};
        System.out.println(Method(nums));
    }
    public static int[] Method(int[] nums){
        int n = nums.length;
        int []arr = new int[n];
        Arrays.fill(arr,-1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 2*n-1; i++) {
//            因为栈在压入最后一个元素的索引时，后面无索引可以比较，所以我们可以将数组的长度变为两倍，然后取余
//            这样就可以使最后一位元素同前面的元素进行比较了
            int x = nums[i%n];
            while (!deque.isEmpty() && nums[deque.peek()] < x){
                // x 是 nums[st.peek()] 的下一个更大元素
                // 既然 nums[st.peek()] 已经算出答案，则从栈顶弹出
                arr[deque.pop()] = x;
            }
//            仅在第一次遍历时压入栈中，因为当遍历到数组当中的组后一个元素时，后面再无元素需要判断，当前为最后一个需要判断的数字
//            无需再压入栈，只用判断就可以，
            if (i < n){
                deque.push(i);
            }
        }
        return arr;
    }
}
