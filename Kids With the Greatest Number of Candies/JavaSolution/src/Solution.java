import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * Approach: The solution's idea is if there's a known maximum number of candies
	 * then we can see if any sum of a kid's candy will beat that max using two
	 * iterations of the list of candies. The first iteration will see what is the
	 * maximum to beat and the second iteration checks (and adds to a list) whether
	 * the max is beaten or not having added the extra positions at any i-th
	 * position.
	 * 
	 * Time complexity: Theta(n) --> The list is iterated to be looped through
	 * exactly twice. This makes it that the runtime at worst and best for the
	 * iterations to be O(2n) which is O(n). As well, the variable initialization
	 * only happens once which in total results in O(n+1) which is just O(n)
	 * 
	 * Space complexity: O(n) --> A new ArrayList of the same size is constructed,
	 * along with an int variable that holds the max number of candies, resulting in
	 * O(n+1) which comes down to O(n)
	 * 
	 * 
	 * @param candies -- The list where any given index is the # of candies of that kid.
	 * @param extraCandies -- The number of surplus candies which is to be added on.
	 * @return -- An ArrayList where each position represents whether having added
	 *         the surplus candies to that position makes it the new max or equal to
	 *         the old max.
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0; // Highest number of candies of any single child
		List<Boolean> returnList = new ArrayList<Boolean>(); 

		// Find what is the maximum of the array
		for (int x : candies) {
			if (x > max)
				max = x;
		}

		// See if each index would be the greatest number with the extra candies
		for (int x : candies) {
			returnList.add(x + extraCandies >= max);
		}

		return returnList;
	}
}
