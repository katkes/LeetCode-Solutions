import java.util.Stack;

public class NotOptimalSolution {

	/**
	 * 
	 * Approach: The solution uses the stack's innate ability to reverse an array by
	 * it's LIFO feature. Using this feature, we can reverse an array by pushing
	 * into a stack and popping it out. The idea is that this is done each time a )
	 * character is found until a ( character is found.
	 * 
	 * 
	 * Time complexity: O(n^2) --> At worse, the amount of times the string is
	 * traversed is about the length times half of the length. This makes it O(n^2).
	 * 
	 * Space complexity: O(n) --> Additional storage is only needed to contain at
	 * max all of the characters of the word.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public String reverseParentheses(String s) {

		Stack<Character> stack = new Stack<>();
		String temp = "";

		for (char c : s.toCharArray()) {
			if (c == ')') {
				while (stack.peek() != '(')
					temp += stack.pop();
				stack.pop();
				for (char x : temp.toCharArray()) {
					stack.push(x);
				}
				temp = "";
			}
			stack.push(c);
		}

		for (char c : stack) {
			if ((c == '(') || (c == ')'))
				continue;
			temp += c;
		}

		return temp;
	}
}
