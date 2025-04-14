package LeetCode;

import java.util.*;

public class _1655_canDistribute {
    public static void main(String[] args) {
        int []nums = {1,1,1,1,2,2,2,2,2,2,2,2,2};
        int []quantity = {3,3,3,4};
        System.out.println(Method(nums,quantity));
    }
    public static boolean Method(int []nums,int []quantity){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int j : nums) {
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>( hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for (int i = 0; i < quantity.length; i++) {
            boolean judge = false;
            int x = quantity[i];
            for (Map.Entry<Integer,Integer> map:list) {
                int temp = map.getValue();
                if(temp >= x){
                    judge = true;
                    hashMap.put(map.getKey(),map.getValue()-x);
                    break;
                }
            }
            if(!judge){
                return false;
            }
        }
        return true;
    }
}
