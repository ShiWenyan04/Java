package LeetCode;
//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
//示例 1：
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
//示例 2：
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组
//示例 3：
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
public class _0334_increasingTriplet {
    public static void main(String[] args) {
        int []nums = {6,7,1,2};
        System.out.println(Method(nums));
    }
    public static boolean Method(int [] nums){
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int firstNum = nums[0], secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++){
            int thirdNum = nums [0];
            if(secondNum < thirdNum){//f,s,t,分别代表三个数，如果第三个数大于第二个数return true
                return true;
            }else if(thirdNum > firstNum ){//在第三个数小于第二个数的时候，第三个数大于第二个数，说明第三个数的位置原本因该在第二位
                secondNum = thirdNum;
            }else {//如果第三个数也小于第一个数，说明第三个数应该是排第一位的
                firstNum = thirdNum;
            }
        }
        return false;
    }
}
