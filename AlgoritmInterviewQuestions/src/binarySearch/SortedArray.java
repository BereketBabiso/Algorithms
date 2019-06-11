package binarySearch;

/**
 * 
 * @author berek Given a sorted array, and a target , search if the target
 *         exists in the array and return the index
 *
 */
public class SortedArray {

	public static int searchInsert(int[] nums, int target) {
		return nums.length == 0 ? 0 : binSearch(nums, target, 0, nums.length - 1);
	}

	private static int binSearch(int[] arr, int target, int i, int j) {
		int m = (i + j) / 2;
		if (arr[m] == target)
			return m;
		if (i > j) {
			return helper(arr, i, j, target);
		}
		return arr[m] < target ? binSearch(arr, target, m + 1, j) : binSearch(arr, target, i, m - 1);
	}

	private static int helper(int[] arr, int i, int j, int target) {
		if (j < 0)
			return i;
		if (i >= arr.length)
			return arr.length;
		return arr[i] < target ? i + 1 : i;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 11, 19, 20 };
		System.out.println(SortedArray.searchInsert(arr, 10));

	}

}
