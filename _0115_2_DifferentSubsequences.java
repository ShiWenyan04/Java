package LeetCode;

public class _0115_2_DifferentSubsequences {
    public static void main(String[] args) {
        String s ="babgbag", t = "bag";
        System.out.println(Method1(s,t));
        System.out.println(Method(s,t));
    }
    public static int Method1(String s, String t) {
        int sl = s.length(), tl = t.length();//st的长度
        char [] schar = s.toCharArray();//s化为字符数组
        char [] tchar = t.toCharArray();//t化为字符数组
        int [] dp = new int[tl+1];//建立新的数组，长度为t+1
        dp[0] = 1;
        for(int i = 1; i <= sl; i++){
            for(int j = tl; j > 0; j--){//t循环
                if(schar[i - 1] == tchar[j - 1] ) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[tl];
    }

    public static int Method(String s,String t){
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char ch1 = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char ch2 = t.charAt(j);
                if(ch1 == ch2){
                    f[i][j] = f[i+1][j+1]+f[i+1][j];
                }else {
                    f[i][j] = f[i+1][j];
                }
            }
        }
        return f[0][0];
    }
}
