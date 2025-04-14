package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//示例 1：
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//示例 2：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class _047_FullyArranged_II {
    public static void main(String[] args) {
        int []nums = {1,1,1,2};
        System.out.println(Method1(nums));
    }
    public static List<List<Integer>> Method1(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        boolean []visited = new boolean[nums.length];
        int n = nums.length;
        Method2(list,com,new HashSet(),nums,visited, n);
        return list;
    }
    public static void Method2(List<List<Integer>> list, List<Integer> com, HashSet hashSet, int [] nums, boolean[] visited, int n ){
        if (com.size()==n && !hashSet.contains(com)){//当长度相等且哈希表中不存在这个组合时，结束递归
            list.add(new ArrayList<>(com));
            hashSet.add(com);//存入哈希表
            return;
        }
        for (int index = 0; index < n; index++) {//每一次递归都是从首位开始录入
            if (visited[index]) {//遇见使用过的（true)，结束当前循环
                continue;
            }else {//若未使用过，令当前值变为使用过
                visited[index] = true;
                com.add(nums[index]);
                Method2(list,com,hashSet,nums,visited,n);
                com.remove(com.size()-1);
                visited[index] = false;//一次递归结束，使当前使用过的值初始化
            }
        }
    }
}
