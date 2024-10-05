package javasolution;

import java.util.HashMap;

public class Solution {
	public boolean checkInclusion(String s1, String s2) {

		HashMap<Character, Integer> s1Letters = new HashMap<>();
		HashMap<Character, Integer> s2WindowLetters = new HashMap<>();
		char charToRemove;

		if (s1.length() > s2.length())
			return false;

		for (char c : s1.toCharArray())
			s1Letters.put(c, s1Letters.getOrDefault(c, 0) + 1);

		for (int i = 0; i < s1.length(); i++) {
			s2WindowLetters.put(s2.charAt(i), s2WindowLetters.getOrDefault(s2.charAt(i), 0) + 1);
		}

		if (s1Letters.equals(s2WindowLetters))
			return true;

		for (int i = s1.length(); i < s2.length(); i++) {
		    charToRemove = s2.charAt(i - s1.length());
		    s2WindowLetters.put(charToRemove, s2WindowLetters.get(charToRemove) - 1);
		    if (s2WindowLetters.get(charToRemove) == 0) {
		        s2WindowLetters.remove(charToRemove);
		    }
		    s2WindowLetters.put(s2.charAt(i), s2WindowLetters.getOrDefault(s2.charAt(i), 0) + 1);

		    if (s1Letters.equals(s2WindowLetters))
		        return true;
		}


		return false;
	}
}