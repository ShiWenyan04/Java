package LeetCode;

public class _0845_longestMountain {
    public static void main(String[] args) {
        int []arr = {2,1,4,7,3,2,5};
        System.out.println(Method(arr));
    }
    public static int Method(int []arr){
        int n = arr.length;
        int []left= new int[n],rigth = new int[n];
        for (int i = 1; i < n; i++) {
            if(left[i] > left[i-1]){
                left[i] = left[i-1]+1;
            }else {
                left[i] = 0;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (rigth[i] > arr[i+1]){
                rigth[i] = rigth[i+1]+1;
            }else {
                rigth[i] = 0;
            }
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && rigth[i] > 0) {
                maxLen = Math.max(maxLen,rigth[i]+left[i]+1);
            }
        }
        return maxLen;
    }
}
