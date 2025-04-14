package LeetCode;
//给你一个满足下述两条属性的 m x n 整数矩阵：
//每行中的整数从左到右按非严格递增顺序排列。
//每行的第一个整数大于前一行的最后一个整数。
//给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
//示例 1：
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//示例 2：
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
public class _074_SearchFor_2D_Matrices {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5}};
        int target = 3;
        System.out.println(Method(matrix,target));
    }

    public static boolean Method(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {//先判断target在那个区间
            if (matrix[i].length == 1){//一行只有一个，只需判断这一个是否为target
                if (target == matrix[i][0]){
                    return true;
                }else if(i == matrix.length-1){//当判断到最后一行就退出循环
                    break;
                }else {
                    continue;
                }
            }
            if (target == matrix[i][0] || target == matrix[i][matrix[i].length - 1]) {//每一行有多个，判断界限是否为target
                return true;
            } else if (target > matrix[i][0] && target < matrix[i][matrix[i].length - 1]) {//target处于某区间，用二分法查找
                int left = 0;
                int right = matrix[i].length - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}

