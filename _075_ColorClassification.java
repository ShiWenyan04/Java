package LeetCode;
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//必须在不使用库内置的 sort 函数的情况下解决这个问题。
//示例 1：
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//示例 2：
//输入：nums = [2,0,1]
//输出：[0,1,2]
public class _075_ColorClassification {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(Method(nums));
    }
    public static int[] Method (int[] nums){
        int n = nums.length;
        int j = 0;//可理解为第二个数组的索引，而排序后的数字需要一次存入这个数组（其实就是将正确次序的数字从头开始依次存放到原来的数组，j是从头开始的索引）
        int k = 0;//需要判断是否为1的数字的索引
        for (int i = 0; i < n; i++) {//将0全部移位到开头
            if (nums[i] == 0){//需要判断是否为0的数字的索引
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                k = j;//全部的0移至开头后，下一个数字需要判断的索引
            }
        }
        for (; k < n; k++) {//将全部的1移至0的后面
            if (nums[k] == 1){//需要判断是否为1的数字的索引
                int temp1 = nums[k];
                nums[k] = nums[j];
                nums[j] = temp1;
                j++;
            }
        }
        return nums;
    }
}
