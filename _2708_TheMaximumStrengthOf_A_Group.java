package LeetCode;
//给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
//
//请你返回老师创建的小组能得到的最大实力值为多少。
//
//
//
//示例 1：
//
//输入：nums = [3,-1,-5,2,5,-9]
//输出：1350
//解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
//示例 2：
//
//输入：nums = [-4,-5,-4]
//输出：20
//解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
public class _2708_TheMaximumStrengthOf_A_Group {
    public static void main(String[] args) {
        int [] nums = {6,-3,-4,8,4,7,6,4,7,7,-3,-6,9};
        System.out.println(maxStrength(nums));
    }
    public static long maxStrength(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        long ans = 1,max = Integer.MIN_VALUE;//ans为乘积之和，max为负数中绝对值最大的负数
        int zero = 0;//zero记录0的个数

        for (int i =0;i<nums.length;i++){
            if(nums[i]==0) {//元素为0，就记录元素数量，且不进行乘法运算
                zero++;
                continue;
            }
            ans *= nums [i];//乘积
        }
        if (zero == nums.length){//0的数量等于数组长度，直接返回0
            return  0;
        }
        //ans大于零，直接返回
        if (ans > 0){
            return ans;
        }else {
            if(zero > nums.length-2){//如果0的数量很多，使得非零数的个数凑不到2,例如{0，0，0，0，-1}
                for (int i = 0; i < nums.length; i++) {//遍历寻找非零数，并判断其大小
                    if (nums[i] > 0){
                        return nums[i];
                    }else {
                        return 0;
                    }
                }
            }else {//否则除以 绝对值最小的负数，即最大的负数。
                for (int i =0;i<nums.length;i++){
                    if (nums[i]<0){
                        max = Math.max(max,nums [i]);
                    }
                }
            }
        }
        ans/=max;
        return ans;
    }
}
