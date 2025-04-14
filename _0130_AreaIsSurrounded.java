package LeetCode;

import java.util.Arrays;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
//连接：一个单元格与水平或垂直方向上相邻的单元格连接。
//区域：连接所有 'O' 的单元格来形成一个区域。
//围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
//通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
//示例 1：
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
public class _0130_AreaIsSurrounded {
    public static void main(String[] args) {
        String[][] board = {{"X", "X", "X", "X"}, {"X", "O", "O", "X"}, {"X", "X", "O", "X"}, {"X", "O", "X", "X"}};
        System.out.println(Arrays.deepToString(Method(board)));
    }
    public static String[][] Method(String[][] board){
        int n = board.length;
        int m = board[0].length;

//        处理矩阵的第一列和第n列，从这两列出发，寻找没有被包裹的面积
        for (int i = 0; i < n; i++) {
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
//        处理矩阵的第一行和第n行，从这两行出发，寻找没有被包裹的面积，由于四个顶角已经被上一个循环处理过，所以可以不用再访问
        for (int i = 1; i < m-1; i++) {
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
//        遍历矩阵，将标记过的位置换成O,没有被标记过的O换成X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j].equals("A") ){
                    board[i][j] = "O";
                } else if (board[i][j].equals("O")) {
                    board[i][j] = "X";
                }
            }
        }
        return board;
    }
//    递归寻找没有被包裹的面积，
    public static void dfs(String[][] board ,int i,int j){
        int n = board.length;
        int m = board[0].length;
        if(i == n || j == m || i == -1 || j == -1 || (board[i][j].equals("X"))){
            return ;
        }
        board[i][j] = "A";
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
