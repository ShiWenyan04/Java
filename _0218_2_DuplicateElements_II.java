package LeetCode;

import java.util.HashMap;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
//示例 1：
//输入：nums = [1,2,3,1], k = 3
//输出：true
//示例 2：
//输入：nums = [1,0,1,1], k = 1
//输出：true
//示例 3：
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
public class _0218_2_DuplicateElements_II {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static boolean Method(int [] nums,int k){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]) && i-hashMap.get(nums[i]) <= k){
                return true;//num[i]作为key，i作为value，倘若存在nums[i]的key，且i-这个key对应的坐标符合条件为true
            }
            hashMap.put(nums[i], i );//其他情况，存入哈希表
        }
        return false;
    }
}
