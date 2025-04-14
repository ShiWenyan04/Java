package LeetCode;

import java.util.PriorityQueue;

public class _3066_minOperations {
    public static void main(String [] arg){
        int [] nums = {2, 11, 10, 1, 3};
        int k = 10;
        System.out.println(Method(nums,k));
    }
    public static int Method(int [] nums,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        int count = 0;
        while(queue.peek() < k){
            int x = queue.poll(),y = queue.poll();
            queue.offer(x*2+y);
            count ++;
        }
        return count;
    }
}
