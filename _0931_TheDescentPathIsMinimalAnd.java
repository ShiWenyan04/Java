package LeetCode;
//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
//示例 1：
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
//示例 2：
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
public class _0931_TheDescentPathIsMinimalAnd {
    public static void main(String[] args) {
        int [][]matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(Method(matrix));
    }
    public static int Method(int [][] matrix){
        for (int i = 1; i <matrix.length; i++) {//从第二行开始继续算到达每个位置的最小值
            for (int j = 0; j < matrix[i].length; j++) {//从每一行的第一个开始计算
                if (j == 0){//边界问题
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }else if (j == matrix[0].length-1){//边界问题
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }else {//正常情况
                    int temp = Math.min(matrix[i-1][j],matrix[i-1][j-1]);//三个数先比较前两个，再比较剩下的一个，得到最小值
                    matrix[i][j] = matrix[i][j] + Math.min(temp,matrix[i-1][j+1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : matrix[matrix.length-1]){//遍历得到最后一行的最小值，就是答案
            ans = Math.min(ans ,i);
        }
        return ans;
    }
}
