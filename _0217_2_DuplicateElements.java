package LeetCode;

import java.util.HashMap;

//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//示例 1：
//输入：nums = [1,2,3,1]
//输出：true
//示例 2：
//输入：nums = [1,2,3,4]
//输出：false
//示例 3：
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true
public class _0217_2_DuplicateElements {//运用哈希表
    public static void main(String[] args) {
        int []nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(Method(nums));
    }
    public static boolean Method(int [] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){//循环遍历，将数组中的值存入哈希表
            if(!hashMap.containsKey(nums[i])){//倘若哈希表已经有过这个值，就不存，反之就存
                hashMap.put(nums[i], i);
            }
        }
        if (hashMap.size() < nums.length){//哈希表的长度小于数组
            return true;
        }
        return false;
    }
}
