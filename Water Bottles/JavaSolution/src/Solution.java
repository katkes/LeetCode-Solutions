
public class Solution {

	/**
	 * Approach: The idea is to continuously update the number of bottles while
	 * keeping a tally of empty bottles. The reasoning is that there's two states a
	 * bottle can be in, full or empty, and if you have the total number of bottles
	 * and number of empty bottles, you can subtract the two to get the number of
	 * full bottles which becomes important to adding to the number of drank bottle.
	 * The solution takes a logarithmic iterative approach where each iteration
	 * starts by drinking all the full bottles. The next step is to calculate the
	 * amount of empty bottles you get by exchanging all the empty bottles. The last
	 * step in the iteration is to update the total number of bottles by summing the
	 * number of empty bottles with the new number of full bottles which is
	 * represented by the division of the total number of bottles (that are empty
	 * after the first step) by the numExchange variable. This repeats until there
	 * are no empty bottles.
	 * 
	 * Time complexity: O(log(n)) --> The solution is logarithmic in regards to the
	 * input size, numBottles, continuously being divided by a constant number,
	 * numExchange.
	 * 
	 * Space complexity: O(1) --> The solution only ever creates 2 int variables and
	 * updates them plus the input variable of numBottles. The extra space is
	 * created independently of the input size.
	 * 
	 * @param numBottles
	 * @param numExchange
	 * @return
	 */
	public int numWaterBottles(int numBottles, int numExchange) {
		int drankBottles = 0;
		int emptyBottles = 0;

		while (numBottles - emptyBottles != 0) {
			drankBottles += numBottles - emptyBottles;
			emptyBottles = numBottles % numExchange;
			numBottles = emptyBottles + (numBottles / numExchange);
		}

		return drankBottles;
	}
}