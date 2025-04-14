package LeetCode;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10

import ShiYan6_2.Method;

import java.util.ArrayDeque;
import java.util.Deque;

//输入： heights = [2,4]
//输出： 4
public class _084_MaximumRectangularArea_II {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(Method(heights));
    }
    public static int Method(int[] heights){//利用栈，大于栈顶就保存，小于栈顶，当前栈顶的所对应的heights即为最高，只需乘宽
        int n = heights.length,ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        int peek;
        while (i <= n){
            if (i == n && deque.isEmpty()){
                break;
            }
            if (i < n && (deque.isEmpty() || heights[i]>heights[deque.peek()])){
                //大于栈顶，栈顶为空时，保存
                deque.push(i);
            }else {
//                小于栈顶，栈顶做高，i-栈顶下一个索引元素-1；
                peek = deque.poll();//peek作为当前的高，用过即删
                ans = Math.max(ans,heights[peek]*(deque.isEmpty()? i:(i-deque.peek()-1)));
                //如果栈为空，那就乘当前索引值，如果栈不为空就乘(i-deque.poll()-1)
                i--;
            }
            i++;
        }
        return ans;
    }
}
