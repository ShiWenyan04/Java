package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//示例 1：
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
//示例 2：
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
//示例 3：
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5=22
public class _0150_EvaluateTheInversePolandExpression {
    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(Method(tokens));
    }
    public static int Method(String[] tokens){
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        while(i < tokens.length){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                deque.push(Integer.valueOf(tokens[i]));//遇见数字就存
            }else{//遇见符号判断，并从栈顶取出两个数
                int a = deque.poll(),b = deque.poll();
                int preAns;
                switch (tokens[i]) {//由于顺序刚好相反，所以是b*a，其他也是
                    case "*":
                        preAns = b * a;
                        deque.push(preAns);//每次计算完之后将计算结果压入栈顶
                        break;
                    case "+":
                        preAns = b + a;
                        deque.push(preAns);
                        break;
                    case "-":
                        preAns = b - a;
                        deque.push(preAns);
                        break;
                    case "/":
                        preAns = b / a;
                        deque.push(preAns);
                        break;
                }
            }
            i++;
        }
        return deque.poll();//只需返回栈顶元素即可
    }
}
