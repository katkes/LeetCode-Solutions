import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution {

	/**
	 * 
	 * Approach: Was pretty hard to get through but the solution goes through the
	 * formula to keep a track of the parenthesis using a stack and crawls back when
	 * the parentheses are balanced. This crawl back pops from the stack to get back
	 * the values of how many of a given atom there is in a given portion of the
	 * formula.
	 * 
	 * Time complexity: O(n) --> Seeing that the forumula is at worst iterated
	 * through twice, the time complexity is linearly related to the input size,
	 * making it O(n).
	 * 
	 * Space complexity: O(n) --> The max stack height is linearly related to the
	 * input size, making it O(n).
	 * 
	 * 
	 * @param formula
	 * @return
	 */
	public String countOfAtoms(String formula) {
		String count = "";
		Stack<String> stack = new Stack<>();
		TreeMap<String, Integer> map = new TreeMap<>();
		int openParanthesisCount = 0;
		int closedParanthesisCount = 0;
		String key;
		char currentCharacter;
		int len = formula.length();
		int i = 0;

		while (i < len) {
			currentCharacter = formula.charAt(i);

			if (openParanthesisCount == 0) {
				if (currentCharacter == '(') {
					stack.push(formula.substring(i, i + 1));
					openParanthesisCount++;
					i++;
					continue;
				}
				// Has to be a letter at this point
				else {
					// Checks if the compound is upper/lower case, ex: Mg, Na
					if (((i + 1) != len) && (Character.isLowerCase(formula.charAt(i + 1)))) {
						key = formula.substring(i, i + 2);

						int startOfNumber = i + 2;
						int endOfNumber = startOfNumber;

						while (endOfNumber < len && Character.isDigit(formula.charAt(endOfNumber))) {
							endOfNumber++;
						}

						if (startOfNumber < endOfNumber) {
							map.put(key, map.getOrDefault(key, 0)
									+ Integer.valueOf(formula.substring(startOfNumber, endOfNumber)));
							i = endOfNumber;
							continue;
						}

						map.put(key, map.getOrDefault(key, 0) + 1);
						i += 2;
						continue;

					}
					// Checks if there's a number after the letter
					else if (((i + 1) != len) && (Character.isDigit(formula.charAt(i + 1)))) {
						key = formula.substring(i, i + 1);

						int startOfNumber = i + 1;
						int endOfNumber = startOfNumber;

						while (endOfNumber < len && Character.isDigit(formula.charAt(endOfNumber))) {
							endOfNumber++;
						}

						map.put(key, map.getOrDefault(key, 0)
								+ Integer.valueOf(formula.substring(startOfNumber, endOfNumber)));
						i = endOfNumber;
						continue;
					}
					// At this point, we're only adding the atomic letter into the map
					else {
						key = formula.substring(i, i + 1);
						map.put(key, map.getOrDefault(key, 0) + 1);
						i++;
						continue;
					}

				}

			} else {
				if (currentCharacter == ')' && (openParanthesisCount == closedParanthesisCount + 1)) {
					// Code to evaluate inner expressions
					int startOfNumber = i + 1;
					int endOfNumber = startOfNumber;

					while (endOfNumber < len && Character.isDigit(formula.charAt(endOfNumber))) {
						endOfNumber++;
					}

					int multiplier = startOfNumber < endOfNumber
							? Integer.parseInt(formula.substring(startOfNumber, endOfNumber))
							: 1;

					crawlBack(stack, multiplier, openParanthesisCount, map);
					// closedParanthesisCount++;
					openParanthesisCount--;
					i = endOfNumber;
					continue;
				}

				// If it's an uppercase character, you want to check the next character is a
				// lower case or not to keep the chemical form intact.
				if (Character.isUpperCase(currentCharacter) && ((i + 1) != len)
						&& (Character.isLetter(formula.charAt(i + 1)))
						&& (!Character.isUpperCase(formula.charAt(i + 1)))) {
					stack.push(formula.substring(i, i + 2));
					i += 2;
					continue;
				}

				if (currentCharacter == '(')
					openParanthesisCount++;
				if (currentCharacter == ')')
					closedParanthesisCount++;

				if (Character.isDigit(currentCharacter)) {
					int startOfNumber = i;
					int endOfNumber = startOfNumber;

					while (endOfNumber < len && Character.isDigit(formula.charAt(endOfNumber))) {
						endOfNumber++;
					}
					stack.push(formula.substring(startOfNumber, endOfNumber));
					i = endOfNumber;
					continue;
				}
				stack.push(formula.substring(i, i + 1));
				i++;
				continue;
			}
		}
		crawlBack(stack, 1, openParanthesisCount, map);
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				count += entry.getKey();
				continue;
			}
			count += entry.getKey() + entry.getValue();
		}

		return count;
	}

	private void crawlBack(Stack<String> stack, int multiplier, int openParanthesisCount,
			TreeMap<String, Integer> map) {
		Stack<Integer> mulitplierStack = new Stack<>();
		char c;
		String str;
		String atomName = "";

		if (multiplier != 1) {
			mulitplierStack.push(multiplier);
		}

		while (openParanthesisCount != 0) {
			if (stack.isEmpty())
				return;
			str = stack.pop();
			c = str.charAt(0);

			// A digit in this case is only ever next to a letter/atom or a parenthesis
			if (Character.isDigit(c)) {
				// Check if it's a multiplier
				if (stack.peek().equals(")")) {
					stack.pop();
					multiplier *= Integer.valueOf(String.valueOf(str));
					mulitplierStack.push(Integer.valueOf(String.valueOf(str)));
					continue;
				}
				// c must represent an amount of an atom that's next to c
				else {
					atomName = stack.pop();
					map.put(atomName, map.getOrDefault(atomName, 0) + multiplier * Integer.valueOf(str));
					continue;
				}
			} else if (c == '(') {

				multiplier /= mulitplierStack.pop();
				openParanthesisCount--;
				continue;
			} else {
				atomName = str;
				map.put(atomName, map.getOrDefault(atomName, 0) + multiplier);
			}
		}
	}
}
