package LeetCode;

import ShiYan6_2.Method;

//给定 m 个数组，每个数组都已经按照升序排好序了。
//现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
//返回最大距离。
//示例 1：
//输入：[[1,2,3],[4,5],[1,2,3]]
//输出：4
//解释：
//一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
//示例 2：
//输入：arrays = [[1],[1]]
//输出：0
public class _0624_ArrayMaximumDistance {
    public static void main(String[] args) {
        int [][] nums = {{0, 2, 3}, {4, 7}, {1, 2, 3}};
        System.out.println(Method(nums));
    }
    public static int Method(int [][]nums){
        int min = nums[0][0];
        int max = nums[0][nums[0].length-1];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int len = nums[0].length;
            int end = nums[0][len-1];
            int abs1 = Math.abs(end - min);//当前数组中最大值（数组最后一个值）和上一次所记录的最小值之差
            int abs2 = Math.abs(max - nums[i][0]);//当前数组中最小值（数组第一个值）和上一次所记录的最大值之差
            res = Math.max(res,Math.max(abs1,abs2));//利用上面的方法，有效的避免了最大值和最小值同时记录成同一个数组的数字 eg【1，4】【0，5】.结果为4，并非是5
            max = Math.max(max,end);
            min = Math.min(min,nums[i][0]);
        }
        return res;
    }
}
