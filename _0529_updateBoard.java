package LeetCode;

import java.util.Arrays;

//扫雷
public class _0529_updateBoard {

    public static void main(String[] args) {
        char [][]board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
        int []click = {3, 0};
        Method(board,click);
        System.out.println(Arrays.deepToString(board));
    }
    public static void Method(char [][]board,int [] click){//判断点下去的那一瞬间
        int x = click[0],y = click[1];
        if(board[x][y] == 'M'){//是炸弹直接变为B返回
            board[x][y] = 'X';
        }else {
            dfs(board,x,y);//不是炸弹进行递归
        }
    }
    static int []dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int []dy = {1, 0, -1, 0, 1, -1, 1, -1};//分别对应着下，右，上，左等八个方位
    public static void dfs(char [][]board,int x,int y){
        int count = 0;//炸弹的个数
        for (int k = 0; k < 8; k++) {//遍历当前按键位置的八个方位，如果有炸弹，就计数
            int tx = dx[k]+x,ty = dy[k]+y;
            if(tx < 0 || ty < 0 || tx == board.length || ty == board[0].length){
                continue;
            }else if(board[tx][ty] == 'M'){
                count++;
            }
        }
        if(count > 0){//炸弹个数超过0，那么当前的位置就应该标记为该位置的八个方位共有炸弹的个数
            board[x][y] = (char)(count+'0');
        }else {//如果没有炸弹
            board[x][y] = 'B';//当前位置由E变为B
            for (int k = 0; k < 8; k++) {//然后遍历当前位置的八个方位，只要不超过界限，并且八个方位的标记为E，不是数字也不是B，那么就继续从当前位置进行递归，判别当前位置的八个方位
                int tx = dx[k] + x;
                int ty = dy[k] + y;
                if(tx >= 0 && ty >= 0&& tx < board.length && ty < board[0].length && board[tx][ty] == 'E'){
                    dfs(board,tx,ty);
                }
            }
        }
    }
}
