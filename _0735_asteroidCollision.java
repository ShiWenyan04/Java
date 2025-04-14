package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0735_asteroidCollision {
    public static void main(String[] args) {
        int [] asteroids = {5,10,-5};
        System.out.println(Method(asteroids));
    }
    public static int [] Method(int [] ast){
        int n = ast.length;
        Deque< Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = ast[i];
            boolean alive = true;
            while(alive &&!deque.isEmpty() && deque.peek() > 0 && ast[i] < 0 ){
                alive = deque.peek() < -num;
                if(Math.abs(num) >= deque.peek()) {
                    deque.poll();
                }
            }
            if (alive){
                deque.push(num);
            }
        }
        int len = deque.size();
        int []ans = new int[len];
        for (int i = len-1; i >= 0; i--) {
            ans[i] = deque.pop();
        }
        return ans;
    }
}
