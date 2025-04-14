package LeetCode;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//说明：每次只能向下或者向右移动一步。

//示例 1：
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。

//示例 2：
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
public class _064_TheSumOfTheMinimumPaths {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Method(grid));
    }

    public static int Method(int[][] grid) {
        int len1 = grid.length,len2 = grid[0].length;
        int i, j;
        for (j = 1; j < len2; j++) {//在第一列时，目标只能往下
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }
        for (i = 1; i < len1; i++) {//在第一行时，目标只能往右
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (i = 1; i < len1; i++) {//在非第一行和非第一列的时候，就要看此时定位的上方和左方的最小，然后在加上此时定位的值
            for (j = 1; j < len2; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[len1-1][len2-1];
    }
}