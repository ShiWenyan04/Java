package LeetCode;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//示例 1：
//输入：nums = [2,3,2]
//输出：3;  解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//示例 2：
//输入：nums = [1,2,3,1]
//输出：4;  解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。偷窃到的最高金额 = 1 + 3 = 4 。
//示例 3：
//输入：nums = [1,2,3]
//输出：3
public class _0213_Loot_II {
    public static void main(String[] args) {
        int []nums = {1,7,9,2};
        if(nums.length == 1){
            System.out.println(nums[0]);;
        }else if (nums.length == 2){
            System.out.println( Math.max(nums[0],nums[1]));;
        }
        System.out.println( (Math.max(Method(nums,0,nums.length-2),Method(nums,1,nums.length-1))));;
        //        如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0,n−2],  如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1,n−1]
    }
    public static int Method(int [] nums,int index,int length){
        int []ans = new int[nums.length];//
        ans[index] = nums[index];
        ans[index+1] = Math.max(nums[index],nums[index+1]);
        for (int i = index+2; i <= length; i++) {
            ans[i] = Math.max(ans[i-1],ans[i-2]+nums[i]);
        }
        if (ans[ans.length-1 ]== 0 && ans[ans.length-2] != 0){//由于ans数组对应着每一个房子结果的可能性，所以如果偷0就不偷n-1，长度截止到n-2，如果不偷0就偷n-1，长度截止到n-1
            return ans[ans.length-2];
        }
        return ans[ans.length-1];
    }
}
