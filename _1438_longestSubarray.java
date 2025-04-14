package LeetCode;

import java.util.TreeMap;

public class _1438_longestSubarray {
    public static void main(String[] args) {
        int [] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(Method(nums,limit));
    }
    public static int  Method(int [] nums,int limit){
        TreeMap<Integer,Integer>map = new TreeMap<>();
        int n = nums.length;
        int right = 0,left = 0;
        int ans = 0;
        while(right  < n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left] )== 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
