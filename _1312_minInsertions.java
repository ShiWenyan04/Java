package LeetCode;

public class _1312_minInsertions {
    public static void main(String[] args) {
        String s = "zzazz";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        int n = s.length();
        int [][] f = new int[n][n];
        char[] ch = s.toCharArray();
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                f[i][j] = Math.min(f[i][j-1],f[i+1][j])+1;
                if(ch[i] == ch [j]){
                    f[i][j] = Math.min(f[i][j],f[i+1][j-1]);
                }
            }
        }
        return f[0][n-1];
    }
}
