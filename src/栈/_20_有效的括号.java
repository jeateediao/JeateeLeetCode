package 栈;

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {

	private static HashMap<Character, Character> map = new HashMap<>();
	static {
		// key - value
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			}else {
				if (stack.isEmpty()) return false;
				if (c != map.get(stack.pop())) return false;
			}
		}
		return stack.isEmpty();
	}
}
