package LeetCode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
//若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
//若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
//示例 1：
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
//示例 2：
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
//示例 3：
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
public class _0153_RotateTheSortArray {
    public static void main(String[] args) {
        int []nums = {3,4,5,1,2};
        System.out.println(Method(nums));
    }
    public static int Method(int []nums){
        if (nums.length == 1){//个数为一时，直接返回数组元素
            return nums[0];
        }
        int i = 0;
        for (; i < nums.length-1; i++) {//遍历寻找降序的值，然后返回当前索引之后所对的元素
            if (nums[i] > nums[i+1]){
                break;
            }
            if (i == nums.length-2){//倘若遍历到尽头都没有，说明是完全升序的数组，直接返回第一个
                i = -1;
                break;
            }
        }
        return nums[i+1];
    }
}
