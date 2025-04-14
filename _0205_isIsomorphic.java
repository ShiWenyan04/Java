package LeetCode;

import java.util.HashMap;


public class _0205_isIsomorphic {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(Method(s,t));
    }
    public static boolean Method(String a,String b){
        int n = a.length();
        HashMap<Character,Character>map1 = new HashMap<>();
        HashMap<Character,Character>map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char x = a.charAt(i), y = b.charAt(i);
            if(map1.containsKey(x) && map1.get(x)!=y || map2.containsKey(y) && map2.get(y)!=x){
                return false;
            }
            map1.put(x,y);
            map2.put(y,x);
        }
        return true;
    }
}
