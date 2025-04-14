package LeetCode;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//示例 2：
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
public class _048_RotateTheImage {
    public static void main(String[] args) {
        int[][]martrix = {{1,2,3}, {4,5,6}, {7,8,9} };
        System.out.println(Method(martrix));
    }
    public static int[][] Method(int[][] martrix){
        int n = martrix.length;
        int m = martrix[0].length;
        for (int i = 0; i < n/2; i++) {//上下交换
            int []temp ;
            temp = martrix[i];
            martrix[i] = martrix[n-i-1];
            martrix[n-1-i] = temp;
        }
        for (int i = 0; i < n; i++) {//每一行遍历
            for (int j = 0; j < i; j++) {//对角线交换,由于矩阵对称，故只需交换一次，二维坐标小于一维坐标即可
                int temp1;
                temp1 = martrix[i][j];
                martrix[i][j] = martrix[j][i];
                martrix[j][i] = temp1;
            }
        }
        return martrix;
    }
}
