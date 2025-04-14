package LeetCode;

public class _1143_longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(Method(text1,text2));
    }
    public static int Method(String text1,String text2){
        int m = text1.length();
        int n = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int [][]f = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s1[i-1] == s2[j-1]){
                    f[i][j] = f[i-1][j-1]+1;
                }else {
                    f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                }
            }
        }
        return f[m][n];
    }
}
