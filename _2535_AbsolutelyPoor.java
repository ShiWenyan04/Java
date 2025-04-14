package LeetCode;
//给你一个正整数数组 nums 。
//元素和 是 nums 中的所有元素相加求和。
//数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
//返回 元素和 与 数字和 的绝对差。
//注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
//示例 1：
//输入：nums = [1,15,6,3]
//输出：9
//解释：
//nums 的元素和是 1 + 15 + 6 + 3 = 25 。
//nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
//元素和与数字和的绝对差是 |25 - 16| = 9 。
public class _2535_AbsolutelyPoor {
    public static void main(String[] args) {
        int [] nums = {4,7,3,4,5,8,10,3,9,7};
        System.out.println(Method(nums));
    }
    public static int Method(int[] nums){
        int ans1 = 0,ans2 = 0;
        for (int i : nums){//遍历累加
            ans1 += i;
            while(i > 9){//当前数大于9，取余运算，累计相加
                ans2 += i%10;
                i/=10;
            }
            ans2 += i;
        }

//        for (int i = 0; i < nums.length; i++) {//遍历，先计算总值，顺便判断是否是个位数，如果全是个位数，就返回0
//            if(nums[i]<9 && nums[i]>0 && judge ){
//                judge = true;
//            }else{
//                judge = false;
//            }
//            ans1 += nums[i];
//        }
//        if (judge){//返回0
//            return 0;
//        }
//        for (int i = 0; i < nums.length; i++) {//遍历第二次，如果是个位数，直接计算，如果不是个位数，就化成字符串进行计算
//            if (nums[i]<9 && nums[i]>0){
//                ans2 += nums[i];
//            }else {
//                String s = String.valueOf(nums[i]);
//                for (int j = 0; j < s.length(); j++) {
//                    ans2 += Integer.valueOf(s.substring(j,j+1));
//                }
//            }
//        }
        return Math.abs(ans2-ans1);
    }
}
