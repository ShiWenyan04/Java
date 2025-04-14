package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//示例 2：
//输入：height = [4,2,0,3,2,5]
//输出：9
public class _024_CatchRainwater {
    public static void main(String[] args) {
        int []heights = {4,2,0,3,2,5};
        System.out.println(Method(heights));
    }
    public static int Method(int[] heights){
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        int peek;
        int h ,w, ans=0;
        while(i < heights.length){
            if (deque.isEmpty() || heights[deque.peek()] > heights[i]){
//                “遇见比栈顶小，就存”
                deque.push(i);
            }else {
                peek = deque.pop();
                //根据“遇见比栈顶小，就存”的原则，可知peek'为当前最小的值，是接水池的底
                if (deque.isEmpty()){//谨防0，1，0，2，开头0，1无法存水
                    continue;
                }
                h = Math.min(heights[deque.peek()],heights[i])-heights[peek];
                //高度应该为左右两边最小值-中间最矮的底，即3，0，4，接水的高度应该为 Math.min(3,4)-0;
                w = (i-deque.peek()-1);
                //宽度以上面例子得知，w=最矮值左右两边的跨度
                ans+=h*w;
                i--;
            }
            i++;
        }
        return ans;
    }
}
