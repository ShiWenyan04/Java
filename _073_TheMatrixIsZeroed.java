package LeetCode;
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//示例 1：
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//示例 2：
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
public class _073_TheMatrixIsZeroed {
    public static void main(String[] args) {
        int [][]matrix = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(Method(matrix));
    }
    public static int[][] Method(int[][] matrix){
        boolean [][]visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {//遍历每一个元素，如果有0，就为true，打标记
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length ; i++) {//遍历数组，如果当前索引被打过标记，则当前索引所对应的行和列都为0
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]){
                    for(int k = 0; k < matrix.length; k++){//列为0
                         matrix[k][j] = 0;
                    }
                    for (int k = 0; k < matrix[i].length; k++) {//行为0
                         matrix[i][k] = 0;
                    }
                }
            }
        }
        return matrix;
    }
}
