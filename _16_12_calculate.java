package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _16_12_calculate {
    public static void main(String[] args) {
        String str = "3+2*2";
        System.out.println(Method(str));
    }
    public static int Method(String str){
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        char ch = '+';
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(str.charAt(i))){
                num = num*10+str.charAt(i)-'0';
            }
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' '|| i== n-1){
                switch (ch){
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.pop()*num);
                        break;
                    default: deque.push(deque.pop()/num);
                }
                num = 0;
                ch = str.charAt(i);
            }
        }
        int ans = 0;
        for (Integer i : deque) {
            ans+=i;
        }
        return ans;
    }
}
