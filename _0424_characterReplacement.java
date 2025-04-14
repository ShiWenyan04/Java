package LeetCode;

public class _0424_characterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(Method(s,k));
    }
    public static int Method(String s,int k){
        int n = s.length();
        char [] ch = s.toCharArray();
        int []chCount = new int[26];
        int right = 0,left = 0,maxCount = 0;
        int maxLen = 0;
        while(right < n){
           chCount[ch[right]-'A']++;
           maxCount = Math.max(maxCount,chCount[ch[right]-'A']);
           right++;
           if(maxCount+k < right-left){
               left++;
               chCount[ch[left]-'A']--;
           }
            maxLen = Math.max(maxLen,right-left);
        }
        return maxLen;
    }
}
