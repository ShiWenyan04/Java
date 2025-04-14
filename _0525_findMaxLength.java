package LeetCode;

import java.util.HashMap;

public class _0525_findMaxLength {
    public static void main(String[] args) {
        int [] nums = {0,1};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        int n = nums.length;
        int []add = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            add[i] = add[i-1]+nums[i-1];
        }
        int len=0;
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        for (int i = 0; i < n+1; i++) {
            int diff = add[i]*2-i;
            if(hashMap.containsKey(diff)){
                len = Math.max(len,i-hashMap.get(diff));
            }else {
                hashMap.put(diff,i);
            }
        }
        return len;
    }
}
