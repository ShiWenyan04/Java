package LeetCode;

public class _0790_numTilings {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int [] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n+1; i++) {
            f[i] = 2*f[i-1] + f[i-3];
        }
        return f[n];
    }
}
