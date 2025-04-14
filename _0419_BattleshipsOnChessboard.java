package LeetCode;
//给你一个大小为 m x n 的矩阵 board 表示棋盘，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在棋盘 board 上放置的 舰队 的数量。
//舰队 只能水平或者垂直放置在 board 上。换句话说，舰队只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状放置，其中 k 可以是任意大小。两个舰队之间至少有一个水平或垂直的空格分隔 （即没有相邻的舰队）。
//示例 1：
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
//示例 2：
//输入：board = [["."]]
//输出：0
public class _0419_BattleshipsOnChessboard {
    public static void main(String[] args) {
        String [][]board = {{"X", ".", ".", "X"}, {".", ".", ".", "X"}, {".", ".", ".", "X"}};
        System.out.println(Method(board));
    }
    public static int Method(String [][]board){
        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if(board[i][j].equals("X")){
                    ans ++;
                    dfs(board,i,j);
                }
            }
        }
        return ans;
    }
    public static void dfs(String [][]board ,int i,int j){
        int n = board.length;
        int m = board[0].length;
        if(i <0 || j < 0||i==n ||j==m || board[i][j].equals(".")){
            return;
        }
        board[i][j] = ".";
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
