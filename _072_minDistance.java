package LeetCode;

public class _072_minDistance {
    public static void main(String[] args) {
        String a =  "horse",b = "ros";
        System.out.println(Method(a,b));
    }
    public static int Method(String a,String b){
        int n = a.length(),m = b.length();
        int [][]f = new int[n+1][m+1];
        if(n*m==0){// 有一个字符串为空串
            return n+m;
        }
        // 边界状态初始化
        for (int i = 0; i < n+1; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j < m+1; j++) {
            f[0][j] = j;
        }
        // 计算所有 DP 值
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int temp1 = f[i-1][j]+1,
                        temp2 = f[i][j-1]+1,
                        temp3 = f[i-1][j-1];
                if(a.charAt(i-1) != b.charAt(j-1)){
                    temp3+=1;
                }
                f[i][j] = Math.min(temp1,Math.min(temp2,temp3));
            }
        }
        return f[n][m];
    }
}
