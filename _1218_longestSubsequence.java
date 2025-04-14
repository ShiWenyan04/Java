package LeetCode;

import java.util.HashMap;

public class _1218_longestSubsequence {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        int different = 1;
        System.out.println(Method(arr,different));
    }
    public static int Method(int []arr,int diff){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            map.put(arr[i],map.getOrDefault(arr[i]-diff,0)+1);
            maxLen = Math.max(maxLen,map.get(arr[i]));
        }
        return maxLen;
    }
}
