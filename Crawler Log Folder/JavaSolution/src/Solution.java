
public class Solution {

	/**
	 * 
	 * Approach: The solution considers three cases per log, go up, stay put or go
	 * down one. If you go up in hierachy, you subtract one to the operations but
	 * ONLY if it's not at zero. (cannot have negative operations) If you go down in
	 * hierarchy, you add one to the operations. Else, by staying put you don't
	 * affect the operations variable.
	 * 
	 * Time complexity: O(n) --> The logs are iterated once, making it linearly
	 * dependent on the input size.
	 * 
	 * Space complexity: O(1) --> No additional space is needed outside of an int
	 * variable. (amount of variables isn't dependent on input size)
	 * 
	 * @param logs
	 * @return
	 */
	public int minOperations(String[] logs) {
		int operations = 0;

		for (String str : logs) {
			switch (str) {

			case ("../"):
				if (operations == 0)
					break;
				operations--;
				break;
			case ("./"):
				break;
			default:
				operations++;
				break;
			}
		}

		return operations;
	}
}
