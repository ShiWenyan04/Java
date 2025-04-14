package LeetCode;


public class _045_JumpingGame {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(Method(nums));
    }

    public static int Method(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int max = 0;
        int end = 0;
        for (int i = 0; i < n;i++){
            max = Math.max(max,nums[i]+i);//只保留最大步数能够到达的最远距离，然后待i遍历到最大距离之后，说明已经到达最大距离，此为跨了一步，
            //然后当前的数值能够到达的最远处更新为目的地，继续遍历
            if(nums[i] == end){
                end = max;
                ans++;
            }
        }
        return ans;
    }
}