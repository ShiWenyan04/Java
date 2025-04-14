package LeetCode;
//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//示例 1：
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//示例 2：
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
public class _055_JumpingGame {
    public static void main(String[] args) {
        int []nums = {1,1,2,2,0,1,1};
        System.out.println(Method(nums));
    }
    public static boolean Method(int [] nums){
        if(nums.length == 1) return true;
        if(nums.length != 1 && nums[0] == 0) return false;//倘若第一位就是0，那么就停在第一位，直接false
        for (int i = 0; i < nums.length; i++) {//遍历数组
            if(nums[i] >= nums.length-i-1){//如果当前值大于等于末尾到当前位置的长度，说明在当前位置可以跳过去
                return true;
            }
            if(nums[i] == 0){//如果遇见了0，就需要先计算往后的0有多少个，然后重新遍历数组，如果遍历数组的值刚好可以跳过这些0，那就将i的索引跳到这里来
                int count = Method2(nums,i);//计算0的个数
                for (int j = 0; j < i; j++) {//遍历数组，查询可跳跃的数组值
                    if(nums[j] >= i+count-j){
                        i = i + count -1;
                        break;
                    }else if (j == i-1){
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public static int Method2(int []nums,int k){//计算0的个数
        int i = k;
        for (; i < nums.length; i++) {
            if (nums[i] != 0){
                break;
            }
        }
        return i - k;
    }
}
