package LeetCode;

import java.util.Arrays;

public class _0289_gameOfLife {
    public static void main(String[] args) {
        int [][]board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(Method(board)));
    }
    public static int[][] Method(int [][]b){
        int m = b.length,n = b[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(b[i][j] % 10 == 1){
                    affect(b,i,j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j<n;j++){
                calculate(b,i,j);
            }
        }
        return b;
    }
    public static void affect(int[][] b,int x,int y){
        int m = b.length,n = b[0].length;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if(i < 0 || i >= m || j <0 || j>=n || i==x&&j==y){
                    continue;
                }
                b[i][j]+=10;
            }
        }
    }
    public static void calculate(int [][]b,int i,int j){
        if(b[i][j] / 10 == 3){
            b[i][j] = 1;
        } else if (b[i][j] / 10 == 2 && b[i][j]%10 == 1) {
            b[i][j] = 1;
        }else b[i][j] = 0;
    }
}
