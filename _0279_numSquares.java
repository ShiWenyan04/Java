package LeetCode;

public class _0279_numSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int []f = new int[n+1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(min,f[i-j*j]+1);
            }
            f[i] = min;
        }
        return f[n];
    }
}
