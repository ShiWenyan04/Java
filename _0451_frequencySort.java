package LeetCode;

import java.util.*;

public class _0451_frequencySort {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        int n = s.length();
        char []ch = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c : ch) {
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> en : list) {
            for (int i = 0; i < en.getValue(); i++) {
                sb.append(en.getKey());
            }
        }
        return sb.toString();
    }
}
