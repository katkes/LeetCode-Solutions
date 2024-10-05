
public class Solution {
	
	/**
	 * 
	 * Approach: 
	 * 
	 * 
	 * 
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int getLucky(String s, int k) {

		int num = 0;
		String num1 = "";
		int num2 = 0;

		for (char c : s.toCharArray()) {
			num1 = String.valueOf(c - 'a' + 1) + num1;
		}

		while (k > 0) {
			for (char c : num1.toCharArray()) {
				num2 += c - '0';
			}

			num1 = String.valueOf(num2);
			num = num2;
			num2 = 0;
			k--;
		}

		return num;
	}
}
