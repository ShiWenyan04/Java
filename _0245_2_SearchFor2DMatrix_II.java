package LeetCode;
////写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
////每行的元素从左到右升序排列。
////每列的元素从上到下升序排列。
////示例 1：
////输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
////输出：true
////示例 2：
////输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
////输出：false
public class _0245_2_SearchFor2DMatrix_II {
    public static void main(String[] args) {
        int [][]matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(Method(matrix,target));
    }
    public static boolean Method(int [][]matrix,int target){//每一行用二分法
        int len1 = matrix.length,len2 = matrix[0].length;
        for (int i = 0; i < len1; i++) {//每一行遍历
            if (matrix[i][len2-1] > target && matrix[i][0] < target){//判断这一行界限
                int left = 0;
                int right = len2-1;
                while (left<right){//二分法
                    int mid = (right + left)/2;
                    if (matrix[i][mid] == target){
                        return true;
                    } else if (matrix[i][mid] < target) {
                        left = mid+1;
                    }else right = mid;
                }
            } else if (matrix[i][len2-1] == target || matrix[i][0] == target) {//边界等于target
                return true;
            }else continue;
        }
        return false;
    }
}
