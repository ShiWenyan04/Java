package LeetCode;

import java.util.Arrays;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//示例 1：
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
public class _059_SpiralMatrix_II {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.deepToString(Method(n)));
    }
    public static int [][] Method(int n){
        if (n == 1){
            return new int[][]{{1}};
        }
         boolean [][]visited = new boolean[n][n];
         int [][]num = new int[n][n];
         int i = 1;
         int row = 0, col = 0;
         while (i <= n*n){
//             行向右
             while (col<n && !visited[row][col] && i<=n*n){
                 num[row][col] = i;
                 visited[row][col] = true;
                 col++;
                 i++;
             }
             if (i > n*n){
                 break;
             }
//             列向下
             col--;
             row++;
             while(row < n && !visited[row][col]&& i<=n*n){
                 num[row][col] = i;
                 visited[row][col] = true;
                 row ++;
                 i++;
             }
             if (i > n*n){
                 break;
             }
//             行向左
             row--;
             col--;
             while(col >= 0 && !visited[row][col]&& i<=n*n){
                 num[row][col] = i;
                 visited[row][col] = true;
                 col--;
                 i++;
             }
             if (i > n*n){
                 break;
             }
//             列向上
             col++;
             row--;
             while(row >= 0 && !visited[row][col]&& i<=n*n){
                 num[row][col] = i;
                 visited[row][col] = true;
                 row --;
                 i++;
             }
             row++;
             col++;
         }
         return num;
    }
}
