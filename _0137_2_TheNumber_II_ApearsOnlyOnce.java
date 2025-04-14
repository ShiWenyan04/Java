package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
//示例 1：
//输入：nums = [2,2,3,2]
//输出：3
//示例 2：
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
public class _0137_2_TheNumber_II_ApearsOnlyOnce {
    public static void main(String[] args) {
        int [] nums = {0,1,0,1,0,1,99};
        System.out.println(Method(nums));
    }
    public static int Method(int[]nums){
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(nums);//将相同字母排列到一起
        int times = 0;
        for(int i=0;i<nums.length;i++){
            if (!deque.isEmpty() && deque.peek() == nums[i]){//栈顶和当前元素相等
                deque.poll();
                deque.push(nums[i]);
                times ++;//遇见相同元素的次数
                if (times == 3){
                    deque.poll();//清空相同元素
                    times=0;
                }
            }else if(deque.isEmpty()){//为空就录入当前元素
                deque.push(nums[i]);
                times ++;//记录元素的次数
            }
        }
        return deque.peek();
    }
}
