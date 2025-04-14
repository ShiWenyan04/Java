package LeetCode;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//你可以按任意顺序返回答案。

//示例 ：
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
import java.util.Scanner;

public class _01_TheSum {
    public static void main(String[] args) {
        int []nums = new int[5];
        Scanner in = new Scanner(System.in);
//        设置目标值和搜索范围
        System.out.println("请输入目标值");
        int target = in.nextInt();
        System.out.println("请输入数组");
        for (int i = 0; i <5;++i) {
           nums[i]= in.nextInt();
        }
//        相加求和
        for (int i = 0; i <5 ; ++i) {
            for (int j =i+ 1; j <5 ; ++j) {
               if (nums[i]+nums[j]==target){
                   System.out.println("["+i+","+j+"]");
               }
            }
        }
    }
}

