package LeetCode;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//此外，你可以假设该网格的四条边均被水包围。
//示例 1：
//输入：grid = [["1","1","1","1","0"], ["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
//输出：1
//示例 2：
//输入：grid = [ ["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
//输出：3
public class _0200_NumberOfIslands {//
    public static void main(String[] args) {
        String [][] grid = {{"1", "1", "1", "1", "0"}, {"1", "1", "0", "1", "0"}, {"1", "1", "0", "0", "0"}, {"0", "0", "0", "0", "0"}};
        System.out.println(Method(grid));
    }
    public static int Method(String [][]grid){
        int hang = grid.length;
        int lie = grid[0].length;
        int ans = 0;
        for (int i = 0; i < hang; i++) {//遍历二维数组，一旦遇见1.就进入dfs递归，深度优先搜索，直到遇见0或者边界
            for (int j = 0; j < lie; j++){
                if(grid[i][j].equals("1") ){
                   ans++;//遇见一片陆地，ans+1，进入递归能够确定是属于同一块陆地，ans记录的是陆地的数目
                   dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public static void dfs(String [][]grid,int i,int j){
        int hang = grid.length;
        int lie = grid[0].length;
        if(i<0 || i == hang || j < 0 || j ==lie || grid[i][j] .equals("0")){
            return;
        }
        grid[i][j] = "0";//对于已经记录过的陆地，将他标记为水，这样在主函数中，就不会对已经标记过的陆地再进行一次递归
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
