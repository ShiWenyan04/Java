package LeetCode;
//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
//你所设计的解决方案必须只使用常量级的额外空间。
//示例 1：
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
//示例 2：
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//示例 3：
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
public class _0167_SumOfTwoNumbers_II_EnterAnOrderedArray {//双指针
    public static void main(String[] args) {
        int []numbers = {3,24,50,79,88,150,345} ;
        int target = 200;
        System.out.println(Method(numbers,target));
    }
    public static int[] Method(int[] numbers,int target) {//首尾依次相加，因为是从小到大排序，所以，倘若和小了，就low加一，倘若大了，就high-1
        int low = 0;
        int high= numbers.length-1;
        while(low < high){
            int sum = numbers[low]+numbers[high];
            if (sum == target){//相等
                return new int[]{low+1,high+1};
            }else if (sum < target){//小于
                low++;
            }else {//大于
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
