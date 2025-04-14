package LeetCode;

public class _01_05_oneEditAway {
    public static void main(String[] args) {
        String first = "pale" ,second = "ple";
        System.out.println(Method(first,second));
    }
    public static boolean Method(String fir,String sec){
        int m = fir.length();
        int n = sec.length();
        if(Math.abs(m-n) > 1){
            return false;
        }else if (sec.equals(fir)){
            return  true;
        }
        int i = 0;
        for (; i < m && i < n; i++) {
            if(fir.charAt(i) != sec.charAt(i)){
                break;
            }
        }
        int d = 1;
        for (; d <= n && d <= m; d++) {
            if(fir.charAt(m-d) != sec.charAt(n-d)){
                break;
            }
        }
        return i+d-1 == (n == m ? m-1:Math.min(n,m)) ;
    }
}
