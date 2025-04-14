package LeetCode;

public class _2294_minimumCoins {
    public static void main(String[] args) {
        int [] prices = {3,1,2};
        int []m = new int [prices.length];
        System.out.println(dfs(1,prices,m));
    }
    public static int dfs(int i,int [] p,int[] m){
        if(i*2 >= p.length){//i从1开始
            return p[i-1];
        }
        if(m[i]!= 0){//之前已经算过
            return m[i];
        }
        int res = Integer.MAX_VALUE;
        for (int j = i; j < 2*i+1; j++) {//范围再i~2*i
            res = Math.min(res,dfs(j+1,p,m));
        }
        return m[i] = res + p[i-1];//要加上当前的水果金额
    }
}
