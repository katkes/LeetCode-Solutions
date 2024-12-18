package javasolution;

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		// Start pointers at end and move back
		int p1 = m - 1;
		int p2 = n - 1;

		for (int current = m + n - 1; current >= 0; current--) {
			if (p2 < 0) // exhausted second array, we can stop
				break;

			if (p1 >= 0 && nums1[p1] > nums2[p2]) // if p1 is a valid index AND nums1 has a greater value than nums2
				nums1[current] = nums1[p1--];

			else
				nums1[current] = nums2[p2--]; // p2 is valid due to p2 < 0 check, we add p2 as the previous condition
												// failed
		}
	}
}