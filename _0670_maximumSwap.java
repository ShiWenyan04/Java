package LeetCode;

public class _0670_maximumSwap {
    public static void main(String[] args) {
        int num = 2736;
        System.out.println(Method(num));
    }
    public static int Method(int num){
        char[]ch = String.valueOf(num).toCharArray();
        int max = -1;
        int idx = 0;
        for (int i = 0; i < ch.length-1; i++) {
            max = Math.max(max,ch[i]-'0');
            idx = max == ch[i]-'0' ? i : idx;
        }
        if(idx != 0) {
            ch[0] = (char) ((char) max + '0');
            return Integer.parseInt(String.valueOf(ch));
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
