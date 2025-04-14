package LeetCode;

public class _1456_maxVowels {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(Method(s,k));
    }
    public static int Method(String s,int k){
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if(s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u'){
                sum++;
            }
        }
        int max = sum;
        for (int i = 0; i < n-k; i++) {
            if(s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u'){
                sum--;
            }
            if(s.charAt(i+k) == 'a'||s.charAt(i+k) == 'e'||s.charAt(i+k) == 'i'||s.charAt(i+k) == 'o'||s.charAt(i+k) == 'u'){
                sum++;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
