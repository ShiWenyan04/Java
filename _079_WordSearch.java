package LeetCode;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//示例 1：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//输出：true
//示例 2：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//输出：true
//示例 3：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//输出：false
public class _079_WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(Method1(board,word));
    }

    public static boolean Method1(char[][] board, String word) {
        int m = board.length;//行
        int n = board[0].length;//列
        boolean [][]used = new boolean[m][n];//判断元素是否使用过
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 开头开始匹配
                if (board[i][j]==word.charAt(0)) {
                    if(Method2(board,word,m,n,i,j,used,0))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean Method2(char[][] board, String word, int m,int n,int i, int j, boolean [][]used, int index){
        if (board[i][j] == word.charAt(index)) {//数组中元素是否与字母相等
            used[i][j] = true;
            if (
                    (index == word.length()-1)//倘若相等的字母是字符串中最后一个，结束
                    || (i > 0 && !used[i-1][j]) && Method2(board,word,m,n,i-1,j,used,index+1)//上，规定界限，并且这个元素必须为未使用过的
                    || (i < m-1 && !used[i +1][j]) && Method2(board,word,m,n,i+1,j,used,index+1)//下
                    || (j > 0 && !used[i][j-1]) && Method2(board,word,m,n,i,j-1,used,index+1)//左
                    || (j < n-1 && !used[i][j+1]) && Method2(board,word,m,n,i,j+1,used,index+1)//右
            )return true;
            used[i][j] = false;
        }
        return false;
    }
}