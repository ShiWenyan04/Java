package LanQIao_2023_Guo;
//对于一个含有 M 个数位的正整数 N，任意选中其中 K 个不同的数位（0≤K<M），将这些选中的数位删除之后，
// 余下的数位按照原来的顺序组成了一个新的数字 P。如果至少存在一个 P 是质数，我们就称 N 是一个 X 质数。
// 例如，对于整数 7869，我们可以删去 7 和 6，得到一个新的数字 89，由于 89 是一个质数，因此 7869
// 是一个 X 质数。又如，对于整数 77，可以删去一个 7 后变为质数 7，因此 77 也是一个 X 质数。
//请问 1（含）至 1000000（含）中一共有多少个不同的 X 质数。
public class _1 {
    static int num = 1000000;
    static int []dp = new int[num+1] ,st = new int[num+1];

    // 去除idx位置的值后的新数
    public static int solve(char [] st, int idx){
        int res = 0;
        for(int i=0;i<st.length;i++){
            if(i!=idx){
                res = res*10+st[i]-'0';
            }
        }
        return res;
    }
    public static void main(String[] args) {
        long ans  = 0;


//      判断质数,质数筛
    for(int i=2;i<=num;i++){
        if(st[i] == 0){//如果这个数标记是质数
            dp[i] = 1;//dp数组为1
            if((long)i*i > num){
                continue;
            }
            for(int j=i*i;j<=num;j+=i) {//遍历i的倍数，i的倍数均为合数
                st[j] = 1;
            }
        }

    }
//    判断是不是x质数
        for(int i = 1;i<=num;i++){
            char [] chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int nums = solve(chars,j); // 删除第j个数位后的新数
                dp[i]|=dp[nums];// 如果删除后的新数是质数，则dp[i]也为质数
            }
            if(dp[i] == 1){
                ans++;
            }

        }
        System.out.println(ans);
    }
}
