package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
//示例 1：
//输入：nums = [2,2,3,2]
//输出：3
//示例 2：
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
public class _0137_1_TheNumber_II_ApearsOnlyOnce {
    public static void main(String[] args) {
        int [] nums = {0,1,0,1,0,1,99};
        System.out.println();
    }
    public static int Method(int[]nums){
        HashSet<Integer> hashset = new HashSet<>();
        boolean []judge = new boolean [nums.length ];
        Arrays.sort(nums);
        int number = 0;
        for(int i=0;i<nums.length;i++){
            if (!hashset.contains(nums[i])){//如若只出现一次就打为true；
                judge[i] = true;
                hashset.add(nums[i]);
            }else if(i!=0&&nums[i]==nums[i-1]||hashset.contains(nums [i])){//出现多次，就取消前一个的true，变为false
                judge [i-1]=false ;
                continue;
            }
        }
        for(int i=0;i<nums.length;i++){//查找为true的索引，索隐所对的nums即为出现过一次的数据
            if(judge[i]==true){
                number = nums[i];
            }
        }
        return number;
    }
}
