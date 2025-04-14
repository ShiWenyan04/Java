package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//0 <= a, b, c, d < n,且a、b、c 和 d 互不相同，nums[a] + nums[b] + nums[c] + nums[d] == target，你可以按 任意顺序 返回答案 。
//示例 1：
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//示例 2：
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
public class _018_TheSumOfTheFourNumbers {
    public static void main(String[] args) {
        int []nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums,target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        if(nums.length<4){
            return list;
        }
        if ((long)nums[0] + nums[1] + nums[2] + nums[3] > target){
            return list;
        }
        for (int i = 0; i < nums.length-3; i++) {
            if (i==0 || ((i>0) && nums[i-1] != nums[i])){
                combination.add(nums[i]);
                for (int j = i+1; j < nums.length-2; j++) {//比三数之和多一层循环
                    if (j==i+1 || ((j>i+1) && nums[j-1] != nums[j])) {
                        combination.add(nums[j]);
                        int left = j+1;
                        int right = nums.length-1;
                        while (left<right){
                            long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];//防止int溢出
                            if (sum == target){
                                while(left != right-1 && left<right && nums[left+1] == nums[left]){
                                    left++;
                                }
                                while (left+1 != right && left<right && nums[right-1] == nums[right]){
                                    right--;
                                }
                                combination.add(nums[left]);
                                combination.add(nums[right]);
                                list.add(new ArrayList<>(combination));
                                combination.remove(3);
                                combination.remove(2);
                                right--;
                                left++;
                            } else if (sum>target) {
                                right--;
                            }else {
                                left++;
                            }
                        }
                        combination.remove(1);
                    }
                }
                combination.remove(0);
            }
        }
       return list;
    }
}
