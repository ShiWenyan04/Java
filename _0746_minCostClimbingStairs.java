package LeetCode;

public class _0746_minCostClimbingStairs {
    public static void main(String [] arg){
        int []cost = {10,15,20};
        System.out.println(Method(cost));
    }
    public static int Method(int []cost){
        int n = cost.length;
        int []f = new int[n+1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i-1]+cost[i-1],f[i-2]+cost[i-2]);
        }
        return f[n];
    }
}
