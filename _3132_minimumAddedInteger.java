package LeetCode;

import java.util.Arrays;

public class _3132_minimumAddedInteger {
    public static void main(String[] args) {
        int [] nums1 = {4,20,16,12,8};
        int [] nums2 = {14,18,10};
        System.out.println(Method(nums1,nums2));
    }
    public static int Method(int []nums1,int []nums2){
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i >= 0 ; i--) {
            int x = nums2[0]-nums1[i];
            int j  = 0;
            int k = i;
            while(k<m){
                if(nums1[k]+x == nums2[j] && ++j == n){
                    return x;// nums2 是 {nums1[i] + x} 的子序列
                }
                k++;
            }
        }
        return nums2[1]-nums1[0];// 题目保证答案一定存在
    }
}
