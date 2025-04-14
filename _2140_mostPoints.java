package LeetCode;


public class _2140_mostPoints {
    public static void main(String[] args) {
        int [][]questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(Method(questions));
    }
    public static long Method(int [][]questions){
        int n = questions.length;
        long [] f = new long[n+1];
        for (int i = n-1; i >= 0; i--) {
            f[i] = Math.max(f[i+1],f[Math.min(n,i+questions[i][1]+1)]+questions[i][0]);
        }
        return f[0];
    }
}
