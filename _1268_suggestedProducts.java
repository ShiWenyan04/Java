package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1268_suggestedProducts {
    public static void main(String[] args) {
        String [] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(Method(products,searchWord));
    }
    public static List<List<String>> Method(String [] p,String s){
        Arrays.sort(p);
        StringBuilder sb = new StringBuilder();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            List<String> list = new ArrayList<>();
            for (int j = 0; j < p.length; j++) {
                if(p[j].startsWith(sb.toString())){
                    list.add(p[j]);
                }
                if(list.size() == 3){
                    break;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
