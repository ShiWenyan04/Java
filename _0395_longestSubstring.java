package LeetCode;


public class _0395_longestSubstring {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(Method(s,k));
    }
    public static int Method(String s,int k){
        int [] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)-'a']++;// 通过字符的ASCII值计算字符的索引
        }

        for (int i = 0; i < n; i++) {
            if(count[s.charAt(i)-'a'] < k){
                int l = Method(s.substring(0,i),k);
                int r = Method(s.substring(i+1,n),k);
                return Math.max(l,r);
            }
        }
        return n;
    }
}
