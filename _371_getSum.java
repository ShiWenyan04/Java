package LeetCode;

public class _371_getSum {
    public static void main(String[] args) {
        int a = 1, b= 2;
        System.out.println(Method(a,b));
    }
    public static int Method(int a,int b){
        while(b != 0){
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}
