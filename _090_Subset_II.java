package LeetCode;

import java.util.*;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
//子集
//（幂集）。
//解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//示例 1：
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//示例 2：
//输入：nums = [0]
//输出：[[],[0]]
public class _090_Subset_II {
    public static void main(String[] args) {
        int [] nums = {4,4,4,1,4};
        System.out.println(Method(nums));
    }
    public static List<List<Integer>> Method(int [] nums){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int times = 1; times <= nums.length; times++) {
            Method2(nums, times, 0, list,group,hashSet);
        }
        return list;
    }
    public static void Method2(int[] nums,int times,int index, List<List<Integer>> list,List<Integer> group,HashSet<String> hashSet){
        if (group.size() == times && times != 0){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < group.size(); i++) {//将数字变为字符串，并用，隔开，造成集合的形象
                s.append((group.get(i))).append(",");
            }
            if (!hashSet.contains(s.toString())){//判断哈希表中是否存在这个s，存在即为重复
                hashSet.add(s.toString());
                list.add(new ArrayList<>(group));
            }
            return;
        }
        for (; index < nums.length; index++) {
            group.add(nums[index]);
            Method2(nums,times,index+1,list,group,hashSet);
            group.remove(group.size()-1);
        }
    }
}
