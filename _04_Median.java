package LeetCode;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//算法的时间复杂度应该为 O(log (m+n)) 。

//示例 1：
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2

//示例 2：

import sun.security.util.ArrayUtil;

import java.util.Arrays;

//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
public class _04_Median {
    public static void main(String[] args) {
        int [] strs1 = {0};
        int [] strs2 = {0};
        int [] strs3 = Merge(strs1,strs2);//合并
        Arrays.sort(strs3);//排序
        double median;
        int a = (strs3.length)/2;
            if (strs3.length%2 == 0){//奇数还是偶数
                median = (strs3[a] + strs3[a-1])/2.0;
            }else {
                median = strs3[a];
            }

        System.out.println(" "+median);
    }
    public static int[] Merge(int [] strs1, int [] strs2){
        int [] both = new int[strs1.length + strs2.length];
        System.arraycopy(strs1, 0, both,0, strs1.length);//strs1 存入 strs3
        System.arraycopy(strs2, 0, both, strs1.length, strs2.length);//strs2 存入 strs3
        return both;
    }
}
