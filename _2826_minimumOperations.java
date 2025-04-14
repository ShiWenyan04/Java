package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _2826_minimumOperations {
    public static void main(String[] args) {
        int []nums = {2,1,3,2,1};
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(Method(list));
    }
    public static int Method(List<Integer>list){
        int []f = new int[4];
        for (Integer x:list) {
            f[x]++;
            f[2] = Math.max(f[2],f[1]);
            f[3] = Math.max(f[3],Math.max(f[2],f[1]));
        }return list.size()-f[3];
    }
}
