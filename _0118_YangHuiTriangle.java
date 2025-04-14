package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//示例 1:
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//示例 2:
//输入: numRows = 1
//输出: [[1]]
public class _0118_YangHuiTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(Method(new ArrayList<>(),numRows));
    }
    public static List<List<Integer>> Method(List<Integer> com, int numRows){
        List<List<Integer>> list = new ArrayList<>();
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {//杨辉三角的首位和末尾都为1
            nums[i][0] = 1;//首
            nums[i][i] = 1;//尾
        }
        com.add(1);//第一行只有1
        list.add(new ArrayList<>(com));//第一行添加到list
        com.remove(0);//删除
        for (int i = 1; i < numRows; i++) {
            com.add(nums[i][0]);//每一行的首位1
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i-1][j]+nums[i-1][j-1];
                com.add(nums[i][j]);
            }
            com.add(1);//末尾1
            list.add(new ArrayList<>(com));//com添加完毕，将com加到list中，形成二维数组
            com.removeAll(com);//删除,便于更新
        }
        return list;
    }
}
