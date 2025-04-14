package LeetCode;

public class _0673_findNumberOfLIS {
    public static void main(String[] args) {
        int [] nums = {1,3,5,4,7};
        System.out.println(Method(nums));
    }
    public static int Method(int [] nums){
        int n = nums.length;
        int []f = new int[n];
        int []g = new int[n];//
        f[0] = 1;
        g[0] =1;
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            g[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    if (f[i] < f[j]+1){
                        f[i] = f[j]+1;
                        g[i] = g[j];
                    }else if (f[i] == f[j]+1){
                        g[i]+=g[j];
                    }
                }
                maxLen = Math.max(f[i],maxLen);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(maxLen == f[i]){
                count+=g[i];
            }
        }
        return count;
    }
}
