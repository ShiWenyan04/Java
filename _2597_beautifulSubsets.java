package LeetCode;

import ShiYan6_2.Method;

import java.util.ArrayList;
import java.util.List;

public class _2597_beautifulSubsets {
    static int ans = 3;
    public static void main(String[] args) {
        int []nums = {2,4,6};
        int k = 2;
        List<List<Integer>>list = new ArrayList<>();
        Method(nums,k,list,new ArrayList<>(),0);
        System.out.println(list.size());
    }
    public static void Method(int []nums, int k, List<List<Integer>>list,List<Integer> list2,int index){
        boolean judge = true;
            for (int i = 0; i < list2.size(); i++) {
                for (int j = i+1; j < list2.size(); j++) {
                    if(Math.abs(list2.get(i) - list2.get(j)) == k){
                        judge = false;
                        return;
                    }
                }
            }
            if(judge && index!=0){
                list.add(new ArrayList<>(list2));
            }


        for (; index < nums.length; index++) {
            list2.add(nums[index]);
            Method(nums,k,list,list2,index+1);
            list2.remove(list2.size()-1);
        }
    }
}
