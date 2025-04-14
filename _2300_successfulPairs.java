package LeetCode;

import java.util.Arrays;

public class _2300_successfulPairs {
    public static void main(String[] args) {
        int []spells = {5,1,3};
        int []potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(Method(spells, potions, success)));
    }
    public static int[] Method(int []spells,int []potions,int success){
        int []ans = new int[spells.length];
        int m = potions.length;
        for (int i = 0; i < spells.length; i++) {
            int num = spells[i];
            int left = 0,right = m-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(potions[mid]*num >= success){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            ans[i] = m-left;
        }
        return ans;
    }
}
