
public class Solution {

	/**
	 * 
	 * Approach: The solution iterates through the main tank by reducing it by 5 and
	 * following the rule that if you use 5, 1 litre gets added to the tank each
	 * time.
	 * 
	 * Time complexity: O(n) --> The time it takes to go through it is linearly
	 * dependent on the size of main tank, effectively making it O(n).
	 * 
	 * Space complexity: O(1) --> No extra storage is ever needed outside of one int
	 * pointer.
	 * 
	 * @param mainTank
	 * @param additionalTank
	 * @return
	 */
	public int distanceTraveled(int mainTank, int additionalTank) {
		int litresConsumed = 0;

		while (mainTank != 0) {
			if (mainTank >= 5) {
				mainTank -= 5;
				if (additionalTank != 0) {
					additionalTank--;
					mainTank++;
				}
				litresConsumed += 5;
			} else {
				litresConsumed += mainTank;
				break;
			}
		}

		return litresConsumed * 10;
	}
}
