package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用 一次 。
//注意：解集不能包含重复的组合。
//示例 1:
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//示例 2:
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
public class _040_SumOfCombinations {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(Method1(candidates, target));
    }
    public static List<List<Integer>> Method1(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> group = new ArrayList<>();
        Arrays.sort(candidates);
        Method2( candidates, target, list,  group, 0, 0);
        return list;
    }
    public static void Method2( int[] candidates, int target, ArrayList<List<Integer>> list, ArrayList<Integer> group, int start, int result){
        if (result == target){//结果相等，存入list
            list.add(new ArrayList<>(group));
            return;
        }
        int index = start;
        while(index < candidates.length && result + candidates[index] <= target ){
            if (index > start && candidates[index] == candidates[index - 1]) {//遇见可以凑成target的重复数字跳过，进行下一个,start为存入group的最后一个数字的索引
                index++;                                                      //为删除未使用过数字当中，能构成target的重复数字
                continue;
            }
            result = result + candidates[index];//结果小于target就相加
            group.add(candidates[index]);//填入数组group
            Method2(candidates,target,list,group,index+1,result);//引入下一个数字，重复上述过程，判断能否构成target，并去除重复数字
            result -= group.get(group.size()-1);//减去最后一个数字，为下一个数字做准备
            group.remove(group.size()-1);//减去最后一个数字，为下一个数字做准备
            index++;
        }
    }
}
