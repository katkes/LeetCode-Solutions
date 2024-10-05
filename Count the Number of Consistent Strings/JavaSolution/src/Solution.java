import java.util.HashSet;

public class Solution {
	
	
	/***
	 * 
	 * Approach: 
	 * 
	 * 
	 * Time complexity: 
	 * 
	 * 
	 * Space complexity: 
	 * 
	 * 
	 * 
	 * 
	 * @param allowed
	 * @param words
	 * @return
	 */
	
	
	
	public int countConsistentStrings(String allowed, String[] words) {
		HashSet<Character> set = new HashSet<>();
		int numConsistentStrings = 0;
		boolean temp = false;

		for (char c : allowed.toCharArray())
			set.add(c);

		for (String word : words) {
			temp = true;
			for (char c : word.toCharArray()) {
				if (!set.contains(c))
					temp = false;
			}
			if (temp)
				numConsistentStrings++;
		}

		return numConsistentStrings;
	}
}
