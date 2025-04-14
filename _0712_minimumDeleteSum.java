package LeetCode;

public class _0712_minimumDeleteSum {
    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(Method(s1,s2));
     }
    public static int Method(String s1,String s2){
        int n = s1.length(),m = s2.length();
        int [][]f = new int[n+1][m+1];//表示s1的前i个字符与s2的前j个字符相等时需要删除字符的ASCII值的最小和
//        当 i=j=0 时，两个字符串均为空，两个空字符串相同，不需要删除任何字符，因此有 dp[0][0]=0；
        for (int i = 1; i < n+1; i++) {//当 i=0 且 j>0 时
            f[i][0] = f[i-1][0]+s1.codePointAt(i-1);
        }
        for (int j = 1; j < m+1; j++) {//当 j=0 且 i>0 时
            f[0][j] = f[0][j -1]+s2.codePointAt(j-1);
        }
//        当 i>0 且 j>0 时
        for (int i = 1; i < n+1; i++) {
            int value1 = s1.codePointAt(i-1);
            for (int j = 1; j < m+1; j++) {
                int value2 = s2.codePointAt(j-1);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = Math.min(f[i-1][j]+value1,f[i][j-1]+value2);
                }
            }
        }
        return f[n][m];
    }
}
