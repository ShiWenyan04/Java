package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _0763_partitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(Method(s));
    }
    public static List<Integer> Method(String s){
        int n = s.length();
        int []index = new int[26];
        for (int i = 0; i < n; i++) {
            index[s.charAt(i)-'a'] = i;
        }
        int start = 0,end = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end,index[s.charAt(i)-'a']);
            if(end ==i){
                list.add(end-start+1);
                start = end+1;
            }
        }
        return list;
    }

}
