package SearchInRotatedSortedArray;

/*
	 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	
	(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	Example: 
		Input: nums = [4,5,6,7,0,1,2], target = 0
	    Output: 4
	    
	    Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1
 */

public class SearchRotatedSortedArray {
	
	public int search(int[] nums, int target) {
		if(nums.length==0) return -1;
        return binSearch(nums,target,0,nums.length-1);
    }
	private int binSearch(int[] nums, int target, int lower, int upper) {
		if(nums.length==1) {
			if(nums[0]==target) return 0;
			else return -1;
		}
		if(lower>upper) return -1;		
		if(upper==lower+1) {
			if(nums[lower]==target) return lower;
			else if(nums[upper]==target) return upper;
			else return -1;
		}
		int m = (lower+upper)/2;
		if(nums[m]==target) return m;
		if(isBetween(nums[0],nums[m-1],target)) return binSearch(nums,target,lower,m-1);
		else return binSearch(nums,target,m+1,upper);		
	}
	private boolean isBetween(int x,int y,int t) {
		if(x<y) {
			if(x<=t && t<=y) return true;
			else return false;
		}
		else if(y<x) {
			if(y<=t && t<=x) return true;
			else return false;
		}
		else {
			if(x==t) return true;
			else return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchRotatedSortedArray srsa = new SearchRotatedSortedArray();
		int[] nums1 = {4,5,6,7,0,1,2};
		int[] nums2 = {6,7,1,2,3,4,5};
		int[] nums3 = {3,5,1,2};
		int[] nums4 = {8,9,10,0,1,2,3,4,5};
		System.out.println(srsa.search(nums1, 0));
		System.out.println(srsa.search(nums2, 6));
		System.out.println(srsa.search(nums3, 2));
		System.out.println(srsa.search(nums4, 9));

	}

}
