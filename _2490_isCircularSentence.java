package LeetCode;

public class _2490_isCircularSentence {
    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(Method(sentence));
    }
    public static boolean Method(String s){
        if(s.charAt(0)!=s.charAt(s.length()-1)){
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                if(s.charAt(i-1) != s.charAt(i+1)){
                    return false;
                }
            }
        }
        return true;
    }
}
