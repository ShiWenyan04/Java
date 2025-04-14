package LeetCode;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//示例 1：
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

import ShiYan6_2.Method;


import java.util.ArrayList;
import java.util.List;

//示例 2：
//输入：nums = [0]
//输出：[[],[0]]
public class _078_Subset {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(Method1(nums));
    }
    public static List<List<Integer>> Method1(int[] nums){

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {//在77题基础上增加了一个循环，根据子集内的元素个数分类，然后进行循环
            Method2(list, subset, nums,i, 0);

        }
        return list;
    }
    public static void Method2(List<List<Integer>> list, ArrayList<Integer> subset,int[] nums, int times,int index){
        if (times == subset.size()){
            list.add(new ArrayList<>(subset));
            return;
        }
       while(index < nums.length && times <= nums.length) {
           subset.add(nums[index]);
           Method2(list, subset, nums, times, index+1);
           subset.remove(subset.size()-1);
           index++;
        }
    }
}
