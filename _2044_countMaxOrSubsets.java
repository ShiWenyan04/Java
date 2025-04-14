package LeetCode;

import ShiYan6_2.Method;
import com.sun.corba.se.impl.encoding.CDROutputObject;

public class _2044_countMaxOrSubsets {
    static int ans = 0;
    public static void main(String[] args) {
        int []nums = {3, 1};
        int max = 0;
        for (int num : nums) {
            max|=num;
        }
        Method(nums,max,0,0);
        System.out.println(ans);
    }
    public static void Method(int []nums,int max,int value , int index){
        if(index == nums.length){
            if (max == value){
                ans ++;
            }
            return ;
        }
        Method(nums,max,value|nums[index],index+1);
        Method(nums,max,value,index+1);
    }
}
