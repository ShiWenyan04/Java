package LeetCode;

public class _2024_maxConsecutiveAnswers {
    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(Method(answerKey,k));
    }
    public static int Method(String ans,int k){
        int n = ans.length();
        int right = 0,left = 0,tCount =0,fCount = 0;
        int maxLen = 0;
        char[]ch = ans.toCharArray();
        while(right <n){
            if(ch[right] == 'F'){
                fCount ++;
            }else {
                tCount++;
            }
            right++;
            while(tCount > k&&fCount>k){
                if(ch[left] == 'F'){
                    fCount--;
                }else {
                    tCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,tCount+fCount);
        }
        return maxLen;
    }
}
