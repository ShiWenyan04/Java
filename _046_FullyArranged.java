package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//示例 1：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//示例 2：
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//示例 3：
//输入：nums = [1]
//输出：[[1]]
public class _046_FullyArranged {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(Method1(nums));
    }
    public static List<List<Integer>> Method1(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        boolean []visited = new boolean[nums.length];
        int n = nums.length;
        Method2(list,com,nums,visited, n);//第一次递归
        return list;
    }
    public static void Method2(List<List<Integer>> list,  List<Integer> com, int [] nums, boolean[] visited, int n ){
        if (com.size()==n){//当长度相等时，结束递归
            list.add(new ArrayList<>(com));
            return;
        }
        for (int index = 0; index < n; index++) {//每一次递归都是从首位开始录入
            if (visited[index]) {//遇见使用过的（true)，结束当前循环
                continue;
            }else {//若未使用过，令当前值变为使用过
                visited[index] = true;
                com.add(nums[index]);
                Method2(list,com,nums,visited,n);
                com.remove(com.size()-1);
                visited[index] = false;//一次递归结束，使当前使用过的值初始化
            }
        }
    }
}
