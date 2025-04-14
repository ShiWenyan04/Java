package LeetCode;
//给你一个大小为 m x n 的二进制矩阵 grid 。
//岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//岛屿的面积是岛上值为 1 的单元格的数目。
//计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//示例 1：
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//示例 2：
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
public class _0695_TheLargestAreaOfTheIsland {
    public static void main(String[] args) {
        int [][]grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(Method(grid));
    }
    public static int Method(int [][]num){
        int n = num.length;
        int m = num[0].length;
        int ans = 0;
        int []preans = new int[1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(num[i][j] == 1){
                    dfs(num,preans,i,j);
                    ans = Math.max(ans,preans[0]);
                    preans[0] = 0;
                }
            }
        }
        return ans;
    }
    public static void dfs(int [][] num,int [] preans,int i,int j){
        int n = num.length;
        int m = num[0].length;
        if( i < 0 || j < 0 || i == n || j == m || num[i][j] == 0 ){
            return ;
        }
        num[i][j] = 0;
        preans[0]++;
        dfs(num,preans,i+1,j);
        dfs(num,preans,i-1,j);
        dfs(num,preans,i,j+1);
        dfs(num,preans,i,j-1);
    }
}
