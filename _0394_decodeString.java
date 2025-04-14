package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;


public class _0394_decodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        int n = s.length();
        Deque<Integer> countD = new ArrayDeque<>();
        Deque<String > strD = new ArrayDeque<>();
        String currentStr = "";
        int k = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k*10+(ch-'0');
            }else if(ch == '['){
                strD.push(currentStr);
                countD.push(k);
                currentStr = "";
                k = 0;
            }else if(ch == ']'){
                StringBuilder sb = new StringBuilder(strD.pop());
                int re = countD.pop();
                for (int j = 0; j < re; j++) {
                    sb.append(currentStr);
                }
                currentStr = sb.toString();
            }else {
                currentStr+=ch;
            }
        }
        return currentStr;
    }
}
