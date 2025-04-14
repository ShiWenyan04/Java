package LeetCode;

import ShiYan6_2.Method;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//输出：4
//示例 2：
public class _0221_MaximumSquare {
    public static void main(String[] args) {
        String [][]matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        System.out.println(Method(matrix));
    }
    public static int Method(String [][] m){
        //首先要清楚dp【i】[j]代表的是一个正方形的右下角位置
        // 而当前位置的dp值，应该是在其上方、左方、左上方都不为0的情况下才能构成三角形，然后取他们之间的最小值+1
        int maxSide = 0;
        if (m == null || m.length == 0 || m[0].length == 0) {
            return maxSide;
        }
        int [][]dp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j].equals("1")){//在当前位置是1的情况下，如果是第一行和第一列，只能为1，因为无法构成更大的正方形
                    if(i == 0 || j == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1] , dp[i-1][j-1]))+1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);//获得当前得到最大值的边
                }
            }
        }
        return maxSide*maxSide;
    }
}
