package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.list;

//你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
//你需要重复以下步骤 n / 2 次：
//从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。将 (minElement + maxElement) / 2 加入到 averages 中。返回 averages 中的 最小 元素。
//输入： nums = [7,8,3,4,15,13,4,1]
//输出： 5.5
//解释：
//步骤	nums	averages
//0	[7,8,3,4,15,13,4,1]	[]
//1	[7,8,3,4,13,4]	[8]
//2	[7,8,4,4]	[8,8]
//3	[7,4]	[8,8,6]
//4	[]	[8,8,6,5.5]
//返回 averages 中最小的元素，即 5.5。
public class _3194_TheMinimumAverageOfSmallestAndLargest {
    public static void main(String[] args) {
        int []nums = {7,8,3,4,15,13,4,1};
        System.out.println(Method(nums));
    }
    public static double Method(int [] nums){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        double ans = Integer.MAX_VALUE;
        for (int i: nums){
            list.add(i);
        }
        for (int i = 0; i < nums.length/2; i++) {
            ans = Math.min(ans, (double) (list.get(0) + list.get(list.size() - 1)) /2);
            list.remove(0);
            list.remove(list.size()-1);
        }
        return ans;
    }
}
