package twoSumInSortedArray;

import java.util.Arrays;

public class TwoSumSortedArray {
	
	public int[] twoSum(int[] input, int target) {
		int[] ret = new int[2];
		boolean flag = false;
		int pos = binarySearch(input,target,0,input.length-1);
		for(int i=0;i<=pos;i++) {
			for(int j=i+1;j<=pos;j++) {
				if(input[i]+input[j]==target) {
					ret[0]=i;
					ret[1]=j;
					flag=true;
					break;
				}
				if(flag) break;
			}
		}
		return ret;
	}
	
	private int binarySearch(int[] arr,int val,int lower,int upper) {
		if(lower>upper) return 0;
		int mid = (lower + upper)/2;
		if(arr[mid]<val) {
			if(arr[mid+1]>val) return mid;
			else {
				binarySearch(arr,val,mid+1,upper);
			}
		}
		else {
			if(arr[mid-1]<val) return mid-1;
			else {
				binarySearch(arr,val,lower,mid-2);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		TwoSumSortedArray tsum = new TwoSumSortedArray();
		int[] arr = {2,7,11,15};
		System.out.println(Arrays.toString(tsum.twoSum(arr, 9)));
		
		

	}

}
