package LeetCode;

import ShiYan6_2.Method;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//问总共有多少条不同的路径？
//示例 1：
//输入：m = 3, n = 7
//输出：28
//示例 2：
//输入：m = 3, n = 2
//输出：3
//示例 3：
//输入：m = 7, n = 3
//输出：28
//示例 4：
//输入：m = 3, n = 3
//输出：6
public class _062_DifferentPaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(Method(m,n));
    }
    public static int Method(int m,int n){
        int [][]f = new int[m][n];
        for (int i = 0; i < m; i++) {//列为0，每个方格只有一种到达方法
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {//行为0，每个方格只有一种到达方法
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {//在行不为0，列不为0时，到达该方格路径 = 该方格上边的路径和 + 该方格左边的路径和
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];//最后一个值即为不同路径的总和
    }
}
