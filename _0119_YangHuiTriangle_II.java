package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//示例 1:
//输入: rowIndex = 3
//输出: [1,3,3,1]
//示例 2:
//输入: rowIndex = 0
//输出: [1]
//示例 3:
//输入: rowIndex = 1
//输出: [1,1]
public class _0119_YangHuiTriangle_II {
    public static void main(String[] args) {
        int rowIndex = 1;
        System.out.println(Method(rowIndex,new ArrayList<>()));
    }

    public static List<Integer> Method(int rowIndex, List<Integer> list) {
        int len = rowIndex+1;
        int [][]nums = new int[len][len];
        for (int i = 0; i < len; i++) {//杨辉三角的首位和末尾都为1
            nums[i][0] = 1;//首
            nums[i][i] = 1;//尾
        }
        list.add(1);//list存入首位1
        if (rowIndex == 0){//行数为0时，直接返回list
            return list;
        }else if(rowIndex == 1){//行数为一，有两个1，返回list
            list.add(1);
            return list;
        }
        for (int i = 2; i < len; i++) {
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i-1][j] + nums[i-1][j-1];//递推公式
                if (i == rowIndex){//当遍历到指定行数时，开始逐个添加元素
                    list.add(nums[i][j]);
                }
            }
        }
        list.add(1);//末尾1
        return list;
    }
}
