package LeetCode;

public class _0931_minFallingPathSum {
    public static void main(String[] args) {
        int [][]matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(Method(matrix));
    }
    public static int Method(int [][]matrix){
        int n = matrix.length,m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }else if (j == m-1){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }else {
                    matrix [i][j]+= Math.min(Math.min(matrix[i-1][j],matrix[i-1][j-1]),matrix[i-1][j+1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : matrix[n - 1]) {
            ans = Math.min(i,ans);
        }
        return ans;
    }
}
