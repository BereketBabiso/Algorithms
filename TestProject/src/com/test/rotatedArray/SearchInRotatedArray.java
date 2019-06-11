package com.test.rotatedArray;

public class SearchInRotatedArray {
	
	public static int search(int[] array, int target) {
		if(array==null || array.length==0) return -1;
		return binarySearch(array, target, 0, array.length-1);
	}

	private static int binarySearch(int[] array, int target, int lower, int upper) {
		int mid = (lower + upper)/2;
		if(array[mid] == target) return mid;
		if(array[lower] < array[upper]) return binSearch(array,target,lower,upper);
		if(lower<upper) {
			if(array[mid] < target) {
				if(array[lower]<target && array[upper]>target) return binarySearch(array,target,mid+1,upper);
				else return binarySearch(array,target,lower, mid-1);
			} else {
				if(array[upper]<target && array[lower]>target) return binarySearch(array,target,lower,mid-1);
				else return binarySearch(array,target,mid+1,upper);
			}
		}
		return -1;
	}
	
	private static int binSearch(int[] array, int target, int lower, int upper) {
		int mid = (lower + upper)/2;
		if(array[mid] == target) return mid;
		if(lower<upper) {
			if(array[mid]<target) return binSearch(array,target,mid+1,upper);
			else return binSearch(array,target,lower,mid-1);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = {4,5,6,7,0,1,2};
		System.out.println(SearchInRotatedArray.search(nums1,0));
		int[] nums2 = {6,7,1,2,3,4,5};
		System.out.println(SearchInRotatedArray.search(nums2, 6));
		int[] nums4 = {8,9,10,0,1,2,3,4,5};
		System.out.println(SearchInRotatedArray.search(nums4,9));

	}

}
