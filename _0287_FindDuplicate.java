package LeetCode;

import java.util.Arrays;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
//假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
//你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
//
//
public class _0287_FindDuplicate {
    public static void main(String[] args) {
        int []strs1 = {1,3,4,2,2};
        int []strs2 = {3,1,3,4,2};
        int []strs3 = {3,3,3,3,3};
        System.out.println(findDuplicate(strs1));
        System.out.println(findDuplicate(strs2));
        System.out.println(findDuplicate(strs3));
    }
    static int findDuplicate(int [] strs){
        int aim = 0;
        Arrays.sort(strs);//排序从小到大
        for (int i = 0; i < strs.length/2; i++) {
            if (strs[i] == strs[i+1]) {//判断相等
                aim = strs[i];
                break;
            } else if (strs[strs.length-1-i] == strs[strs.length-2-i]) {
                aim = strs[strs.length-1-i];
            }
        }
        return aim;
    }
}
