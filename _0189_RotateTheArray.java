package LeetCode;
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//示例 1:
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
public class _0189_RotateTheArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public  static  int[] Method(int[] nums, int k){//将需要移动的数字，开头和结尾的群组均复制，然后再重新黏贴到nums即可
        int n = nums.length;;
        k = k % n;
        int len1 = n-k;
        int len2 = k;
        int [] nums1 = new int[len1];
        int [] nums2 = new int[len2];
        System.arraycopy(nums,0,nums1,0,len1);//复制前一段需要移动的
        System.arraycopy(nums,len1,nums2,0,len2);//复制后一段需要移动的
        System.arraycopy(nums1,0,nums,k,len1);//重新粘贴
        System.arraycopy(nums2,0,nums,0,len2);//重新粘贴
        return nums;
    }
}
