package LeetCode;

import java.util.*;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
public class _0347_Top_K_HighFrequencyElements {
    public static void main(String[] args) {
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(Method(nums, k)));
    }

    private static int [] Method(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        for (int i : nums){
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i)+1);
            }else{
                hashMap.put(i,1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashMap.get(a)-hashMap.get(b);
            }
        });
//        pq保存的是数字，pq顶端为出现最多次的频率的数字，如果新的数字的频率大于pq顶端的数字出现的频率，就替换
        for (int key : hashMap.keySet()){
            if (pq.size()<k){
                pq.add(key);
            } else if (hashMap.get(key) > hashMap.get(pq.peek())) {//pq在哈希表中充当key的作用
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int []ans = new int[k];
        for (int i = 0; i < k; i ++){
            ans[i] = pq.remove();
        }
        return ans;
    }
}
