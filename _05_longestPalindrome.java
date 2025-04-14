package LeetCode;

public class _05_longestPalindrome {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][]f = new boolean[n][n];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        char[]ch = s.toCharArray();
        // 先枚举子串长度
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = l + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if(j >= n){
                    break;
                }

                if(ch [i] != ch[j]){
                    f[i][j] = false;
                }else {
                    if(j-i <3){
                        f[i][j] =true;
                    }else {
                        f[i][j] =f[i+1][j-1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if(f[i][j]&&j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
