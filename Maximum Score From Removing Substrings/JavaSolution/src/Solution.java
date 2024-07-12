import java.util.Stack;

public class Solution {
	private int maxGain;

	public int maximumGain(String s, int x, int y) {
		maxGain = 0;
		s = processString(s, (x > y) ? "ab" : "ba", Math.max(x, y));
		s = processString(s, (x < y) ? "ab" : "ba", Math.min(x, y));

		return maxGain;
	}

	private String processString(String s, String target, int points) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == target.charAt(1) && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
				stack.pop();
				maxGain += points;
			} else {
				stack.push(c);
			}
		}

		StringBuilder remainingString = new StringBuilder();
		while (!stack.isEmpty()) {
			remainingString.insert(0, stack.pop());
		}

		return remainingString.toString();

	}
}
