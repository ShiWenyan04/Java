package LeetCode;

public class _1035_maxUncrossedLines {
    public static void main(String[] args) {
        int []nums1 = {1, 4, 2};
        int []nums2 = {1, 2, 4};
        System.out.println(Method(nums1,nums2));
    }
    public static int Method(int [] nums1,int []nums2){
        int n = nums1.length,m = nums2.length;
        int [][] f = new int[n+1][m+1];
        int maxLen = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    f[i][j] = f[i-1][j-1]+1;
                }else {
                    f[i][j] = Math.max(f[i][j-1],f[i-1][j]);
                }
                maxLen = Math.max(maxLen,f[i][j]);
            }
        }
        return maxLen;
    }
}
