package LeetCode;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
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
public class _062_uniquePaths {
    public static void main(String[] args) {
        int m = 7,n = 3;
        System.out.println(Method(m,n));
    }
    public static int Method(int m ,int n){
        int [][]f = new int[m][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j-1]+f[i-1][j];
            }
        }
        return f[m-1][n-1];
    }
}
