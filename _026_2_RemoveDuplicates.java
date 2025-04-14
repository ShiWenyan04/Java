package LeetCode;
//给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
//考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
//返回 k 。
//判题标准:
//系统会用下面的代码来测试你的题解:
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//int k = removeDuplicates(nums); // 调用
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//如果所有断言都通过，那么您的题解将被 通过。

//示例 1：
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

import java.util.ArrayList;

//示例 2：
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
public class _026_2_RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(" "+Method2(Method1(nums)));
    }
    public static ArrayList<String> Method1(int [] nums){
        ArrayList<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(String.valueOf(i));
        }
        return list;
    }
    public static int Method2(ArrayList<String> list ){
        int len = list.size();
        for (int i = 1; i < len; i++) {
            if (list.get(i-1).equals(list.get(i))){
                list.remove(i-1);//删除相同值
                len--;//list长度减一个单位
                i --;//索引回到第一个
            }
        }
        Object [] nums = list.toArray();//转化成数组
        for (   Object i:nums) {//循环输出
            System.out.print(i);
        }
        return list.toArray().length;
    }
}
