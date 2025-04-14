package LeetCode;

import java.util.HashMap;

public class _1679_maxOperations {
    public static void main(String[] args) {
        int []nums = {3,5,1,5};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static int Method(int []nums,int k){
        int n = nums.length;
        HashMap < Integer,Integer> hashMap = new HashMap<>();
        int ans = 0 ;
        for (int i = 0; i < n; i++) {
            int c = hashMap.getOrDefault(k-nums[i],0);
            if(c > 0 ){
                hashMap.put(k-nums[i],c--);
                ans ++;
            }else {
                hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
            }
        }
        return ans;
    }
}
