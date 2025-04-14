package LeetCode;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _093_lenLongestFibSubseq {
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Method(arr));
    }
    public static int Method(int [] arr){
        int n = arr.length;
        int []f = new int[n];
        HashMap<Integer,Integer> hashSet = new HashMap<>();
        f[0] = f[1]= 1 ;
        hashSet.put(0,f[0]);
        hashSet.put(1,f[1]);
        if(n > 2){
            for (int i = 2; i < n; i++) {
                f[i] = f[i-1]+f[i-2];
                hashSet.put(i,f[i]);
            }
        }
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(hashSet.containsValue(arr[i])){
                index = hashSet.get(arr[i])+1;
            }
        }
        return 0;
    }
}
