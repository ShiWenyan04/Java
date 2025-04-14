package LeetCode;
import java.util.ArrayList;
import java.util.List;

//给你一个整数数组 nums ，你可以对它进行一些操作。
//每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
//开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//示例 1
//输入：nums = [3,4,2]
//输出：6解释：删除 4 获得 4 个点数，因此 3 也被删除。之后，删除 2 获得 2 个点数。总共获得 6 个点数。
//示例 2：
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：删除 3 获得 3 个点数，接着要删除两个 2 和 4 。之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。总共获得 9 个点数。
public class _0740_DeleteAndEarnPoints {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,4,5,5,5,6};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        List<Integer> f = new ArrayList<>();
        int max = 0;

        for (int i : nums) {//求得最大值
            max = Math.max(max,i);
        }
        int [] sum = new int[max +1];//sum存放着索引与nums相对的值的和，即sum【1】 存放所有sums中1的和
        for (int n : nums){
            sum[n] = sum[n]+n;
        }
        int []ans =  new int[max+1];//ans存放这当前索引能够取得的最大值
        ans [0] = sum[0];//ans存放这当前索引能够取得的最大值
        ans [1] = Math.max(ans[0],sum[1]);//ans存放这当前索引能够取得的最大值
        if (nums.length == 1){
            return sum[max];//长度等于一，且sum每个索引里的和从大到小排序，答案为sum【1】，也就是sum【max】
        }else {
            for (int i = 2; i < sum.length; i++) {
                ans[i] = Math.max(ans[i-1], sum[i]+ans[i-2]);
                //ans存放这当前索引能够取得的最大值，总是要与前一个ans比较，当前ans应该为（当前所对应的sum加上前一个ans）与（上一个ans）的最大值
            }
        }
        return ans[max];
    }
}