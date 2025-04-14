package LeetCode;

//写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。
//示例 1：
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//输出：true
//示例 2：
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//输出：false
public class _0245_1_SearchFor2DMatrix_II {
    public static void main(String[] args) {
        int [][]matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(Method(matrix,target));
    }
    public static boolean Method(int [][]matrix,int target){//大于target，就横着往前一个单位，小于target，就竖着往下一个单位
        int i = 0, j = matrix[i].length-1;
        while(i < matrix.length && j >=0){
            if (matrix[i][j] == target){
                return true;
            }
            if (matrix[i][j]<target){//小于target，就竖着往下一个单位
                i++;
            }else j--;////大于target，就横着往前一个单位
        }
        return false;
    }
}
