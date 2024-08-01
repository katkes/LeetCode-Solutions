package javasolution;

public class Solution {
	public int[] sortArray(int[] nums) {
		heapSort(nums);

		return nums;
	}

	public void heapSort(int[] arr) {
		int len = arr.length;

		// Build heap
		for (int i = (len / 2) - 1; i >= 0; i--) {
			heapify(arr, len, i);
		}

		for (int i = len - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	public void heapify(int[] arr, int len, int i) {

		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// If the left child is larger than the root
		if (left < len && arr[left] > arr[largest])
			largest = left;

		// If right child is larger than the root
		if (right < len && arr[right] > arr[largest])
			largest = right;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, len, largest);
		}
	}
}