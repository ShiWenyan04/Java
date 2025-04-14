package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。
//示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//示例 2：
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//示例 3：
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
public class _015_2_TheSunOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> combination = new LinkedList<>();
        if (nums[0] > 0) {
            return list;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//去重：若当前元素与前一个元素相等，得到的结果前一次已经得到了
                continue;
            } else {
                combination.add(nums[i]);//先存入首个元素
                int temp = i + 1, j = nums.length - 1;
                while (temp < j) {
                    int num = nums[i]+nums[temp] + nums[j];
                    if ( num == 0) {
                        //去重
                        while (temp < j && nums[temp] == nums[temp + 1]) {
                            temp++;
                        }
                        //去重
                        while (temp < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        combination.add(nums[temp]);
                        combination.add(nums[j]);
                        list.add(new ArrayList<>(combination));
                        combination.remove(combination.size() - 1);
                        combination.remove(combination.size() - 1);
                        temp++;
                        j--;
                    }else if (num > 0){//和大于0，最右边数字向左移动
                        j--;
                    } else {//和小于0，temp对应数字向右移动
                        temp++;
                    }
                }
            }
            combination.remove(combination.size() - 1);//删除第一个数字，进行下一次循环
        }
        return list;
    }
}
