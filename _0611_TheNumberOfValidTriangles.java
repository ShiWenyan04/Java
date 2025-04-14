package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
//示例 1:
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是:
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//示例 2:
//输入: nums = [4,2,3,4]
//输出: 4
public class _0611_TheNumberOfValidTriangles {
    public static void main(String[] args) {
        int []nums = {2,2,3,4};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length-1; i > 2; i--) {
            int a = nums[i];
            int j = i-1,k=0;
            while(k < j){
                if(nums[j] + nums[i] > a){//因为数组已经排过序，从小到大，所以规定好一个数值，另外两个数值可以通过双指针来判断是否能够和a组成三角形
                    ans+=j-k;//倘若当前的j已经无法满足条件，则j之前的所有都无法满足，此时需要将k向后移动，使最小值变大
                    j--;
                }else {//因为数组已经排过序，从小到大，所以如果当前索引的值与j和a无法构成三角形，说明k对应的值太小了，需要变大
                    k++;
                }
            }
        }
        return ans;
    }
}
