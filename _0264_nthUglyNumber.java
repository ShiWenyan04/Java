package LeetCode;

import java.util.*;

public class _0264_nthUglyNumber {
    public static void main(String [] arg){
        int n = 10;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long>set = new HashSet<>();
        set.add(1L);
        queue.offer(1L);
        int []nums = {2,3,5};
        int u = 0;
        for (int i = 0; i < n; i++) {
            long curr = queue.poll();//取出最小的值
            u = (int)curr;//需要返回的int型答案
            for (int ele : nums) {//最小值依次乘每个元素
                long next = curr*ele;
                if(!set.contains(next)){//如果不是重复的数字，就存queue中自动排序，这样每次取出的值都是按顺序排列好的
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        return u;
    }
}
