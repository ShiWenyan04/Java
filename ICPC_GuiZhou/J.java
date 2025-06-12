package ICPC_GuiZhou;

import java.util.Scanner;

public class J {
    static Scanner sc = new Scanner(System.in);
    static int n,m,q;

    //        存放烽火台,为8,驿车为1,行和列某一位置是否有烽火台
    static int [][] grid ;
    static boolean [] row;
    static boolean [] col;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        grid = new int[n][m];
        row = new boolean[n];
        col = new boolean[m];

        while(q>0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            grid[i][j] = 8;
            q--;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                如果不是烽火台，可以先考虑放一个驿车
                if(grid[i][j]!=8) {
                    dfs(i,j);
                }
            }
        }

    }
    public static void dfs(int x,int y) {
        if(grid[x][y]==0) {
            grid[x][y]=1;
        }else {
            return ;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {

            }
        }
    }
}
