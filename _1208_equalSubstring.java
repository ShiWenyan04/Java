package LeetCode;


public class _1208_equalSubstring {
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(Method(s,t,maxCost));
    }
    public static int Method(String s,String t,int k){
        int n = s.length();
        char [] sch = s.toCharArray();
        char [] tch = t.toCharArray();
        int right = 0,left = 0,cnt = 0;
        int maxLen = 0;
        while(right < n){
            int diff = Math.abs(sch[right]-tch[right]);
            if(diff < k){
                cnt += diff;
            }
            right++;
            while (cnt > k){
                int d = Math.abs(sch[left]-tch[left]);
                if(d < k){
                    cnt-= d;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left);
        }
        return maxLen;
    }
}
