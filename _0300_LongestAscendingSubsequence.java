package LeetCode;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
//示例 1：
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//示例 2：
//输入：nums = [0,1,0,3,2,3]
//输出：4
//示例 3：
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
public class _0300_LongestAscendingSubsequence {
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        System.out.println(Method(nums));
    }
//    public static int Method(int[] nums){
//        if (nums.length == 0) {//长度为0
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = 1;//首位长度肯定为1
//        int maxans = 1;
//        for (int i = 1; i < nums.length; i++) {//dp[i]对应的是索引以i为结尾的数的 升序最大长度
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {//循环遍历，判断nums[i]之前的每个值小于nums[i]
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1,dp[i]);//在现举例子中，nums[4]和nums[5]均小于nums[6]，但是nums[4]所对应的dp数值更大，连接的升序数组的长度最长，所以才会有Math.max的运用
//                }                                     //是将nums[4]的dp和nums[5]的dp进行比较，取最大，得出nums[6]的dp
//                maxans = Math.max(maxans,dp[i]);
//            }
//        }
//        return maxans;
//    }
    public static int Method(int[] nums){
        int n = nums.length;
        int[]f = new int[n];
        int piles = 0;
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0,right = piles;
            while(left < right){
                int mid = (left + right)/2;
                if(f[mid]>=poker){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            if(left== piles) piles++;
            f[left] = poker;
        }
        return piles;
    }
}
