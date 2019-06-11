package removeElementFromArrayOnePass;

import java.util.Arrays;

public class Solution {
	
	 public static int removeElement(int[] nums, int val) {
	        int n = nums.length;
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<n-1;j++) {
	        		if(nums[j]==val) {
	        			if(nums[j+1]!=val) {
	        				nums[j] = nums[j+1];
	        				nums[j+1]=val;
	        			}
	        		}
	        	}
	        }
	        int count =0;
	        for(int i=0;i<n;i++) {
	        	if(nums[i]!=val) count++;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,2,3,5,6,3};
		System.out.println("Size of the array after removing 3 :"+removeElement(arr,3));

	}

}
