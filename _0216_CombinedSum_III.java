package LeetCode;
import java.util.ArrayList;
import java.util.List;
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//只使用数字1到9,每个数字 最多使用一次
//返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//示例 1:
//输入: k = 3, n = 7
//输出: [[1,2,4]]  解释:1 + 2 + 4 = 7
//示例 2:
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]  解释:1 + 2 + 6 = 9,    1 + 3 + 5 = 9,    2 + 3 + 4 = 9
//示例 3:
//输入: k = 4, n = 1
//输出: []  解释: 不存在有效的组合。在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
public class _0216_CombinedSum_III {
    public static void main(String[] args) {
        int k = 9,n = 45;
        System.out.println(Method(k,n));
    }

    public static List<List<Integer>> Method(int k, int n) {
        int [] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        if (k > n || k <n && k ==9 && n != 45){
            return list;
        }
        Method2(k,n,nums,list,com,0,0);
        return list;
    }
    public static void Method2(int k,int n,int[] nums, List<List<Integer>> list, List<Integer> com, int sum, int i){
        if (sum == n && com.size() == k  ){
            list.add(new ArrayList<>(com));
            return;
        }
        for(;i< nums.length;i++){
            if (sum+nums[i] <= n && com.size()+1<=k){
                sum += nums[i];
                com.add(nums[i]);
                Method2(k,n,nums,list,com,sum,i+1);
                com.remove(com.size()-1);
                sum-=nums[i];
            }
        }
    }
}
