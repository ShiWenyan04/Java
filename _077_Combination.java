//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//你可以按 任何顺序 返回答案。

//示例 1：
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],//这道题类似第17题，可比较着学习
//]
//示例 2：
//输入：n = 1, k = 1
//输出：[[1]]


package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _077_Combination {
    public static void main(String[] args) {
        int n = 4,k = 2;
        System.out.println(Method1(n,k));
    }
    public static List<List<Integer>> Method1(int n, int k){
        ArrayList<List<Integer>> list=new ArrayList<>();//创建包含数组的list,即可看成是二位数组;//创建包含数组的list,即可看成是二位数组
        ArrayList<Integer> combination = new ArrayList<>();
        Method2(list, combination, n, k, 0);//调用方法二
        return list;
    }
    public static void Method2(ArrayList<List<Integer>> list, ArrayList<Integer> combinaton, int n, int k, int index){
        if (combinaton.size() == k){
            list.add(new ArrayList<>(combinaton));
            return;
        }
        while (index < n) {
            combinaton.add(index+1);//存储第一个数字在第一个数组，由于数字从一开始，故直接index+1即可
            Method2(list, combinaton, n, k,index+1);//递归开始存储第二个数字在第一个数组
            combinaton.remove(combinaton.size()-1);//删去末尾数字，以便下一次的数字存储
            index++;
        }
    }
}
