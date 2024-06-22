import java.util.Stack;

public class StackSolution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				stack.add(c);
			} else {
				if (stack.isEmpty())
					return false;
				switch (c) {
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
						break;
					} else {
						return false;
					}
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
						break;
					} else {
						return false;
					}
				case ')':
					if (stack.peek() == '(') {
						stack.pop();
						break;
					} else {
						return false;
					}
				default:
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}