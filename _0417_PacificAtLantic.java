package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
//岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
//返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
//示例 1：
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//示例 2：
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
public class _0417_PacificAtLantic {
    public static void main(String[] args) {
        int [][]heights ={{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(Method(heights));
    }
    public static List<List<Integer>> Method(int [][] height){
        int n = height.length,m = height[0].length;
        List<List<Integer>> list = new ArrayList<>();
        boolean [][]tai = new boolean[n][m];
        boolean [][]da = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(height,tai,i,0);
            dfs(height,da,i,m-1);
        }
        for (int i = 1; i < m-1; i++) {
            dfs(height,tai,0,i);
            dfs(height,da,n-1,i);
        }
        for (int i = 0;i < n;i++){
            for (int j = 0; j < m; j++) {
                if(tai[i][j] && da[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public static void dfs(int [][] height,boolean [][] search ,int i,int j){
        int n = height.length,m = height[0].length;
        if(search[i][j]){
            return;
        }
        search[i][j] = true;
        if(j-1 >= 0 && height[i][j-1]>=height[i][j]) dfs(height,search,i,j-1);
        if(j+1 <= m-1 && height[i][j+1]>=height[i][j]) dfs(height,search,i,j+1);
        if(i-1 >= 0 && height[i-1][j]>=height[i][j])dfs(height,search,i-1,j);
        if(i+1 <= n-1 && height[i+1][j]>=height[i][j]) dfs(height,search,i+1,j);
    }
}
