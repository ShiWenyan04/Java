package LeetCode;

public class _0518_change {
    public static void main(String[] args) {
        int amount = 5;
        int []coins = {1, 2, 5};
        System.out.println(Method(amount,coins));
    }
    public static int Method(int amt,int []coins){
        int []f = new int[amt+1];
        f[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amt; i++) {
                f[i] += f[i-coin];
            }
        }
       return f[amt];
    }
}
