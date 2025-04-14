package LeetCode;

import java.util.HashMap;

public class _0523_checkSubarraySum {
    public static void main(String[] args) {
        int []nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(Method(nums,k));
    }
    public static boolean Method(int []nums,int k){
        int n = nums.length;
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        int []add = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            add[i] = nums[i-1]+add[i-1];
        }
        for (int i = 0; i < n+1; i++) {
            int mod = add[i]%k;
            if(hashMap.containsKey(mod) && i > hashMap.get(mod)+1){
                return true;
            }else if (!hashMap.containsKey(mod)){
                hashMap.put(mod,i);
            }
        }
        return false;
    }
}
