
public class Solution {

	/**
	 * 
	 * Approach: The solution boils down to recognizing the synchronization problem
	 * at hand: customers either wait or don't. Having this dual state, we separate
	 * the code into a section where the customer waits additional time for the chef
	 * to be idle and then have include the time where the customer waits for the
	 * chef to cook. With all of this, it compounds on itself and get the solution
	 * iteratively customer by customer.
	 * 
	 * Time complexity: O(n) --> The customers are each consulted. The run time is
	 * linearly dependent on the size of the customers (i.e: number of customers)
	 * which itself is the input size.
	 * 
	 * Space complexity: O(1) --> The solution creates only two int variables which
	 * is constantly updated with the inplace arrays. No additional space is added
	 * in regards to the input size, making it effectively O(1).
	 * 
	 * 
	 * @param customers
	 * @return
	 */
	public double averageWaitingTime(int[][] customers) {
		double totalWaitTime = 0;
		int currentTime = 0;

		for (int[] customer : customers) {
			if (currentTime <= customer[0]) { // Chef is idle
				totalWaitTime += customer[1];
				currentTime = customer[0] + customer[1];

			} else { // Chef is busy, have to account to additional waiting time.
				totalWaitTime += (currentTime - customer[0]) + customer[1];
				currentTime += customer[1];
			}

		}
		return totalWaitTime / customers.length;
	}

}
