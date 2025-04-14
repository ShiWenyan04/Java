package LeetCode;

import java.util.HashMap;

public class _3137_minimumOperationsToMakeKPeriodic {
    public static void main(String []arg){
        String word = "leetcodeleet";
        int k = 4;
        System.out.println(Method(word,k));
    }
    public static int Method(String word,int k){
        int n = word.length();
        int res = Integer.MAX_VALUE;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i+=k) {
            String str = word.substring(i,i+k);
            res = Math.min(res,n/k-hashMap.merge(str,1,Integer::sum));
        }
        return res;
    }
}
