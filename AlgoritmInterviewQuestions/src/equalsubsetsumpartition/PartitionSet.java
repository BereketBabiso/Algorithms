package equalsubsetsumpartition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionSet {
	List<Integer> list = new LinkedList<>();
	int sum2;
	
	public boolean canPartition(int[] nums) {
		if(nums == null || nums.length<=1) return false;
		return partition(nums, nums.length-1);
	}
	
	public boolean partition(int[] nums, int k) {
		if(k<0) return false;
		if(nums.length<=1) return false;
		if(list.size() == nums.length-1) return false;
		int x = nums[k];
		list.add(x);
		if(checkEquality(nums)) {
			return true;
		}
		if(partition(nums, k-1)) {
			return true;
		}else {
			list.remove(list.size()-1);
		}
		return partition(nums,k-1);
		
	}

	private boolean checkEquality(int[] nums) {
		long start = System.currentTimeMillis();
		int sum1 = list.stream().reduce(0,(a,b)-> (a+b));
		if(sum2==0) {
		for(int i=0;i<nums.length;i++) {
			sum2+=nums[i];
		}
		}
		System.out.println("checking sum : "+(start - System.currentTimeMillis()));
		return sum2 - sum1 == sum1;
	}

	public static void main(String[] args) {
		int[] arr = { 28, 63, 95, 30, 39, 16, 36, 44, 37, 100, 61, 73, 32, 71, 100, 2, 37, 60, 23, 71, 53, 70, 69, 82,
				97, 43, 16, 33, 29, 5, 97, 32, 29, 78, 93, 59, 37, 88, 89, 79, 75, 9, 74, 32, 81, 12, 34, 13, 16, 15,
				16, 40, 90, 70, 17, 78, 54, 81, 18, 92, 75, 74, 59, 18, 66, 62, 55, 19, 2, 67, 30, 25, 64, 84, 25, 76,
				98, 59, 74, 87, 5, 93, 97, 68, 20, 58, 55, 73, 74, 97, 49, 71, 42, 26, 8, 87, 99, 1, 16, 79 };
		PartitionSet ps = new PartitionSet();
//		System.out.println("result : " + ps.canPartition(arr));
		int [] a1 = {1,2};
		int [] a2 = {1,2};
		System.out.println(Arrays.asList(a1).equals(Arrays.asList(a2)));
	}

}
