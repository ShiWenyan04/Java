package LeetCode;

import java.util.HashMap;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。
//示例 1：
//输入：nums = [1,1,1], k = 2
//输出：2
//示例 2：
//输入：nums = [1,2,3], k = 3
//输出：2
public class _0560_And_Is_A_SubarrayOf_K {
    public static void main(String[] args) {
        int []nums = {1,1,1};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static int Method(int [] nums,int k){
        int []add = new int[nums.length];
        int ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for (int i = 0;i < nums.length ; i++) {
            if (i == 0){//求前缀和
                add[0] = nums[0];
            }else {
                add[i] = nums[i] + add[i-1];
            }
            if (hashMap.containsKey(add[i] - k)) {
//                因为假设从i到j的和为k，因为之前计算了前缀和，所以只需要满足add[j]-add[i]=k，就可以，移项得add[j]-k = add[i],只需判断add[i]出现的次数就可
                ans += hashMap.get(add[i]-k);
            }
            hashMap.put(add[i], hashMap.getOrDefault(add[i], 0) + 1);
        }
        return ans;
    }
}
