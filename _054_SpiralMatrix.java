package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
public class _054_SpiralMatrix {
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3,4}, { 5, 6,7,8}, {9,10,11,12}};
        System.out.println(Method(matrix));
    }
    public static List<Integer> Method(int [][] matrix){
        int row = 0,col = 0;
        int n = matrix.length,m = matrix[0].length;
        boolean [][]visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        while (true){
            while (col < m && !visited[row][col]  ) {//行向右
                list.add(matrix[row][col]);
                visited[row][col] =true;
                col++;
            }
            if (list.size() == n*m){
                return list;
            }
            col--;
            row++;
            while ( row < n && !visited[row][col]) {//列向下
                list.add(matrix[row][col]);
                visited[row][col] =true;
                row++;
            }
            if (list.size() == n*m){
                return list;
            }
            row--;
            col--;
            while ( col >= 0 && !visited[row][col]) {//行向左
                list.add(matrix[row][col]);
                visited[row][col] =true;
                col--;
            }
            if (list.size() == n*m){
                return list;
            }
            col++;
            row--;
            while (row>=0 && !visited[row][col]) {//列向上
                list.add(matrix[row][col]);
                visited[row][col] =true;
                row--;
            }
            row++;
            col++;
        }
    }
}
