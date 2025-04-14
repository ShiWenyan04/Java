package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

//给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 质数 组成，且其中所有整数互不相同。
//对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
//那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
//示例 1：
//输入：arr = [1,2,3,5], k = 3
//输出：[2,5]
//解释：已构造好的分数,排序后如下所示:
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//很明显第三个最小的分数是 2/5
public class _0786_The_k_SmallestPrimeFraction {
    public static void main(String[] args) {
        int []arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(Method(arr, k)));
    }
    public static int[] Method(int[] arr,int k){
        int n = arr.length;
        // 创建一个优先队列，用于存储元素对，按分数大小排序
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> Double.compare(b[0]*1.0/b[1],a[0]*1.0/a[1]));
        // 两层循环，生成所有可能的元素对 (arr[i], arr[j])
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // 计算当前元素对的分数
                double temp = arr[i]*1.0/arr[j];
                if(pq.size()<k){
                    // 如果优先队列中的元素少于 k，直接添加当前元素对
                    pq.add(new int[]{arr[i],arr[j]});
                } else if (pq.size() == k && pq.peek()[0]*1.0/pq.peek()[1] > temp) {
                    // 如果优先队列已满 k，检查分数大小是否大于当前队列里的最小分数大小
                    pq.poll();
                    pq.add(new int[]{arr[i],arr[j]});
                }
            }
        }
        // 返回分数k最小的元素对
        return pq.poll();
    }
}
