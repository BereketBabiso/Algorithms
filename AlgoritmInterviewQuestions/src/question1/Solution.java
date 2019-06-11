package question1;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        boolean flag =false;
       for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               if((nums[i]+nums[j]) == target){
                   ret[0]=i;
                   ret[1]=j;
                   flag=true;
                   break;
               }
           }
           if(flag) break;
       }
        return ret;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int k=9;
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.twoSum(nums, k)));

	}

}
