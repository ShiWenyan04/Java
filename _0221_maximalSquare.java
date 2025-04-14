package LeetCode;

public class _0221_maximalSquare {
    public static void main(String[] args) {
        String [][]matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        System.out.println(Method(matrix));
    }
    public static int Method(String[][] matrix){
        int ans = 0;
        int n = matrix.length,m = matrix[0].length;
        int [][]f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] .equals("1")){
                    if (i == 0 || j==0){
                        f[i][j] = 1;
                    }else {
                        f[i][j] = Math.min(f[i][j-1],Math.min(f[i-1][j],f[i-1][j-1]))+1;
                    }
                    ans = Math.max(f[i][j],ans);
                }
            }
        }
        return ans*ans;
    }
}
