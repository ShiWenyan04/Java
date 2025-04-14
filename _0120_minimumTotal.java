package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _0120_minimumTotal {
    public static void main(String[] args) {
        int [][] triangle = {{2},{3,4}, {6,5,7},{4,1,8,3}};
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer>  list1 = new ArrayList<>();
        for (int [] group: triangle){
            for (int num: group){
                list1.add(num);
            }
            tri.add(new ArrayList<>(list1));
            list1.removeAll(list1);
        }
        System.out.println(Method(tri));
    }
    public static int Method(List<List<Integer>> list){
        int [] f = new int[list.size()];
        for (int i = 0; i < f.length; i++) {
            f[i] = list.get(list.size()-1).get(i);
        }
        for (int i = list.size()-2; i >= 0; i --) {
            for (int j = 0; j <= i; j++) {
                f[j] = Math.min(f[j],f[j+1])+list.get(i).get(j);
            }
        }
        return f[0];
    }
}
