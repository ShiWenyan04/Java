package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//示例 1：
//输入：nums = [3,2,3]
//输出：[3]
//示例 2：
//输入：nums = [1]
//输出：[1]
//示例 3：
//输入：nums = [1,2]
//输出：[1,2]
public class _0229_MostElement_II {
    public static void main(String[] args) {
        int []nums = {3,2,3};
        System.out.println();
    }
    public static List<Integer> Method(int[] nums){
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0],1);
        for (int i = 1; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){//判断这个元素是否出现过
                hashMap.put(nums[i],hashMap.get(nums[i])+1);//出现过就次数加一，即value+1
            }else {
                hashMap.put(nums[i],1);//没出现过就添加进去
            }
        }
        for (Integer key: hashMap.keySet()){//遍历，寻找key>=3的value
            if (hashMap.get(key) > nums.length/3) {
                list.add(key);
            }
        }
        return list;
    }
}
