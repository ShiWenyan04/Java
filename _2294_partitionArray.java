package LeetCode;

import java.util.Arrays;
//示例 1：
//输入：nums = [3,6,1,2,5], k = 2
//输出：2
//可以将 nums 划分为两个子序列 [3,1,2] 和 [6,5] 。
//第一个子序列中最大值和最小值的差值是 3 - 1 = 2 。
//第二个子序列中最大值和最小值的差值是 6 - 5 = 1 。
//由于创建了两个子序列，返回 2 。可以证明需要划分的最少子序列数目就是 2 。
//示例 2：
//输入：nums = [1,2,3], k = 1
//输出：2
//可以将 nums 划分为两个子序列 [1,2] 和 [3] 。
//第一个子序列中最大值和最小值的差值是 2 - 1 = 1 。
//第二个子序列中最大值和最小值的差值是 3 - 3 = 0 。
//由于创建了两个子序列，返回 2 。注意，另一种最优解法是将 nums 划分成子序列 [1] 和 [2,3] 。
public class _2294_partitionArray {
    public static void main(String [] arg){
        int [] nums = {3, 6, 1, 2, 5};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static int Method(int [] nums,int k){
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];
        for (int num : nums) {
            // 如果当前元素和当前组的起始元素的差大于 k，则需要分组
            if(num - start > k){
                count++;// 新增一组
                start = num;// 更新当前组的起始元素
            }
        }
        return count;
    }
}
