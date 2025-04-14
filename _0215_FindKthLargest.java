package LeetCode;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//示例 1:
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//示例 2:
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
public class _0215_FindKthLargest {
    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(Method(nums,0,nums.length-1,nums.length-k));//（因为数组索引是从0开始的，所以第k大的元素在排序后的数组中位于索引nums.length-k）。
    }
    public static int Method(int [] nums, int i,int j,int k){
        int start = i-1;
        int end = j+1;
        int base = nums[i];
        if(i == j ){//如果起始索引和结束索引相等，说明数组中只有一个元素。
            return nums[k];
        }
        while(start < end){
            do start ++;while (nums[start] < base);//从左向右扫描，直到找到一个大于或等于基准元素的元素。
            do end --;while (nums[end] > base);//从右向左扫描，直到找到一个小于或等于基准元素的元素。
            if(start<end){//如果start小于end，说明找到了一对可以交换的元素。
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        if(k <= end){//如果目标索引k小于或等于当前的end索引，说明第k大的元素在左侧。
            return Method(nums,i,end,k);//否则，第k大的元素在右侧，递归调用Method方法，搜索右侧的子数组。
        }else return Method(nums,end+1,j,k);
    }
}
