package LeetCode;

import ShiYan6_2.Method;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
// 示例 1：
//输入：matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
public class _1277_StatisticalMatrix {
    public static void main(String[] args) {
        int [][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(Method(matrix));
    }
    public static int Method(int [][]matrix){
        int ans = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int [][]dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1] , dp[i-1][j-1]))+1;
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}

