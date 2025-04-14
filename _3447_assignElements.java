package LeetCode;

import java.util.Arrays;

public class _3447_assignElements {
    public static void main(String[] args) {
        int []groups = {8, 4, 3, 2, 4};
        int []elements = {4, 2};
        System.out.println(Arrays.toString(Method(groups,elements)));
    }
    public static int[] Method(int []g,int []e){
       int max = -1;
        for (int i : g) {
            max = Math.max(max,i);
        }
        int []target = new int[max+1];
        Arrays.fill(target,-1);
        for (int i = 0; i < e.length; i++) {
            int x = e[i];
            if(x > max || target[i] >= 0){
                continue;
            }
            for (int j = x; j <= max; j+=x) {
                if(target[j] < 0){
                    target[j] = i;
                }
            }
        }
        for (int i = 0; i < g.length; i++) {
            g[i] = target[g[i]];
        }
        return g;
    }
}
