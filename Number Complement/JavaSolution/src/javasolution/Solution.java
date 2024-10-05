package javasolution;

public class Solution {
	public int findComplement(int num) {
		String base = Integer.toBinaryString(num);

		String complementTwos = "";

		for (char c : base.toCharArray()) {
			if (c == '0')
				complementTwos += "1";
			else
				complementTwos += "0";
		}

		return Integer.parseInt(complementTwos, 2);
	}
}
