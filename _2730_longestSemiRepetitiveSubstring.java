package LeetCode;

public class _2730_longestSemiRepetitiveSubstring {
    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        if(s.length() == 1){
            return 1;
        }
        int n = s.length();
        char []ch = s.toCharArray();
        int left = 0,right = 1;
        int same = 0;
        int res = 0;
        while(right < n){
            if(ch[right] == ch[right-1]){
                same++;
            }
            if(same > 1){
                left++;
                while (ch[left] != ch[left-1]){
                    left++;
                }
                same=1;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
