package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1190_reverseParentheses {
	public static void main(String[] arg) {
		String str = "(u(love)i)";
		System.out.println(Method(str));
	}
	public static String Method(String str) {
		Deque <String> deque = new ArrayDeque<>();
		char []ch = str.toCharArray();
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] == '(') {
				deque.push(sBuilder.toString());
				sBuilder.setLength(0);
			}else if (ch[i] == ')') {
				sBuilder.reverse();
				sBuilder.insert(0, deque.poll());
				
			} else {
				sBuilder.append(ch[i]);
			}
		}
		return sBuilder.toString();
	}
}
