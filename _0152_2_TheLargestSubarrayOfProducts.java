package LeetCode;

public class _0152_2_TheLargestSubarrayOfProducts {
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        int curMax = nums[0];// 初始化 curMax 为第一个元素
        int max = nums[0];// 存储当前最大乘积
        int min = nums[0];// 存储当前最小乘积
        for (int i = 1; i < nums.length; i++) {
            if(nums [i]<0){//当前元素小于0，就交换最大值和最小值
                int temp = max;
                max = min;
                min = temp;
            }
            // 更新当前的最大值和最小值
            max = Math.max(max*nums[i],nums[i]);
            min = Math.min(min*nums[i],nums[i]);
            // 更新curMax
            curMax = Math.max(curMax,max);
        }
        return curMax;
    }
}
