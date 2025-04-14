package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位
//示例 1：
//输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
//示例 2：
//输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
public class _2605_GenerateTheSmallestNumber {
    public static void main(String[] args) {
        int [] nums1 = {5,7,1,6,8};
        int [] nums2 = {2,4,6,3};
        System.out.println(Method(nums1,nums2));
    }
    public static int Method(int [] nums1,int []nums2){
        HashSet<Integer> hashSet = new HashSet<>();
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.max(nums1.length,nums2.length); i++) {
            if(i <nums1.length){//计算nums1的最小值，依次存入哈希表
                hashSet.add(nums1[i]);
                min1 = Math.min(min1,nums1[i]);
            }
            if(i < nums2.length){//计算nums2的最小值
                min2 = Math.min(min2,nums2[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(hashSet.contains(nums2[i])){//判断是否有相同值，依次存入list
                list.add(nums2[i]) ;
            }
        }
        for(Integer i : list){//遍历list，寻求相同值中的最小值
            ans = Math.min(i,ans);
        }
        if (ans != Integer.MAX_VALUE){//ans改变，说明有相同的最小值出现
            return ans;
        }else {//否则就两个数列的最小值构成最小的两位数
            ans = Math.min(min1,min2)*10 + Math.max(min1,min2);
        }
        return ans;
    }
}
