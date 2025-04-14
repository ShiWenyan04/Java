package LeetCode;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//网格中的障碍物和空位置分别用 1 和 0 来表示。

//示例 1：
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//示例 2：
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
public class _063_DifferentPathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Method(obstacleGrid));
    }
    public static int Method(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]f = new int[m][n];
        for (int i = 0; i < m; i++) {//列为0，每个方格只有一种到达方法,故每个格子的路径和都为1
            if (obstacleGrid[i][0] != 1){
                f[i][0] = 1;
            }else {//但是在遇到障碍的时候，障碍以及以后的格子都不能抵达，故为0
                for (int k = i; k < m ; k++) {
                    f[k][0] = 0;
                }
                break;
            }
        }
        for (int j = 0; j < n; j++) {//行为0，每个方格只有一种到达方法,故每个格子的路径和都为1
            if (obstacleGrid[0][j] != 1){
                f[0][j] = 1;
            }else {//但是在遇到障碍的时候，障碍以及以后的格子都不能抵达，故为0
                for (int k = j; k < n ; k++) {
                    f[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < m; i++) {//行、列均不为0时，到达当前方格路径 = 该方格上边的路径和 + 该方格左边的路径和
            for (int j = 1; j < n ; j++) {
                if (obstacleGrid[i][j] == 1){//倘若遇见障碍，则障碍这一个格子路径为0
                    f[i][j] = 0;
                }else{
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
