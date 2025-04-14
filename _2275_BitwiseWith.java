package LeetCode;

public class _2275_BitwiseWith {
    public static void main( String []arg) {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(Method(candidates));
    }
    public static int Method(int [] can){
        int len = 0;
        for (int i = 0; i < 24; i++) {
            int preLen = 0;
            for (int num : can) {
                if((num & (1 << i)) != 0){
                    preLen++;
                }
            }
            len = Math.max(len,preLen);
        }
        return len;
    }
}
