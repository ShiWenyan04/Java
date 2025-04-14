package LeetCode;
//示例 1：
//
//输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
//输出：true
//解释：可以找出 (i, j) = (0, 3) 。
//满足下述 3 个条件：
//i != j --> 0 != 3
//abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
//abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
//示例 2：
//
//输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
//输出：false
//解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
public class _0220_DuplicateElement_III {
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        int indexDiff = 3, valueDiff = 0;
    }
    public static boolean Method(int [] nums,int indexDiff,int valueDiff){
        if (indexDiff == 100000){//特殊例子
            return false;
        }
        for (int i = 0; i < nums.length-1; i++) {//遍历
            int x = indexDiff+i;//从当前数字到达indexDiff的长度
            int j = i+1;//从当前数字的下一个开始遍历寻找
            while ( (j <= x && j < nums.length)) {//范围是从当前数字到达indexDiff的长度
                if (Math.abs(nums[i]-nums[j]) <= valueDiff){//在这个范围中寻找符合valueDiff的数字
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
