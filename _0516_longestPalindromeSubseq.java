package LeetCode;
//示例 1：
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
//示例 2：
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
public class _0516_longestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        int n = s.length();
        char[]ch = s.toCharArray();
        int [][]f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = n-1; i>=0  ; i--) {
            for (int j = i+1; j < n; j++) {
                if(ch[i] == ch[j]){
                    f[i][j] = f[i+1][j-1]+2;
                }else {
                    f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
                }
            }
        }
        return f[0][n-1];
    }
}
