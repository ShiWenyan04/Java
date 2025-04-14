package LeetCode;

import java.util.*;

//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
//示例 1：
//输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
public class _0692_TheFirst_K_High_FrequencyWords {
    public static void main(String[] args) {
        String []words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(Method(words,k));
    }
    public static List<String> Method(String [] words, int k){
        HashMap<String,Integer> hashMap = new HashMap<>();
//        哈希存出现单词次数和单词，分别为key和value
        for (String word : words) {
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }
//          用最小堆保存频率最大的k个元素
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int a1 = hashMap.get(a);
                int a2 = hashMap.get(b);
                // 首先按频率降序排列，如果频率相同，则按字典顺序升序排列
                if (a1==a2) {
                    return b.compareTo(a);
                }
                // 频率高的排前面，使用降序比较
                return a1 -a2;
            }
        });
//          遍历map，维护最小堆的大小为k
        for (String key : hashMap.keySet()) {
            if(pq.size()<=k){
                pq.offer(key);
            }
            // 如果堆的大小超过 k，移除频率最低的元素
            if(pq.size()>k) {
                pq.poll();
            }
        }
//        数组存入最后留下来的k个元素
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add( pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
